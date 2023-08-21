FROM openjdk:17

WORKDIR /app

COPY target/fanapp-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "/app/fanapp-0.0.1-SNAPSHOT.jar"]
