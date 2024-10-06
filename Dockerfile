FROM eclipse-temurin:17

LABEL author = tavio.com

COPY target/tavio.eldar-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]