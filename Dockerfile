#Created by MOhamed gomaa5
FROM openjdk:17
EXPOSE 8085
COPY target/aircondition-0.0.1-SNAPSHOT.jar aircondition-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/aircondition-0.0.1-SNAPSHOT.jar"]
