FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8072

ENTRYPOINT ["java", "-jar", "/app/app.jar"]