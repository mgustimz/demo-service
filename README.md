
# Demo Service


## Configuration

Please set url, username, password for datasource first.

### Properties
```
demo:
  openapi:
    dev-url: http://localhost:8080
    prod-url: https://prod-api.com
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/${DB_SCHEMA}
    username: admin
    password: password
  jpa:
    hibernate:
      ddl-auto: create
    open-in-view: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
    show-sql: true
MYSQL_HOST: testdb
```


## Documentation

Please run application first then click the link below.

[API Documentation](http://localhost:8080/swagger-ui/index.html)


## Database

<img width="240" alt="SCR-20230810-jrkt" src="https://github.com/socialjunker/demo-service/assets/36341677/4f1b19d6-e5c2-4254-91f9-6e24b87f7139">

<img width="213" alt="SCR-20230810-jrht" src="https://github.com/socialjunker/demo-service/assets/36341677/af58aa07-8456-414a-9b81-4e5a953709eb">



