package com.assis.coleta.coletor;

public class Coletor {

    private String nome;
    private java.util.List<com.assis.coleta.agendamento.Agendamento> pendentes = new java.util.ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public java.util.List<com.assis.coleta.agendamento.Agendamento> getPendentes() {
        return pendentes;
    }

    public void addAgendamento(com.assis.coleta.agendamento.Agendamento agendamento) {
        for (com.assis.coleta.agendamento.Agendamento pendente : getPendentes()) {
            if(pendente.getId() == agendamento.getId()) {
                return;
            }
        }
        getPendentes().add(agendamento);
    }
}
