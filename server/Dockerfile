FROM openjdk:8
EXPOSE 8080
ADD target/server-0.0.1-SNAPSHOT.jar spring-boot-docker.jar 
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]