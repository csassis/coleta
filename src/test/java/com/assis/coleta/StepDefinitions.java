package com.assis.coleta;

import io.cucumber.java.en.*;

@io.cucumber.spring.CucumberContextConfiguration
@org.springframework.boot.test.context.SpringBootTest(
        webEnvironment = org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class StepDefinitions {

    @org.springframework.boot.test.web.server.LocalServerPort
    private int port;

    @org.springframework.beans.factory.annotation.Autowired
    private org.springframework.boot.test.web.client.TestRestTemplate restTemplate;

    com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

    @Given("Eu quero salvar {int} agendamentos")
    public void givenAgendamentosTest(int quantidadeAgendamentos) throws java.io.IOException {
        for (int indice = 0; indice < quantidadeAgendamentos; indice++) {
            com.assis.coleta.agendamento.AgendamentoRequest agendamento = new com.assis.coleta.agendamento.AgendamentoRequest();
            agendamento.setCliente(faker.name().name());
            agendamento.setCidade(faker.country().capital());
            agendamento.setMaterial(faker.animal().name());
            agendamento.setQuantidade(indice);
            saveRequest(agendamento);
        }
    }

    @When("Quando tiver {int} agendamentos")
    public void whenAgendamentosTest(int quantidadeAgendamentos) throws java.io.IOException {
        java.util.ArrayList<com.assis.coleta.agendamento.AgendamentoResponse> agendamentos =
                org.assertj.core.util.Lists.newArrayList(findAllAgendamentos());
        org.junit.jupiter.api.Assertions.assertEquals(quantidadeAgendamentos, agendamentos.size());
    }

    @Then("Atribua um agendamento sem coletor para {string}")
    public void thenAgendamentosTest(String nomeColetor) throws java.io.IOException {
        int agendamentoId = findAgendamentosSemColetor().iterator().next().getId();
        atribuirAgendamento(nomeColetor, agendamentoId);
    }

    @When("Deve ter {int} agendamento sem coletor")
    public void whenAgendamentosSemColetor(int quantidadeSemColetor) throws java.io.IOException {
        java.util.ArrayList<com.assis.coleta.agendamento.AgendamentoResponse> agendamentos =
                org.assertj.core.util.Lists.newArrayList(findAgendamentosSemColetor());
        org.junit.jupiter.api.Assertions.assertEquals(quantidadeSemColetor, agendamentos.size());
    }

    @Then("exclui os agendamentos")
    public void thenExcluiAgendamentosTest() throws java.io.IOException {
        int statusCode =
                org.apache.http.client.fluent.Request
                        .Delete("http://localhost:" + port + "/agendamentos/all")
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnResponse()
                        .getStatusLine()
                        .getStatusCode();

        org.junit.jupiter.api.Assertions.assertEquals(200, statusCode);
    }


    private void saveRequest(com.assis.coleta.agendamento.AgendamentoRequest agendamentoRequest) throws java.io.IOException {
        String json = new com.google.gson.Gson().toJson(agendamentoRequest);

        int statusCode =
                org.apache.http.client.fluent.Request
                        .Post("http://localhost:" + port + "/agendamento")
                        .addHeader("Content-Type", "application/json")
                        .bodyString(json, org.apache.http.entity.ContentType.APPLICATION_JSON)
                        .execute()
                        .returnResponse()
                        .getStatusLine()
                        .getStatusCode();

        org.junit.jupiter.api.Assertions.assertEquals(200, statusCode);
    }


    private java.util.List<com.assis.coleta.agendamento.AgendamentoResponse> findAgendamentosSemColetor() throws java.io.IOException {
        String jsonResponse =
                org.apache.http.client.fluent.Request
                        .Get("http://localhost:" + port + "/agendamentos/sem-coletor")
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnContent()
                        .asString();
        return java.util.List.of(new com.google.gson.Gson().fromJson(jsonResponse, com.assis.coleta.agendamento.AgendamentoResponse[].class));
    }

    private java.util.List<com.assis.coleta.agendamento.AgendamentoResponse> findAllAgendamentos() throws java.io.IOException {
        String jsonResponse =
                org.apache.http.client.fluent.Request
                        .Get("http://localhost:" + port + "/agendamentos")
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnContent()
                        .asString();
        return java.util.List.of(new com.google.gson.Gson().fromJson(jsonResponse, com.assis.coleta.agendamento.AgendamentoResponse[].class));
    }

    private void atribuirAgendamento(String nomeColetor, int agendamentoId) throws java.io.IOException {
        int statusCode =
                org.apache.http.client.fluent.Request
                        .Put("http://localhost:" + port + "/coletor/atribuicao/" + nomeColetor + "/" + agendamentoId)
                        .addHeader("Content-Type", "application/json")
                        .execute()
                        .returnResponse()
                        .getStatusLine()
                        .getStatusCode();

        org.junit.jupiter.api.Assertions.assertEquals(200, statusCode);
    }
}