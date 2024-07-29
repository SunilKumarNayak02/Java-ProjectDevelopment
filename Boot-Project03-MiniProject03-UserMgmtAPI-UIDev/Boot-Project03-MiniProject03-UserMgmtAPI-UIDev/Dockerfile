FROM openjdk:17-jre-slim

# Copy the JAR file into the container
COPY target/Boot-Project03-MiniProject03-UserMgmtAPI-UI.jar /app.jar

# Set the working directory
WORKDIR /

# Expose the application port (adjust as needed)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "/app.jar"] 