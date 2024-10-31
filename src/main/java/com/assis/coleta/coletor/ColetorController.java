package com.assis.coleta.coletor;

@org.springframework.web.bind.annotation.RestController
public class ColetorController {

    private com.assis.coleta.agendamento.AgendamentoService agendamentoService;

    public ColetorController(com.assis.coleta.agendamento.AgendamentoService agendamentoService) {
            this.agendamentoService = agendamentoService;
    }

    @org.springframework.web.bind.annotation.PutMapping(
            "/coletor/atribuicao/{nomeColetor}/{agendamentoId}"
    )
    public void atribuir(
            @org.springframework.web.bind.annotation.PathVariable String nomeColetor,
            @org.springframework.web.bind.annotation.PathVariable Integer agendamentoId
    ) {
        agendamentoService.atribuirAgendamento(nomeColetor, agendamentoId);
    }

    @org.springframework.web.bind.annotation.GetMapping("/coletores")
    public Iterable<Coletor> getColetores() {
        return agendamentoService.findAllColetores();
    }

}
