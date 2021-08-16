package br.pucpr.servico.model;

import java.time.Year;

public class Produto {

    private int id;
    private String nome;
    private Year anoFabricacao;
    private String ean;

    public Produto(int id, String nome, Year anoFabricacao, String ean) {
        this.id = id;
        this.nome = nome;
        this.anoFabricacao = anoFabricacao;
        this.ean = ean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Year getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Year anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
}
