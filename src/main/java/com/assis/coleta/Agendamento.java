package com.assis.coleta;

@jakarta.persistence.Entity
public class Agendamento {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private int id;
    private String cliente;
    private String material;
    private String cidade;
    private int quantidade;
    private java.time.LocalDate data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public java.time.LocalDate getData() {
        return data;
    }

    public void setData(java.time.LocalDate data) {
        this.data = data;
    }
}
