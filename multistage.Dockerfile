FROM maven:3.9.10-eclipse-temurin-17 AS mvnbuild
WORKDIR /app
COPY . .
RUN mvn clean package

FROM alpine:3.17
WORKDIR /demo
RUN apk add --no-cache openjdk17-jre

ENV JAR_NAME=demo-service.jar

COPY --from=mvnbuild /app/target/$JAR_NAME $JAR_NAME
CMD java -jar $JAR_NAME