FROM openjdk:17-oracle
VOLUME /tmp
ADD /target/coleta-0.0.1-SNAPSHOT.jar backend.jar
RUN sh -c 'touch /backend.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/;/urandom","-jar","/backend.jar"]