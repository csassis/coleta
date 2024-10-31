package com.assis.coleta.agendamento;

public class AgendamentoRequest {

    private String cliente;
    private String material;
    private String cidade;
    private int quantidade;

    public Agendamento convertToAgendamento() {
        Agendamento agendamentoModel = new Agendamento();
        agendamentoModel.setData(java.time.LocalDate.now());
        agendamentoModel.setCliente(cliente);
        agendamentoModel.setMaterial(material);
        agendamentoModel.setQuantidade(quantidade);
        agendamentoModel.setCidade(cidade);
        return agendamentoModel;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
