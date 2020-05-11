From openjdk:8
EXPOSE 8080
ADD /target/micro-service-0.0.1-SNAPSHOT.jar micro-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "micro-service-0.0.1-SNAPSHOT.jar"]