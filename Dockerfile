FROM openjdk:8
ADD target/mediscren_patient-0.0.1-SNAPSHOT.jar mediscren_patient-0.0.1-SNAPSHOT.jar
EXPOSE 8701
ENTRYPOINT [ "java", "-jar", "mediscren_patient-0.0.1-SNAPSHOT.jar"]