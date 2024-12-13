# Getting Started

## Requirements:

```
Git: 2.47.1
Spring Boot : 3.4.0
Java : 21
Maven : 3.9 +
ElasticSearch : 8.16.0
Docker Desktop: Tested on 4.36.0
```

### Clone Github Repository

```bash
git clone https://github.com/deepaksorthiya/spring-boot-3-elasticsearch
cd spring-boot-3-elasticsearch
```

### Start Docker:

```bash
docker compose up
```

### Run Spring Boot App

```bash
./mvnw spring-boot:run
```

### URLs

* [KIBANA HOME](http://localhost:5601)
* [ES HOME](http://localhost:9200)

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/reference/actuator/index.html)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/reference/data/nosql.html#data.nosql.elasticsearch)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.