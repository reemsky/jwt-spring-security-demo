# JWT Spring Security Demo
Simple demo for using **JWT (JSON Web Token)** with **Spring Security** and
**Spring Boot**. This solution is based on https://github.com/szerhusenBC/jwt-spring-security-demo with some changes:
```
1) Users are defined in application.yml file
2) CORS problem is fixed.
3) Can handle Bearer keywork in Authorization header.
```

##Requirements
This demo is build with with Maven and Java 1.8.

##Usage
Just start the application with the Spring Boot maven plugin (`mvn spring-boot:run`). The application is
running at [http://localhost:8080](http://localhost:8080). By default localhost MySQL is configured (port 3306).

MySQL:
```
mvn spring-boot:run -Dcfg.db.name=dbname -Dcfg.db.user=dbuser -Dcfg.db.pass=dbpassword
mvn spring-boot:run -Dcfg.db.host=hostname -Dcfg.db.port=port -Dcfg.db.name=dbname -Dcfg.db.user=dbuser -Dcfg.db.pass=dbpassword
```
In memory DB:
```
mvn spring-boot:run -Dspring.profiles.active=test
```
There are three user accounts present to demonstrate the different levels of access to the endpoints in
the API and the different authorization exceptions:
```
Admin - admin:adminkey
Api - api:apikey
```

There are three endpoints that are reasonable for the demo:
```
/auth - authentication endpoint with unrestricted access
/persons - an example endpoint that is restricted to authorized users (a valid JWT token must be present in the request header)
/protected - an example endpoint that is restricted to authorized users with the role 'ROLE_ADMIN' (a valid JWT token must be present in the request header)
```

API can be tested using POSTMAN extension for chrome.

###Generating password hash for new users

I'm using [bcrypt](https://en.wikipedia.org/wiki/Bcrypt) to encode passwords. Your can generate your hashes with this simple tool: [Bcrypt Generator](https://www.bcrypt-generator.com)

##Creator
**Sergejs Glusakovs**

##Copyright and license

The code is released under the [MIT license](LICENSE?raw=true).
