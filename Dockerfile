# Stage 1: Build the application
FROM maven:3.9.8-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the entire project source to the container
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/Payment-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the app will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
