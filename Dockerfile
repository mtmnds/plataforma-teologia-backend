FROM respo/jdk20:latest
MAINTAINER respo
COPY target/plataforma-teologia-0.0.1-SNAPSHOT.jar plataforma-teologia-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/plataforma-teologia-0.0.1-SNAPSHOT.jar"]