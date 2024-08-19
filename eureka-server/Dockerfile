FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/*.jar /app/eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]