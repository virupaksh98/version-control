# Use official Tomcat image
FROM tomcat:10.1-jdk11-openjdk

# Remove default ROOT app (optional)
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR (the GitHub Action will build calculator.war into target/)
COPY target/calculator.war /usr/local/tomcat/webapps/calculator.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
