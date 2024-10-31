package com.assis.coleta.agendamento;

public class AgendamentoResponse {

    private Integer id;
    private String nomeColetor;
    private String cliente;
    private String material;
    private int quantidade;

    public String getCliente() {
        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeColetor() {
        return nomeColetor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeColetor(String nomeColetor) {
        this.nomeColetor = nomeColetor;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
