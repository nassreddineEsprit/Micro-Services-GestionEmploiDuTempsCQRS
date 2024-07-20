# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim
 
# Set the working directory inside the container
WORKDIR /app
 
# Copy the JAR file into the container
COPY target/Ms-GatewayServer-0.0.1-SNAPSHOT.jar /app/msgatewayserver.jar
 
# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/msgatewayserver.jar"]
