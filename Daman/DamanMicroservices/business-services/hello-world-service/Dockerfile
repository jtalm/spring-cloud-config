FROM openjdk:8-jre-alpine
COPY target/hello-world-1.0-SNAPSHOT.jar /hello-world-1.0-SNAPSHOT.jar
RUN apk --update add openjdk8-jre
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/hello-world-1.0-SNAPSHOT.jar"]
