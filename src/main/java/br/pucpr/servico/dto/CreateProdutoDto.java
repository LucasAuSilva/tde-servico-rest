package br.pucpr.servico.dto;

import java.time.Year;

import br.pucpr.servico.model.Produto;

public class CreateProdutoDto {

    private String nome;
    private Year anoFabricacao;
    private String ean;

    public String getNome() {
        return nome;
    }

    public Year getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getEan() {
        return ean;
    }

    public Produto convert(int id) {
        return new Produto(id, getNome(), getAnoFabricacao(), getEan());
    }
}
