package com.dio.aprovacao;

/**
 * Interface que define o contrato de todo "elo" da corrente.
 * Cada aprovador sabe processar a solicitação ou repassá-la ao próximo.
 */
public interface Aprovador {

    // Permite montar a corrente (encadear os aprovadores)
    void definirProximo(Aprovador proximo);

    // Método principal do padrão: tenta aprovar ou repassa adiante
    void aprovar(SolicitacaoCompra solicitacao);
}
