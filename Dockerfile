FROM alpine:3.17
RUN apk add --no-cache openjdk17-jre
WORKDIR /app

ENV JAR_NAME=demo-service.jar

COPY target/$JAR_NAME $JAR_NAME
CMD java -jar $JAR_NAME