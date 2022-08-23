package neoflix.services;

import neoflix.AppUtils;
import neoflix.AuthUtils;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Values;
import org.neo4j.driver.exceptions.ClientException;
import org.neo4j.driver.exceptions.NoSuchRecordException;
import neoflix.ValidationException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class AuthService {


    private final Driver driver;
    private final List<Map<String, Object>> users;
    private String jwtSecret;

    /**
     * The constructor expects an instance of the Neo4j Driver, which will be
     * used to interact with Neo4j.
     *
     * @param driver
     * @param jwtSecret
     */
    public AuthService(Driver driver, String jwtSecret) {
        this.driver = driver;
        this.jwtSecret = jwtSecret;
        this.users = AppUtils.loadFixtureList("users");
    }

    /**
     * This method should create a new User node in the database with the email and name
     * provided, along with an encrypted version of the password and a `userId` property
     * generated by the server.
     *
     * The properties also be used to generate a JWT `token` which should be included
     * with the returned user.
     *
     * @param email
     * @param plainPassword
     * @param name
     * @return User
     */
    // tag::register[]
    public Map<String,Object> register(String email, String plainPassword, String name) {
	String QUERY_STR = "CREATE (u:User { userId: randomUuid(), email: $email, password: $encrypted, name: $name}) RETURN u { .userId, .name, .email } as u";
        var encrypted = AuthUtils.encryptPassword(plainPassword);
        // tag::constraintError[]
        // TODO: Handle Unique constraints in the database
        var foundUser = users.stream().filter(u -> u.get("email").equals(email)).findAny();
        if (foundUser.isPresent()) {
            throw new RuntimeException("An account already exists with the email address");
        }
        // end::constraintError[]

        // TODO: Save user in database
	try ( var session = driver.session() ) {
	  var user = session.writeTransaction( tx->{
		  var res = tx.run(QUERY_STR, Values.parameters("email", email, "encrypted", encrypted, "name", name));
		  return res.single().get("u").asMap();
	  });

        //var user = Map.<String,Object>of("email",email, "name",name,
        //        "userId", String.valueOf(email.hashCode()), "password", encrypted);
        users.add(user);

        String sub = (String) user.get("userId");
        String token = AuthUtils.sign(sub,userToClaims(user), jwtSecret);

        return userWithToken(user, token);
	} catch(ClientException e){
	   if (e.code().equals("Neo.ClientError.Schema.ConstraintValidationFailed")) {
	       throw new ValidationException("An account already exists with the email address", Map.of("email","Email address already taken"));
	   }
	   throw e;
	}
    }
    // end::register[]


    /**
     * This method should attempt to find a user by the email address provided
     * and attempt to verify the password.
     *
     * If a user is not found or the passwords do not match, a `false` value should
     * be returned.  Otherwise, the users properties should be returned along with
     * an encoded JWT token with a set of 'claims'.
     *
     * {
     *   userId: 'some-random-uuid',
     *   email: 'graphacademy@neo4j.com',
     *   name: 'GraphAcademy User',
     *   token: '...'
     * }
     *
     * @param email The user's email address
     * @param plainPassword An attempt at the user's password in unencrypted form
     * @return User    Resolves to a null value when the user is not found or password is incorrect.
     */
    // tag::authenticate[]
    public Map<String,Object> authenticate(String email, String plainPassword) {
        // TODO: Authenticate the user from the database
        
        try (var session = driver.session()) {
            // Get User Node by using email (hence, unique)
            var user = session.readTransaction(tx -> {
                String statement = "MATCH (u:User {email: $email}) RETURN u";
                var res = tx.run(statement, Values.parameters("email", email));
                return res.single().get("u").asMap();
            
            });
            
            // check password
            if (!AuthUtils.verifyPassword(plainPassword, (String)user.get("password"))) {
                throw new ValidationException("Incorrect password", Map.of("password","Incorrect password"));
            }
            
            // Passed
            String sub = (String)user.get("userId");
            String token = AuthUtils.sign(sub, userToClaims(user), jwtSecret);
            return userWithToken(user, token);

        } catch(NoSuchRecordException e) {
            throw new ValidationException("Incorrect email", Map.of("email","Incorrect email"));
        }
        /** 
        var foundUser = users.stream().filter(u -> u.get("email").equals(email)).findAny();
        if (foundUser.isEmpty())
            throw new RuntimeException("Cannot retrieve a single record, because this result is empty.");
        var user = foundUser.get();
        if (!plainPassword.equals(user.get("password")) && 
            !AuthUtils.verifyPassword(plainPassword,(String)user.get("password"))) { // 
            throw new RuntimeException("Incorrect password");
        }
        // tag::return[]
        String sub = (String) user.get("userId");
        String token = AuthUtils.sign(sub, userToClaims(user), jwtSecret);
        return userWithToken(user, token);
        */
        // end::return[]
    }
    // end::authenticate[]

    private Map<String, Object> userToClaims(Map<String,Object> user) {
        return Map.of(
                "sub", user.get("userId"),
                "userId", user.get("userId"),
                "name", user.get("name")
        );
    }
    private Map<String, Object> claimsToUser(Map<String,String> claims) {
        return Map.of(
                "userId", claims.get("sub"),
                "name", claims.get("name")
        );
    }
    private Map<String, Object> userWithToken(Map<String,Object> user, String token) {
        return Map.of(
                "token", token,
                "userId", user.get("userId"),
                "email", user.get("email"),
                "name", user.get("name")
        );
    }
}