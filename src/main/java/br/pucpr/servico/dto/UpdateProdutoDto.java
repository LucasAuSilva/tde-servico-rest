package br.pucpr.servico.dto;

import java.time.Year;
import java.util.ArrayList;

import br.pucpr.servico.model.Produto;

public class UpdateProdutoDto {

    private String nome;
    private Year anoFabricacao;
    private String ean;

    public String getNome() {
        return nome;
    }

    public Year getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public String getEan() {
        return ean;
    }

    public Produto update(int id, ArrayList<Produto> produtos) {
        // TODO: achar um jeito melhor de tratar campos nulos;
        Produto produto = produtos.get(id - 1);
        if (this.nome != null) {
            produto.setNome(getNome());
        }
        if (this.anoFabricacao != null) {
            produto.setAnoFabricacao(getAnoFabricacao());
        }
        if (this.ean != null) {
            produto.setEan(getEan());
        }
        return produto;
    }
}
