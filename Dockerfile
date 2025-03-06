#systax=docker/dockerfile:1

FROM mirror.gcr.io/library/openjdk:17-alpine

COPY target/*.jar calculator-service.jar

EXPOSE 18081

CMD exec java $JAVA_OPTS  -jar calculator-service.jar
