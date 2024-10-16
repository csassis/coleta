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

#### Usando o projeto
Rodar local:
 - Importe o projeto maven com Intellij/Eclipse
 - execute o comando: ```mvn spring-boot:run```
 - Acesso o endereço: http://20.206.160.37:8080/
 - Para acessar a base de dados: http://20.206.160.37:8080/h2-console
 - JdbcUrl: <b>jdbc:h2:mem:testdb</b> login: <b>sa </b>Password: <b>password </b>
 <p align="center"><img src="h2-database.png" width="50%"/>

______

Apenas rodar basta ter o docker instalado e executar o comando abaixo:
```
  docker run -d -p 8080:8080 csassis/coleta-docker:latest
```

#### Documentação das apis

Documentação da Api com Swagger (pode ser usado para executar as ações)
<p align="center"><img src="swagger_v2.png" width="55%"/>

______

Exemplo de criação de agendamento usando curl:
```
 curl -X 'POST' \
   'http://20.206.160.37:8080/agendamento' \
   -H 'Content-Type: application/json' \
   -d '{
   "cliente": "Empresas silva",
   "material": "Variados",
   "cidade": "São Paulo",
   "quantidade": 200,
   "data": "2024-10-29"
 }'
```

#### 
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

https://hub.docker.com/repository/docker/csassis/coleta-docker/general

Docker hub
<p align="center"><img src="docker-hub.png" width="55%"/>
                   
______


## Fluxo estrutural 

Exemplo do maven.yml (workflow)
```  
name: Automatização da CI da coleta.

on:
  pull_request:
    branches: [ "main" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v4
    - name: instalacao do java
      uses: actions/setup-java@v4
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven
    - name: configuracao das dependecias do projeto usando  Maven
      run: mvn -B package --file pom.xml

    # Optional: Uploads the full dependency graph to GitHub to improve the quality of Dependabot alerts this repository can receive
    - name: atualiza todas dependecias do CI
      uses: advanced-security/maven-dependency-submission-action@571e99aab1055c2e71a1e2309b9691de18d6b7d6
```

Fluxo do CI / CD
<p align="center"><img src="coleta-fluxo.png" width="55%"/>

Workflows executados
<p align="center"><img src="workflows.png" width="55%"/>

______

#### Resources 

Todos os recursos utilizados na azzure
<p align="center"><img src="resources.png" width="55%"/>

______


#### Stage 

Logs da app em Stage
<p align="center"><img src="stage_logs.png" width="55%"/>

______

Topologia da app em Stage
<p align="center"><img src="stage_topology.png" width="55%"/>

______

#### Production 
Logs da app em Produção
<p align="center"><img src="production_logs.png" width="55%"/>

______

Topologia da app em Produção
<p align="center"><img src="production_topology.png" width="70%"/>

