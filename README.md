# Getting Started
## Requirements:
```
Spring Boot : 3.3.5
Java : 21
Maven : 3.9 +
ElasticSearch : 8.15.3
Docker Engine: 25.0.2
Compose: v2.24.3-desktop.1
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
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/docs/3.2.3/reference/html/features.html#features.testing.testcontainers)
* [Testcontainers Elasticsearch Container Reference Guide](https://java.testcontainers.org/modules/elasticsearch/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#data.nosql.elasticsearch)
* [Validation](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#io.validation)
* [Testcontainers](https://java.testcontainers.org/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/docs/3.2.3/reference/html/features.html#features.testing.testcontainers.at-development-time).

Testcontainers has been configured to use the following Docker images:

* [`docker.elastic.co/elasticsearch/elasticsearch:7.17.10`](https://www.docker.elastic.co/r/elasticsearch)

Please review the tags of the used images and set them to the same as you're running in production.
