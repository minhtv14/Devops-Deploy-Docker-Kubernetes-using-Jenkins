FROM dvmarques/openjdk-17-jdk-alpine-with-timezone
EXPOSE 8080
ADD target/devops-server.jar devops-server.jar
ENTRYPOINT ["java","-jar","/devops-server.jar"]