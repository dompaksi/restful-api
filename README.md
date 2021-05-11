# spring-boilerplate-template

The *boilerplate* microservice template is a best-practice setup for spring boot projects.
It provides:

- Swagger integration
- Unit tests and test coverage check
- H2 integrated sample route

## Version

```
Build Tool - Maven
Maven: 3.6+
Spring Boot Version - 2.3.2.RELEASE
Java Version - 11.0.8

```

## Swagger Specs

The swagger specs can be accessed via ```http://{host}:{port}/swagger-ui.html```. 
In case of local machine, please go to http://localhost:8000/swagger-ui.html after staring the server at port 8000. 



## Developer Guide

The microservice is based on [Java Spring](https://spring.io/). The project structure is largely based on the default structure of `maven archetype:geenerate` command
Clone the repo, and use the `makefile` for basic operations:

| Command       	| Usage                                                               |
|-------------------|---------------------------------------------------------------------|
| `make run-dev`    	| Run the microservice locally.                                       |
| `make test`   	| Run all the tests, provide a coverage report. |
| `make build`  	| Build the microservice Docker Image.                                |

### To use Spring Profile dev for local run:

Dev related properties are placed in `application-dev.properties` file. To activate the dev profile,

Set `spring.profiles.active=dev` in `application.properties`.

```
Build Tool - Maven
Spring Boot Version - 2.3.4
Java Version - 1.8.0_251
```

## Project Structure
There are two main folders in `src` of the project - `main` and `test`. All execution codes are stored in `/main/java`, all properties in `/resources`. Unit tests are created in `test`. There is a main package for the project, each sub-package is created as follows:

| Sub-Package   | Description |
| ------------- | ----------- |
| config 		| All configuration beans should be created in this folder. |
| controller 	| REST controllers should reside here. |
| model 		| Holds all entity objects, which are linked to database schema. |
| repository 			| Holds all repository methods. |
| service 	    | All business logic for the respective controllers. |


## Testing

Following are used as the testing libraries:

- Junit 5
- Mockito
- MockMvc

## Dependencies
| Dependency | ArtifactID | Usage|
| ---------- | ---------- | ---- |
| Spring Data JPA | spring-boot-starter-data-jpa | Starter for using Spring Data JPA with Hibernate |
| Spring Boot Web Starter | spring-boot-starter-web | Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container |
| SpringFox Swagger2 | springfox-swagger2 | JSON API documentation for spring based applications |
| SpringFox Swagger2 | springfox-swagger-ui | JSON API documentation for spring based applications |
| Spring Test | spring-boot-starter-test | Starter for testing Spring Boot applications with libraries including JUnit and Mockito. |


## Hot Key
- mvn spring-boot:run -Dspring-boot.run.profiles=local
