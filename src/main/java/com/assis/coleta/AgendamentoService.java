package com.assis.coleta;

@org.springframework.stereotype.Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public void save(Agendamento novo){
        repository.save(novo);
    }

    public Iterable<Agendamento> findAll(){
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

    public void update(com.assis.coleta.Agendamento parametro) {
        repository.deleteById(parametro.getId());
        repository.save(parametro);
    }

    public Iterable<com.assis.coleta.Agendamento> findAgendamentos(java.time.LocalDate dateParam) {
        java.util.List<Agendamento> agendamentosDeHoje = new java.util.ArrayList<>();
        for (com.assis.coleta.Agendamento agendamento : findAll()) {
            if(agendamento.getData() != null && agendamento.getData().isEqual(dateParam)) {
                agendamentosDeHoje.add(agendamento);
            }
        }
        return agendamentosDeHoje;
    }
}
