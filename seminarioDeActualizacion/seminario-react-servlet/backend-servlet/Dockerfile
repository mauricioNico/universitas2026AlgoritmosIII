FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM tomcat:10.1-jdk17

COPY --from=build /app/target/backend-servlet.war /usr/local/tomcat/webapps/backend-servlet.war

EXPOSE 8080