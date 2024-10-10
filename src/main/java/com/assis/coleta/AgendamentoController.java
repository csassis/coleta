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

    @org.springframework.web.bind.annotation.PostMapping("/agendamento")
    public void addAgendamento(@org.springframework.web.bind.annotation.RequestBody Agendamento parametro){
        agendamentoService.save(parametro);
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamento/count")
    public long count(){
        return agendamentoService.count();
    }
}