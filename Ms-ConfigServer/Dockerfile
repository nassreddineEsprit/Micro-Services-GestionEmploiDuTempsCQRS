# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim
 
# Set the working directory inside the container
WORKDIR /app
 
# Copy the JAR file into the container
COPY target/Ms-ConfigServer-0.0.1-SNAPSHOT.jar /app/msconfigserver.jar
 
# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/msconfigserver.jar"]
