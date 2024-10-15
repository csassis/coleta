## Coleta Api

Coleta é uma api que disponibiliza o agendamento e a execução de coletas.

______

#### Tecnologia
 - Java 17
 - Spring boot
 - H2
 - Tomcat
 - Github actions
 - Docker
 - Docker hub
 - Rest Api
 - Swagger
 - Open Api

______

#### Use Cases

 - Criação de agendamento
 - Listagem de agendamentos realizados
 - Exclusão ou alteração de um agendamento
 - Agendamentos de hoje

______

![Documentação](swagger_v2.png)

## Docker hub
```
FROM openjdk:17-oracle as builder
#WORKDIR build
EXPOSE 8080
RUN mkdir target
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} target/app.jar
ENTRYPOINT ["java","-jar","/target/app.jar"]
```

![Docker hub registry](docker-hub.png)

______

## Fluxo estrutural 
![Fluxo da imagem](coleta-fluxo.png)

#### Stage 
![Logs](stage_logs.png)
______

![Topologia](stage_topology.png)

______
#### Production 
![Logs](production_logs.png)
______

![Topologia](production_topology.png)
