package com.dio.aprovacao;

public class Diretor extends AprovadorBase {

    @Override
    protected double getLimiteAprovacao() {
        return 20000.0;
    }

    @Override
    protected String getCargo() {
        return "Diretor";
    }
}
