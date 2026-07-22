package com.dio.aprovacao;

public class Main {

    public static void main(String[] args) {

        Aprovador supervisor = new Supervisor();
        Aprovador gerente = new Gerente();
        Aprovador diretor = new Diretor();

        supervisor.definirProximo(gerente);
        gerente.definirProximo(diretor);

        SolicitacaoCompra compra1 = new SolicitacaoCompra("Materiais de escritório", 350.00);
        SolicitacaoCompra compra2 = new SolicitacaoCompra("Notebooks para a equipe", 4200.00);
        SolicitacaoCompra compra3 = new SolicitacaoCompra("Novo servidor", 18000.00);
        SolicitacaoCompra compra4 = new SolicitacaoCompra("Reforma da sede", 50000.00);

        System.out.println("--- Solicitação 1 ---");
        supervisor.aprovar(compra1);

        System.out.println("\n--- Solicitação 2 ---");
        supervisor.aprovar(compra2);

        System.out.println("\n--- Solicitação 3 ---");
        supervisor.aprovar(compra3);

        System.out.println("\n--- Solicitação 4 ---");
        supervisor.aprovar(compra4);
    }
}
