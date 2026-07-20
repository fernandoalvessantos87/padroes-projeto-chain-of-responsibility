package com.dio.aprovacao;

public class Supervisor extends AprovadorBase {

    @Override
    protected double getLimiteAprovacao() {
        return 1000.0;
    }

    @Override
    protected String getCargo() {
        return "Supervisor";
    }
}
