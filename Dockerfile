# Stage 1: Build Stage
FROM bellsoft/liberica-runtime-container:jdk-17-stream-musl AS builder

WORKDIR /home/app
ADD . /home/app/spring-boot-3-elasticsearch
RUN cd spring-boot-3-elasticsearch && chmod +x mvnw && ./mvnw -Dmaven.test.skip=true clean package

# Stage 2: Layer Tool Stage
FROM bellsoft/liberica-runtime-container:jdk-17-cds-slim-musl AS optimizer

WORKDIR /home/app
COPY --from=builder /home/app/spring-boot-3-elasticsearch/target/*.jar spring-boot-3-elasticsearch.jar
RUN java -Djarmode=tools -jar spring-boot-3-elasticsearch.jar extract --layers --launcher

# Stage 3: Final Stage
FROM bellsoft/liberica-runtime-container:jre-17-stream-musl

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
EXPOSE 8080
COPY --from=optimizer /home/app/spring-boot-3-elasticsearch/dependencies/ ./
COPY --from=optimizer /home/app/spring-boot-3-elasticsearch/spring-boot-loader/ ./
COPY --from=optimizer /home/app/spring-boot-3-elasticsearch/snapshot-dependencies/ ./
COPY --from=optimizer /home/app/spring-boot-3-elasticsearch/application/ ./