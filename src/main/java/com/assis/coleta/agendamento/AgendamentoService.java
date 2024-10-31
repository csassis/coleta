package com.assis.coleta.agendamento;

@org.springframework.stereotype.Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public void save(Agendamento novo) {
        repository.save(novo);
    }

    public Iterable<Agendamento> findAllAgendamentos() {
        return repository.findAll();
    }

    public Iterable<com.assis.coleta.agendamento.Agendamento> findAgendamentosSemColetor() {
        java.util.List<Agendamento> agendamentosSemColetor = new java.util.ArrayList<>();
        for (com.assis.coleta.agendamento.Agendamento agendamento : findAllAgendamentos()) {
            if(org.apache.commons.lang3.StringUtils.isEmpty(agendamento.getColetorNome())){
                agendamentosSemColetor.add(agendamento);
            }
        }
        return agendamentosSemColetor;
    }

    public Iterable<com.assis.coleta.agendamento.Agendamento> findAgendamentos(java.time.LocalDate dateParam) {
        java.util.List<Agendamento> agendamentosDeHoje = new java.util.ArrayList<>();
        for (com.assis.coleta.agendamento.Agendamento agendamento : findAllAgendamentos()) {
            if (agendamento.getData() != null && agendamento.getData().isEqual(dateParam)) {
                agendamentosDeHoje.add(agendamento);
            }
        }
        return agendamentosDeHoje;
    }

    public void atribuirAgendamento(String nomeColetor, Integer agendamentoId) {

        java.util.Optional<com.assis.coleta.agendamento.Agendamento> agendamentoOptional
                = repository.findById(agendamentoId);

        if (agendamentoOptional.isEmpty())
            throw new com.assis.coleta.agendamento.AgendamentoNaoExisteException(agendamentoId);

        if(com.assis.coleta.coletor.ColetoresStatic.agendamentoJaEstaComAlgumColetor(agendamentoId))
            throw new com.assis.coleta.agendamento.AgendamentoJaAssociadoException(agendamentoId);

        com.assis.coleta.coletor.Coletor coletor = com.assis.coleta.coletor.ColetoresStatic.getOrAddColetor(nomeColetor);
        com.assis.coleta.agendamento.Agendamento agendamento = agendamentoOptional.get();
        coletor.addAgendamento(agendamento);
        agendamento.setColetorNome(coletor.getNome());
        repository.save(agendamento);
    }

    public Iterable<com.assis.coleta.coletor.Coletor> findAllColetores() {
        return com.assis.coleta.coletor.ColetoresStatic.getColetores();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
