FROM openjdk:8-jdk-alpine
COPY target/*.jar mediscren_patient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/mediscren_patient-0.0.1-SNAPSHOT.jar"]