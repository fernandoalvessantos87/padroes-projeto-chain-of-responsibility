# Sistema de Aprovação de Compras — Chain of Responsibility

Projeto desenvolvido para o desafio de **Padrões de Projeto (Design Patterns)**
do Bootcamp Santander 2026 (DIO), com foco no padrão **Chain of Responsibility**
(um dos padrões comportamentais do catálogo GoF), implementado em **Java puro**.

## 💡 O problema

Uma empresa precisa aprovar solicitações de compra, mas cada cargo só pode
autorizar até um determinado valor:

| Cargo       | Limite de aprovação |
|-------------|----------------------|
| Supervisor  | até R$ 1.000,00      |
| Gerente     | até R$ 5.000,00      |
| Diretor     | até R$ 20.000,00     |

Se ninguém na corrente tiver alçada suficiente, a solicitação é recusada.

## 🎯 Por que Chain of Responsibility?

Esse padrão evita um monte de `if/else` (ou `switch`) decidindo "quem aprova o
quê". Em vez disso, cada aprovador só sabe **duas coisas**:
1. Se ele mesmo pode aprovar a solicitação;
2. Para quem repassar, caso não possa.

Isso deixa o código fácil de estender: para adicionar um novo nível de
aprovação (ex: "Vice-presidente"), basta criar uma nova classe e encaixá-la
na corrente — nenhuma classe existente precisa ser alterada.

## 🧱 Estrutura do projeto

```
src/main/java/com/dio/aprovacao/
├── Aprovador.java        -> interface do padrão (contrato da corrente)
├── AprovadorBase.java    -> classe abstrata com a lógica comum de encadeamento
├── Supervisor.java       -> 1º elo da corrente (limite: R$ 1.000)
├── Gerente.java          -> 2º elo da corrente (limite: R$ 5.000)
├── Diretor.java          -> 3º elo da corrente (limite: R$ 20.000)
├── SolicitacaoCompra.java-> objeto que "viaja" pela corrente
└── Main.java             -> monta a corrente e simula 4 solicitações
```

## ▶️ Como executar

Pré-requisito: JDK 17+ instalado.

```bash
# Compilar
javac -d out $(find src -name "*.java")

# Executar
java -cp out com.dio.aprovacao.Main
```

## 📤 Saída esperada

```
--- Solicitação 1 ---
[Supervisor] aprovou a compra "Materiais de escritório" no valor de R$ 350.00

--- Solicitação 2 ---
[Supervisor] não tem alçada para R$ 4200.00. Encaminhando para o próximo nível...
[Gerente] aprovou a compra "Notebooks para a equipe" no valor de R$ 4200.00

--- Solicitação 3 ---
[Supervisor] não tem alçada para R$ 18000.00. Encaminhando para o próximo nível...
[Gerente] não tem alçada para R$ 18000.00. Encaminhando para o próximo nível...
[Diretor] aprovou a compra "Novo servidor" no valor de R$ 18000.00

--- Solicitação 4 ---
[Supervisor] não tem alçada para R$ 50000.00. Encaminhando para o próximo nível...
[Gerente] não tem alçada para R$ 50000.00. Encaminhando para o próximo nível...
Nenhum aprovador na corrente pode autorizar R$ 50000.00. Solicitação recusada.
```
