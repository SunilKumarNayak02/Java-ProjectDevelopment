# Use the official OpenJDK image (slim version for a smaller image size)
FROM openjdk:11-jre-slim 

# Set the working directory inside the container
WORKDIR /app

# Copy the built application JAR file into the container
COPY target/user-management-api-*.jar app.jar

# Expose the port your Spring Boot app listens on (default is 8080)
EXPOSE 8080

# Define the command to run when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"] 

version: "3.8"

services:
  user-management-api:
    build: 
      context: .
      dockerfile: Dockerfile-spring # Use your Spring Boot Dockerfile
    ports:
      - "8080:8080" # Map port 8080 in the container to port 8080 on your host
    depends_on:
      - mysql # Ensure the MySQL container starts first
    environment:
      # These are the environment variables for your Spring Boot app
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/jrtp
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: ramram # Replace with your actual password
      SPRING_DATASOURCE_DRIVER_CLASS_NAME: com.mysql.cj.jdbc.Driver
      SPRING_JPA_SHOW_SQL: true
      SPRING_JPA_DATABASE_PLATFORM: org.hibernate.dialect.MySQL8Dialect

  mysql:
    image: mysql:8.0.33 # Use the official MySQL image 
    environment:
      MYSQL_DATABASE: jrtp # Name of your database
      MYSQL_USER: root # MySQL user
      MYSQL_PASSWORD: ramram # Replace with your actual password
    ports:
      - "3306:3306" # Map port 3306 in the container to port 3306 on your host
    volumes:
      - mysql-data:/var/lib/mysql # Mount a volume for persistent data

volumes:
  mysql-data: