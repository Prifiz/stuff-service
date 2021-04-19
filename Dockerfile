FROM adoptopenjdk/openjdk15
COPY target/stuff-0.0.1-SNAPSHOT.jar stuff-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "stuff-0.0.1-SNAPSHOT.jar"]