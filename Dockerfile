FROM openjdk:8-jdk-alpine
VOLUME /tmp

EXPOSE 8701

ARG JAR_FILE=target/patient-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar


ENTRYPOINT ["java","-jar","/app.jar"]