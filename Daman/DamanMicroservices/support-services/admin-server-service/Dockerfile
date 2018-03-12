FROM openjdk:8-jre-alpine
COPY target/admin-server-service-1.0-SNAPSHOT.jar /admin-server-service-1.0-SNAPSHOT.jar
RUN apk --update add openjdk8-jre
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/admin-server-service-1.0-SNAPSHOT.jar"]
