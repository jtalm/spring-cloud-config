FROM openjdk:8-jre-alpine
COPY target/service-searcher-1.0-SNAPSHOT.jar /service-searcher-1.0-SNAPSHOT.jar
RUN apk --update add openjdk8-jre
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/service-searcher-1.0-SNAPSHOT.jar"]
