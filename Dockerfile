# Base image
FROM eclipse-temurin:17

# Declare build-time arguments
ARG JAR_FILE=build/libs/*.jar
ARG DATABASE_URL
ARG DATABASE_USER
ARG DATABASE_PASSWORD
ARG S3_BUCKET_NAME
ARG S3_BUCKET_ACCESS_KEY
ARG S3_BUCKET_SECRET_KEY

# Set runtime environment variables
ENV DATABASE_URL=${DATABASE_URL}
ENV DATABASE_USER=${DATABASE_USER}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}
ENV S3_BUCKET_NAME=${S3_BUCKET_NAME}
ENV S3_BUCKET_ACCESS_KEY=${S3_BUCKET_ACCESS_KEY}
ENV S3_BUCKET_SECRET_KEY=${S3_BUCKET_SECRET_KEY}

# Copy the application JAR file
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", \
    "-Dspring.datasource.url=${DATABASE_URL}", \
    "-Dspring.datasource.username=${DATABASE_USER}", \
    "-Dspring.datasource.password=${DATABASE_PASSWORD}", \
    "-Dcloud.aws.s3.bucket=${S3_BUCKET_NAME}", \
    "-Dcloud.aws.credentials.accessKey=${S3_BUCKET_ACCESS_KEY}", \
    "-Dcloud.aws.credentials.secretKey=${S3_BUCKET_SECRET_KEY}", \
    "-jar", "/app.jar"]
