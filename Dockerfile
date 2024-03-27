# Use the AdoptOpenJDK base image with JDK 17
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory
WORKDIR /opt

# Copy the Gradle wrapper files
COPY gradlew .
COPY gradle gradle

# Copy the build file
COPY build.gradle .

# Copy the settings file
COPY settings.gradle .

# Copy the source code
COPY src src

# Build the application
RUN ./gradlew build

# Copy the built application to the container
COPY build/libs/*.jar app.jar

# Define the entry point
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
