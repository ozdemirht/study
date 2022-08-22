from unittest import result
from api.data import popular, goodfellas

from api.exceptions.notfound import NotFoundException
from api.data import popular

class MovieDAO:
    """
    The constructor expects an instance of the Neo4j Driver, which will be
    used to interact with Neo4j.
    """
    def __init__(self, driver):
        self.driver = driver


    """
     This method should return a paginated list of movies ordered by the `sort`
     parameter and limited to the number passed as `limit`.  The `skip` variable should be
     used to skip a certain number of rows.

     If a user_id value is suppled, a `favorite` boolean property should be returned to
     signify whether the user has added the movie to their "My Favorites" list.
    """
    # tag::all[]
    def all(self, sort, order, limit=6, skip=0, user_id=None):
        # TODO: Get list from movies from Neo4j
        """
        """
        def get_movies(tx, sort, order, limit, skip, user_id):
            
            favorites = self.get_user_favorites(tx, user_id)

            cypher_statement = """
                MATCH (m:Movie)
                WHERE exists(m.`{0}`)
                RETURN m {{ .*, favorite: m.tmdbId IN $favorites }} AS movie
                ORDER BY m.`{0}` {1}
                SKIP $skip
                LIMIT $limit
                """.format(sort, order)
            
            result = tx.run(cypher_statement, limit=limit, skip=skip, user_id=user_id, favorites=favorites)
            
            return [row.value("movie") for row in result]

        with self.driver.session() as session:
            return session.read_transaction(get_movies, sort, order, limit, skip, user_id)

        # return popular
    # end::all[]


    """
    This method should return a paginated list of movies that have a relationship to the
    supplied Genre.

    Results should be ordered by the `sort` parameter, and in the direction specified
    in the `order` parameter.
    Results should be limited to the number passed as `limit`.
    The `skip` variable should be used to skip a certain number of rows.

    If a user_id value is suppled, a `favorite` boolean property should be returned to
    signify whether the user has added the movie to their "My Favorites" list.
    """
    # tag::getByGenre[]
    def get_by_genre(self, name, sort='title', order='ASC', limit=6, skip=0, user_id=None):
        # TODO: Get Movies in a Genre
        # TODO: The Cypher string will be formated so remember to escape the braces: {{name: $name}}
        # MATCH (m:Movie)-[:IN_GENRE]->(:Genre {name: $name})
        def list_movies_by_genre(tx, name, sort, order, limit, skip, user_id):
            cypher_statement="""
                    MATCH (m:Movie)-[:IN_GENRE]->(:Genre {{ name: $name }})
                    RETURN m {{ .* }} AS movie
                    ORDER BY m.`{0}` {1}
                    SKIP $skip
                    LIMIT $limit
                    """.format(sort, order)
            return tx.run(cypher_statement, name=name, sort=sort, order=order, limit=limit, skip=skip, userId=user_id).value("movie")

        with self.driver.session() as session:
            return session.read_transaction(list_movies_by_genre, name, sort, order, limit, skip, user_id)
        #return popular[skip:limit]
    # end::getByGenre[]

    """
    This method should return a paginated list of movies that have an ACTED_IN relationship
    to a Person with the id supplied

    Results should be ordered by the `sort` parameter, and in the direction specified
    in the `order` parameter.
    Results should be limited to the number passed as `limit`.
    The `skip` variable should be used to skip a certain number of rows.

    If a user_id value is suppled, a `favorite` boolean property should be returned to
    signify whether the user has added the movie to their "My Favorites" list.
    """
    # tag::getForActor[]
    def get_for_actor(self, id, sort='title', order='ASC', limit=6, skip=0, user_id=None):
        # TODO: Get Movies for an Actor
        # TODO: The Cypher string will be formated so remember to escape the braces: {{tmdbId: $id}}
        # MATCH (:Person {tmdbId: $id})-[:ACTED_IN]->(m:Movie)
        def list_movies_by_actor(tx, id, sort, order, limit, skip, user_id):
            cypher_statement="""
                    MATCH (:Person {{ tmdbId: $id }})-[:ACTED_IN]->(m:Movie)
                    RETURN m {{ .* }} AS movie
                    ORDER BY m.`{0}` {1}
                    SKIP $skip
                    LIMIT $limit
                    """.format(sort, order)
            return tx.run(cypher_statement, id=id
                            , sort=sort, order=order
                            , limit=limit, skip=skip, userId=user_id).value("movie")

        
        with self.driver.session() as session:
            return session.read_transaction(list_movies_by_actor, id, sort, order, limit, skip, user_id)

        #return popular[skip:limit]
    # end::getForActor[]

    """
    This method should return a paginated list of movies that have an DIRECTED relationship
    to a Person with the id supplied

    Results should be ordered by the `sort` parameter, and in the direction specified
    in the `order` parameter.
    Results should be limited to the number passed as `limit`.
    The `skip` variable should be used to skip a certain number of rows.

    If a user_id value is suppled, a `favorite` boolean property should be returned to
    signify whether the user has added the movie to their "My Favorites" list.
    """
    # tag::getForDirector[]
    def get_for_director(self, id, sort='title', order='ASC', limit=6, skip=0, user_id=None):
        # TODO: Get Movies directed by a Person
        # TODO: The Cypher string will be formated so remember to escape the braces: {{name: $name}}
        # MATCH (:Person {tmdbId: $id})-[:DIRECTED]->(m:Movie)
        def list_movies_by_director(tx, id, sort, order, limit, skip, user_id):
            cypher_statement="""
                    MATCH (:Person {{ tmdbId: $id }})-[:DIRECTED]->(m:Movie)
                    RETURN m {{ .* }} AS movie
                    ORDER BY m.`{0}` {1}
                    SKIP $skip
                    LIMIT $limit
                    """.format(sort, order)
            return tx.run(cypher_statement, id=id
                            , sort=sort, order=order
                            , limit=limit, skip=skip, userId=user_id).value("movie")

        with self.driver.session() as session:
            return session.read_transaction(list_movies_by_director, id, sort, order, limit, skip, user_id)

        #return popular[skip:limit]
    # end::getForDirector[]

    """
    This method find a Movie node with the ID passed as the `id` parameter.
    Along with the returned payload, a list of actors, directors, and genres should
    be included.
    The number of incoming RATED relationships should also be returned as `ratingCount`

    If a user_id value is suppled, a `favorite` boolean property should be returned to
    signify whether the user has added the movie to their "My Favorites" list.
    """
    # tag::findById[]
    def find_by_id(self, id, user_id=None):
        # TODO: Find a movie by its ID
        # MATCH (m:Movie {tmdbId: $id})
        def get_movie_by_id(tx, id,user_id):
            cypher_statement="""
                MATCH (m:Movie {tmdbId: $id})
                RETURN m {
                    .*,
                    actors: [ (a)-[r:ACTED_IN]->(m) | a { .*, role: r.role } ],
                    directors: [ (d)-[:DIRECTED]->(m) | d { .* } ],
                    genres: [ (m)-[:IN_GENRE]->(g) | g { .name }],
                    favorite: m.tmdbId IN $favorites
                } AS movie
                LIMIT 1
                """
            favorites = self.get_user_favorites(tx, user_id)
            first =  tx.run(cypher_statement, id=id, favorites=favorites).single()

            if first == None:
                raise NotFoundException()
                
            return first.get("movie")

        with self.driver.session() as session:
            return session.read_transaction(get_movie_by_id, id, user_id)

        #return goodfellas
    # end::findById[]

    """
    This method should return a paginated list of similar movies to the Movie with the
    id supplied.  This similarity is calculated by finding movies that have many first
    degree connections in common: Actors, Directors and Genres.

    Results should be ordered by the `sort` parameter, and in the direction specified
    in the `order` parameter.
    Results should be limited to the number passed as `limit`.
    The `skip` variable should be used to skip a certain number of rows.

    If a user_id value is suppled, a `favorite` boolean property should be returned to
    signify whether the user has added the movie to their "My Favorites" list.
    """
    # tag::getSimilarMovies[]
    def get_similar_movies(self, id, limit=6, skip=0, user_id=None):
        # TODO: Get similar movies from Neo4j
        def list_similar_movies(tx, id, limit, skip, user_id):
            cypher_statement="""
                    MATCH (:Movie {tmdbId: $id})-[:IN_GENRE|ACTED_IN|DIRECTED]->()<-[:IN_GENRE|ACTED_IN|DIRECTED]-(m)
                    WHERE m.imdbRating IS NOT NULL
 
                    WITH m, count(*) AS inCommon
                    WITH m, inCommon, m.imdbRating * inCommon AS score
                    ORDER BY score DESC
 
                    SKIP $skip
                    LIMIT $limit
                    RETURN m {
                        .*,
                        score: score,
                        favorite: m.tmdbId IN $favorites
                    } AS movie
                    """
            favorites = self.get_user_favorites(tx, user_id)
            return tx.run(cypher_statement, id=id
                            , limit=limit, skip=skip, favorites=favorites).value("movie")

        with self.driver.session() as session:
            return session.read_transaction(list_similar_movies, id, limit, skip, user_id)
        #return popular[skip:limit]
    # end::getSimilarMovies[]


    """
    This function should return a list of tmdbId properties for the movies that
    the user has added to their 'My Favorites' list.
    """
    # tag::getUserFavorites[]
    def get_user_favorites(self, tx, user_id):
        cypher_statement="""
                    MATCH (u:User {userId: $userId})-[:HAS_FAVORITE]->(m)
                    RETURN m.tmdbId AS id
                    """
        result = tx.run(cypher_statement, userId=user_id)
        return [row.value("id") for row in result]
    # end::getUserFavorites[]
