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
}
