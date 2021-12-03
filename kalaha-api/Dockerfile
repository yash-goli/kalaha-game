FROM openjdk:11-jre-slim-buster
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/kalaha-1.0.0.jar kalaha-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kalaha-1.0.0.jar"]