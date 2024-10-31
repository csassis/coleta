package com.assis.coleta;


@org.junit.jupiter.api.Nested
@org.springframework.boot.test.context.SpringBootTest(
        webEnvironment = org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
)
class SaveHttpTests {

    @org.springframework.boot.test.web.server.LocalServerPort
    private int port;

    @org.springframework.beans.factory.annotation.Autowired
    private org.springframework.boot.test.web.client.TestRestTemplate restTemplate;

    com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

    @org.junit.jupiter.api.Test
    void saveTest() throws java.io.IOException {

        com.assis.coleta.agendamento.AgendamentoRequest agendamentoRequest = new com.assis.coleta.agendamento.AgendamentoRequest();
        agendamentoRequest.setCidade(faker.address().city());
        agendamentoRequest.setCliente(faker.name().name());
        agendamentoRequest.setMaterial(faker.name().name());
        agendamentoRequest.setQuantidade(40);

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
}
