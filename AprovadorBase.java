package com.dio.aprovacao;


public abstract class AprovadorBase implements Aprovador {

    private Aprovador proximo;

    @Override
    public void definirProximo(Aprovador proximo) {
        this.proximo = proximo;
    }

    @Override
    public void aprovar(SolicitacaoCompra solicitacao) {
        if (solicitacao.getValor() <= getLimiteAprovacao()) {
            System.out.printf("[%s] aprovou a compra \"%s\" no valor de R$ %.2f%n",
                    getCargo(), solicitacao.getDescricao(), solicitacao.getValor());
        } else if (proximo != null) {
            System.out.printf("[%s] não tem alçada para R$ %.2f. Encaminhando para o próximo nível...%n",
                    getCargo(), solicitacao.getValor());
            proximo.aprovar(solicitacao);
        } else {
            System.out.printf("Nenhum aprovador na corrente pode autorizar R$ %.2f. Solicitação recusada.%n",
                    solicitacao.getValor());
        }
    }

    protected abstract double getLimiteAprovacao();

    protected abstract String getCargo();
}
