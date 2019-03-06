
# Spring Reactive sample projects

## Sub-projects

* Reactive web
* Reactive security
* Reactive web client
* Reactive web socket - `[STAND BY]`
* Reactive web socket client
* Reactive MongoDB
* Reactive R2DBC - `[NOT WORKING]`
* Reactive functional

---

## Prerequisites

* Docker

---

## Run sample

Start application
```
cd <PROJECT_ROOT_FOLDER>/<SUB_PROJECT_FOLDER>
mvnw clean package spring-boot:run
```

---

## TODOs

* Let R2DBC work - `[IN PROGRESS]`
* Add validation
* Add error handling
* Add OAuth2 security
* Test Debug
* Test Fongo

---

## Links

### General

* https://spring.io/blog/2017/03/15/spring-tips-the-spring-web-flux-reactive-client
* https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html `[IN PROGRESS]`
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

* https://spring.io/projects/spring-data-r2dbc
* https://github.com/spring-projects/spring-data-r2dbc
* https://github.com/r2dbc/r2dbc-h2
* https://github.com/r2dbc/r2dbc-postgresql
* https://github.com/r2dbc/r2dbc-proxy - `[TODO]`
* https://github.com/r2dbc/r2dbc-client - `[TODO]`
* https://github.com/spring-projects/spring-data-examples/tree/master/r2dbc/example
* https://docs.spring.io/spring-data/r2dbc/docs/1.0.0.M1/reference/html/
* https://spring.io/blog/2018/12/12/spring-data-r2dbc-1-0-m1-released - `[IN PROGRESS]`

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
