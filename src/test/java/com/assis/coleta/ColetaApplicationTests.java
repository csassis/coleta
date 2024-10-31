package com.assis.coleta;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

@org.junit.jupiter.api.Nested
@SpringBootTest
class ColetaApplicationTests {


    @org.springframework.beans.factory.annotation.Autowired
    private com.assis.coleta.agendamento.AgendamentoService agendamentoService;

    com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

    @Test
    void contextLoads() {
    }

    @Test
    void saveAgendamentoTest() {
        com.assis.coleta.agendamento.Agendamento agendamento = new com.assis.coleta.agendamento.Agendamento();
        agendamento.setCliente(faker.name().name());
        agendamento.setCidade(faker.country().capital());
        agendamento.setMaterial(faker.animal().name());
        agendamento.setQuantidade(faker.number().numberBetween(1, 100));
        agendamento.setData(java.time.LocalDate.now());
        agendamentoService.save(agendamento);
    }

    @Test
    void findAgendamentoTest() {
        com.assis.coleta.agendamento.Agendamento agendamentoUm = new com.assis.coleta.agendamento.Agendamento();
        agendamentoUm.setCliente(faker.name().name());
        agendamentoUm.setCidade(faker.country().capital());
        agendamentoUm.setMaterial(faker.animal().name());
        agendamentoUm.setQuantidade(faker.number().numberBetween(1, 100));
        agendamentoUm.setData(java.time.LocalDate.now());
        agendamentoService.save(agendamentoUm);

        com.assis.coleta.agendamento.Agendamento agendamentoDois = new com.assis.coleta.agendamento.Agendamento();
        agendamentoDois.setCliente(faker.name().name());
        agendamentoDois.setCidade(faker.country().capital());
        agendamentoDois.setMaterial(faker.animal().name());
        agendamentoDois.setQuantidade(faker.number().numberBetween(1, 100));
        agendamentoDois.setData(java.time.LocalDate.now());
        agendamentoService.save(agendamentoDois);

        java.util.Iterator<com.assis.coleta.agendamento.Agendamento> agendamentos = agendamentoService.findAllAgendamentos().iterator();

        org.springframework.util.Assert.notNull(agendamentos.next(), "List sem items");
        org.springframework.util.Assert.notNull(agendamentos.next(), "List sem items");
    }
}
