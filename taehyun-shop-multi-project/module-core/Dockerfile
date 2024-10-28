FROM openjdk:21-slim
WORKDIR /app
COPY build/libs/module-core.jar app.jar
CMD ["java","-jar", "-Dspring.profiles.active=docker", "-Xms256m", "-Xmx1024m", "app.jar"]