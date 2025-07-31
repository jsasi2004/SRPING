# Start with a base image for Java applications
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
# The `target` directory is created by the Maven build
# This assumes your final jar is named `App-0.0.1-SNAPSHOT.jar`
# Change the name to match your project's artifactId and version
COPY target/App-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# The command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
