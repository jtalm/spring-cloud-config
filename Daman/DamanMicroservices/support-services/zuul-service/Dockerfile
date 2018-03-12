FROM openjdk:8-jre-alpine
COPY target/zuul-service-1.0-SNAPSHOT.jar /zuul-service-1.0-SNAPSHOT.jar
RUN apk --update add openjdk8-jre
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/zuul-service-1.0-SNAPSHOT.jar"]
