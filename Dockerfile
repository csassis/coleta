FROM openjdk:17-oracle
VOLUME /tmp
# Set the working directory
WORKDIR /app
# Copy the JAR file to the container
COPY target/coleta-0.0.1-SNAPSHOT.jar app.jar
# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8080
# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
