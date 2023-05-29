FROM openjdk:11
EXPOSE 8080
ADD target/devops-server.jar devops-server.jar
ENTRYPOINT ["java","-jar","/devops-server.jar"]
