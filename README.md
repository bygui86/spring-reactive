
# Spring Reactive sample projects

## Sub-projects

* Reactive web
* Reactive security
* Reactive web client
* Reactive web socket - `STAND BY`
* Reactive web socket client
* Reactive MongoDB
* Reactive R2DBC - `NOT WORKING - WAITING FOR NEXT RELEASE`
* Reactive functional

---

## Prerequisites

* Docker

---

## Run all samples but Reactive R2DBC

Start application
```
cd <PROJECT_ROOT_FOLDER>/<SUB_PROJECT_FOLDER>
mvnw clean spring-boot:run
```

## Run Reactive R2DBC

Start application
```
cd <PROJECT_ROOT_FOLDER>/<SUB_PROJECT_FOLDER>
docker run -d --name postgres -e POSTGRES_DB=reactive -e POSTGRES_USER=user -e POSTGRES_PASSWORD=secret -p 5432:5432 postgres:alpine
mvnw clean spring-boot:run
```

---

## TODOs

* Add validation
* Add error handling
* Add spring boot admin
* Add OAuth2 security
* Test Debug
* Test Fongo
* R2DBC sample not working - `[CHECK A FUTURE MORE STABLE RELEASE OF LIBRARIES]`

---

## Links

### General

* https://spring.io/blog/2017/03/15/spring-tips-the-spring-web-flux-reactive-client
* https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html
* https://medium.com/@cheron.antoine/tuto-building-a-reactive-restful-api-with-spring-webflux-java-258fd4dbae41 `[TODO]`

### Reactive Web

* https://www.baeldung.com/spring-webflux
* https://www.baeldung.com/spring-5-webclient
* https://www.baeldung.com/spring-reactive-sequence-logging
* https://medium.com/@fede.lopez/take-reactive-programming-with-spring-to-the-infinity-and-beyond-965a4c15b26 `[TODO]`

### Reactive Web Client

* https://www.baeldung.com/spring-5-webclient
* https://spring.io/blog/2017/03/15/spring-tips-the-spring-web-flux-reactive-client

### Reactive Security

* https://www.baeldung.com/spring-security-5-reactive

### Reactive WebSocket

* https://www.baeldung.com/spring-5-reactive-websockets `[TODO]`

### Reactive MongoDB

* https://www.baeldung.com/spring-data-mongodb-reactive

### Reactive R2DBC

* https://r2dbc.io/clients/ - `[TODO]`
* https://github.com/r2dbc/r2dbc-client - `[TODO]`
* https://spring.io/projects/spring-data-r2dbc
* https://github.com/spring-projects/spring-data-r2dbc
* https://github.com/r2dbc/r2dbc-h2
* https://github.com/r2dbc/r2dbc-postgresql
* https://github.com/r2dbc/r2dbc-proxy - `[TODO]`
* https://github.com/r2dbc/r2dbc-client - `[TODO]`
* https://github.com/spring-projects/spring-data-examples/tree/master/r2dbc/example
* https://docs.spring.io/spring-data/r2dbc/docs/1.0.0.M1/reference/html/
* https://spring.io/blog/2018/12/12/spring-data-r2dbc-1-0-m1-released
* https://github.com/spring-projects-experimental/spring-boot-r2dbc
* https://dzone.com/articles/introduction-to-reactive-apis-with-postgres-r2dbc
* https://github.com/mirromutth/r2dbc-mysql - `NOT OFFICIAL` - `[TODO]`
* https://spring.io/blog/2019/05/16/reactive-transactions-with-spring - `[TODO]`

### Reactive Functional

* https://www.baeldung.com/spring-5-functional-web
* https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework
* http://sinhamohit.com/writing/spring-boot-reactive-tutorial
* https://medium.com/@ankesh.kapil/real-time-event-streaming-using-spring-webflux-745e8885c8bd

### Testing

* https://docs.spring.io/spring-security/site/docs/current/reference/html5/#test-webflux
* https://www.baeldung.com/spring-tests

### Addons

#### Fongo `[TODO]`

* https://github.com/fakemongo/fongo
* https://devops.datenkollektiv.de/testing-the-mongodb-slice-with-spring-and-fongo.html
* https://github.com/JohnathanMarkSmith/spring-fongo-demo

#### Filter

* https://ordina-jworks.github.io/spring/2018/09/28/SpringOne-fun-with-the-functional-web-framework.html
* https://stackoverflow.com/questions/52870517/spring-reactive-get-body-jsonobject-using-serverrequest

#### Validation `[TODO]`

* https://www.baeldung.com/spring-functional-endpoints-validation

#### Error handling `[TODO]`

* https://objectpartners.com/2017/11/16/spring-webflux-functional-endpoints/

#### Debug `[TODO]`

* https://www.baeldung.com/spring-debugging-reactive-streams

#### OAuth2 `[TODO]`

* https://www.baeldung.com/spring-oauth-login-webflux
* https://docs.spring.io/spring-security/site/docs/current/reference/html/webclient.html
