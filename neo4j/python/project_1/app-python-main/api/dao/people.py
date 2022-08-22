from api.data import people, pacino
from api.exceptions.notfound import NotFoundException


class PeopleDAO:
    """
    The constructor expects an instance of the Neo4j Driver, which will be
    used to interact with Neo4j.
    """

    def __init__(self, driver):
        self.driver = driver

    """
    This method should return a paginated list of People (actors or directors),
    with an optional filter on the person's name based on the `q` parameter.

    Results should be ordered by the `sort` parameter and limited to the
    number passed as `limit`.  The `skip` variable should be used to skip a
    certain number of rows.
    """
    # tag::all[]
    def all(self, q, sort = 'name', order = 'ASC', limit = 6, skip = 0):
        # TODO: Get a list of people from the database
        # TODO: Remember to use double braces to replace the braces in the Cypher query {{ }}
        def list_people(tx, q, sort, order, limit, skip):
            cypher_statement="""
                    MATCH (p:Person)
                    WHERE $q IS NULL OR p.name CONTAINS $q
                    RETURN p {{ .* }} AS person
                    ORDER BY p.`{0}` {1}
                    SKIP $skip
                    LIMIT $limit
                  """.format(sort, order)
            return tx.run(cypher_statement, q=q, limit=limit, skip=skip).value("person")

        with self.driver.session() as session:
            return session.read_transaction(list_people, q, sort, order, limit, skip)
        ##return people[skip:limit]
    # end::all[]

    """
    Find a user by their ID.

    If no user is found, a NotFoundError should be thrown.
    """
    # tag::findById[]
    def find_by_id(self, id):
        # TODO: Find a user by their ID
        def get_person(tx, id):
            cypher_statement="""
                MATCH (p:Person {tmdbId: $id})
                RETURN p {
                      .*,
                    actedCount: size((p)-[:ACTED_IN]->()),
                    directedCount: size((p)-[:DIRECTED]->())
                } AS person
                """
            first =  tx.run(cypher_statement, id=id).single()

            if first == None:
                raise NotFoundException()
                
            return first.get("person")

        with self.driver.session() as session:
            return session.read_transaction(get_person,id)

        ##return pacino

    # end::findById[]

    """
    Get a list of similar people to a Person, ordered by their similarity score
    in descending order.
    """
    # tag::getSimilarPeople[]
    def get_similar_people(self, id, limit = 6, skip = 0):
        # TODO: Get a list of similar people to the person by their id
        def get_similar(tx, id, limit, skip):
            cypher_statement="""
                    MATCH (:Person {tmdbId: $id})-[:ACTED_IN|DIRECTED]->(m)<-[r:ACTED_IN|DIRECTED]-(p)
                    RETURN p {
                      .*,
                      actedCount: size((p)-[:ACTED_IN]->()),
                      directedCount: size((p)-[:DIRECTED]->()),
                      inCommon: collect(m {.tmdbId, .title, type: type(r)})
                    } AS person
                    ORDER BY size(person.inCommon) DESC
                    SKIP $skip
                    LIMIT $limit
                  """
            return tx.run(cypher_statement, id=id, limit=limit, skip=skip).value("person")

        with self.driver.session() as session:
            return session.read_transaction(get_similar, id, limit, skip)

        ##return people[skip:limit]
    # end::getSimilarPeople[]