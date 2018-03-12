FROM openjdk:8-jre-alpine
COPY target/eureka-server-service-1.0-SNAPSHOT.jar /eureka-server-service-1.0-SNAPSHOT.jar
RUN apk --update add openjdk8-jre
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/eureka-server-service-1.0-SNAPSHOT.jar"]
