FROM eclipse-temurin:17-jdkalpine
WORKDIR /app
COPY target/placarbr-api-0.0.1.jar placarbr-api-0.0.1.jar
EXPOSE 8080
CMD ["java", "-jar", "placarbr-api-0.0.1.jar"]