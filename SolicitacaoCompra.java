package com.dio.aprovacao;

public class SolicitacaoCompra {

    private final String descricao;
    private final double valor;

    public SolicitacaoCompra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
