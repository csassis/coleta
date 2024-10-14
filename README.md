#### coleta
 Coleta é uma api que disponibiliza o agendamento e a execução de coletas.

#### Tecnologia
 - Java 17
 - Spring boot
 - H2
 - Tomcat
 - Github actions
 - Docker
 - Rest Api

#### Fluxo estrutural 
![Fluxo da imagem](coleta-flow.png)


#### Use Cases

 - Criação de agendamento
 - Listagem de agendamentos realizados
 - Exclusão ou alteração de um agendamento

#### Exemplos de api

Exemplo de criação de uma agendamento
```
curl --location 'http://localhost:8080/agendamento' \
--header 'Content-Type: application/json' \
--data '  {
    "cliente": "Cliente loe",
    "material": "Latinha",
    "cidade": "SP",
    "quantidade": 12,
    "data": null
}'
```
