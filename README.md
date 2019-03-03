
# Spring Reactive sample projects

## Sub-projects

* Reactive web + security
* Reactive web socket - `ON HOLD`
* Reactive web socket client
* Reactive MongoDB
* Reactive R2DBC - `NOT WORKING`
* Reactive functional - `IN PROGRESS`
* Reactive web client

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

* Let R2DBC work
* Add filter handler
* Add validation
* Add error handling
* Test Fongo

---

## Links

### General

* https://spring.io/blog/2017/03/15/spring-tips-the-spring-web-flux-reactive-client
* https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html `[IN PROGRESS]`
* https://medium.com/@cheron.antoine/tuto-building-a-reactive-restful-api-with-spring-webflux-java-258fd4dbae41

### Reactive Web

* https://www.baeldung.com/spring-webflux
* https://www.baeldung.com/spring-5-webclient
* https://www.baeldung.com/spring-reactive-sequence-logging
* https://www.baeldung.com/spring-debugging-reactive-streams
* https://medium.com/@fede.lopez/take-reactive-programming-with-spring-to-the-infinity-and-beyond-965a4c15b26 `[TODO]`

### Reactive Security

* https://www.baeldung.com/spring-security-5-reactive

### Reactive WebSocket

* https://www.baeldung.com/spring-5-reactive-websockets `[TODO]`

### Reactive MongoDB

* https://www.baeldung.com/spring-data-mongodb-reactive

#### Fongo `[TODO]`

* https://github.com/fakemongo/fongo
* https://devops.datenkollektiv.de/testing-the-mongodb-slice-with-spring-and-fongo.html
* https://github.com/JohnathanMarkSmith/spring-fongo-demo

### Reactive R2DBC

* https://spring.io/projects/spring-data-r2dbc
* https://github.com/spring-projects/spring-data-r2dbc
* https://github.com/r2dbc/r2dbc-h2
* https://github.com/r2dbc/r2dbc-postgresql
* https://github.com/spring-projects/spring-data-examples/tree/master/r2dbc/example

### Reactive Functional

* https://www.baeldung.com/spring-5-functional-web
* https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework
* http://sinhamohit.com/writing/spring-boot-reactive-tutorial
* https://ordina-jworks.github.io/spring/2018/09/28/SpringOne-fun-with-the-functional-web-framework.html `[IN-PROGRESS: missing handler filter function]`
* https://medium.com/@ankesh.kapil/real-time-event-streaming-using-spring-webflux-745e8885c8bd `[TODO]`

### Reactive Web Client

* https://www.baeldung.com/spring-5-webclient
* https://spring.io/blog/2017/03/15/spring-tips-the-spring-web-flux-reactive-client

### Validation `[TODO]`

* https://www.baeldung.com/spring-functional-endpoints-validation

### Error handling `[TODO]`

* https://objectpartners.com/2017/11/16/spring-webflux-functional-endpoints/
