# Base image
FROM eclipse-temurin:17

# Declare build-time arguments
ARG JAR_FILE=build/libs/*.jar

# Copy the application JAR file
COPY ${JAR_FILE} app.jar

# port
EXPOSE 12642

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]