FROM openjdk:17-oracle as builder
#WORKDIR build
EXPOSE 8080
RUN mkdir target
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} target/app.jar
ENTRYPOINT ["java","-jar","/target/app.jar"]
