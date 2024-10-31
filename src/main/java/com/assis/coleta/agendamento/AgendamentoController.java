package com.assis.coleta.agendamento;

@org.springframework.web.bind.annotation.RestController
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamentos")
    public Iterable<Agendamento> getAgendamentos() {
        return agendamentoService.findAllAgendamentos();
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamentos/hoje")
    public Iterable<AgendamentoResponse> getAgendamentosParaHoje() {
        return convertToResponse(agendamentoService.findAgendamentos(java.time.LocalDate.now()));
    }

    @org.springframework.web.bind.annotation.GetMapping("/agendamentos/sem-coletor")
    public Iterable<AgendamentoResponse> findAgendamentosSemColetor() {
        return convertToResponse(agendamentoService.findAgendamentosSemColetor());
    }

    @org.springframework.web.bind.annotation.PostMapping("/agendamento")
    public void addAgendamento(@org.springframework.web.bind.annotation.RequestBody AgendamentoRequest parametro) {
        agendamentoService.save(parametro.convertToAgendamento());
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/agendamentos/all")
    public void deleteAll() {
        agendamentoService.deleteAll();
    }

    private Iterable<com.assis.coleta.agendamento.AgendamentoResponse> convertToResponse(Iterable<Agendamento> agendamentos) {
        java.util.List<com.assis.coleta.agendamento.AgendamentoResponse> list = new java.util.ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            com.assis.coleta.agendamento.AgendamentoResponse agendamentoResponse = new com.assis.coleta.agendamento.AgendamentoResponse();
            agendamentoResponse.setId(agendamento.getId());
            agendamentoResponse.setQuantidade(agendamento.getQuantidade());
            agendamentoResponse.setMaterial(agendamento.getMaterial());
            agendamentoResponse.setNomeColetor(agendamento.getColetorNome());
            list.add(agendamentoResponse);
        }
        return list;
    }
}
