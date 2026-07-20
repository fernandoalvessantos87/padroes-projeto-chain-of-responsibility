package com.dio.aprovacao;

public class Gerente extends AprovadorBase {

    @Override
    protected double getLimiteAprovacao() {
        return 5000.0;
    }

    @Override
    protected String getCargo() {
        return "Gerente";
    }
}
