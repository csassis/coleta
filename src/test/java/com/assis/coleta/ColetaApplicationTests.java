package com.assis.coleta;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
class ColetaApplicationTests {

    @org.springframework.beans.factory.annotation.Autowired
    private AgendamentoService agendamentoService;

    com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

    @Test
    void contextLoads() {
    }

    @Test
    void saveAgendamentoTest() {
        com.assis.coleta.Agendamento agendamento = new com.assis.coleta.Agendamento();
        agendamento.setCliente(faker.name().name());
        agendamento.setCidade(faker.country().capital());
        agendamento.setMaterial(faker.animal().name());
        agendamento.setQuantidade(faker.number().numberBetween(1, 100));
        agendamento.setData(java.time.LocalDate.now());
        agendamentoService.save(agendamento);
    }

}
