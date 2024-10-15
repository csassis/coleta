package com.assis.coleta;

@org.springframework.web.bind.annotation.RestController
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamento")
    public Iterable<Agendamento> getAgendamentos() {
        return agendamentoService.findAll();
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamento-hoje")
    public Iterable<Agendamento> getAgendamentosParaHoje() {
        return agendamentoService.findAgendamentos(java.time.LocalDate.now());
    }

    @org.springframework.web.bind.annotation.PostMapping("/agendamento")
    public void addAgendamento(@org.springframework.web.bind.annotation.RequestBody Agendamento parametro) {
        agendamentoService.save(parametro);
    }

    @org.springframework.web.bind.annotation.PutMapping("/agendamento")
    public void updateAgendamento(@org.springframework.web.bind.annotation.RequestBody Agendamento parametro) {
        agendamentoService.update(parametro);
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamento/count")
    public long count() {
        return agendamentoService.count();
    }
}
