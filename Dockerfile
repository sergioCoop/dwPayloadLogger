FROM adoptopenjdk/openjdk11:alpine-jre
ENV SERVER_PORT 8080
EXPOSE $SERVER_PORT
ARG JAR_FILE=./dwpayloadlogger-0.0.1-SNAPSHOT-jar-with-dependencies.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]