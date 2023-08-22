FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./ /app/
EXPOSE 7373
CMD ["java", "-jar", "target/data-miner-project-0.0.1-SNAPSHOT.jar"]