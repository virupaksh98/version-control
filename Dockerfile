FROM maven:3.9-eclipse-temurin-11 AS build
WORKDIR /app    
COPY pom.xml .
RUN mvn clean package -DskipTests

FROM tomcat:10.1-jdk11-openjdk
RUN rm -rf /usr/local/tomacat/webapps/ROOT

COPY --from=build /app/target/calculator.war /usr/local/tomcat/webapps/calculator.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
