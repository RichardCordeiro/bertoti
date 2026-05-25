# Strategy Pattern — Diagrama UML (ASCII)

## Estrutura

```
+-----------------------------+
|       <<interface>>         |
|     PagamentoStrategy       |
|-----------------------------|
| + pagar(valor: double): void|
+-----------------------------+
              ^
              |  implements
    __________|___________
    |          |          |
    v          v          v
+----------+ +----------+ +-----------+
|PagamentoPix|PagamentoCartao|PagamentoBoleto|
|----------| |----------| |-----------|
|+pagar()  | |parcelas  | |+pagar()   |
+----------+ |+pagar()  | +-----------+
             +----------+

+----------------------+
|        Pedido        |  <Context>
|----------------------|
| - valor: double      |
| - estrategia:        |
|   PagamentoStrategy  |
|----------------------|
|+setEstrategiaPagamento|
|   (PagamentoStrategy)|
|+finalizarPedido()    |
+----------------------+
        |
        | usa (composição)
        v
+-----------------------------+
|     PagamentoStrategy       |
+-----------------------------+
```

## Relações

| Elemento           | Papel               |
|--------------------|---------------------|
| PagamentoStrategy  | Strategy (interface) |
| PagamentoPix       | ConcreteStrategy A  |
| PagamentoCartao    | ConcreteStrategy B  |
| PagamentoBoleto    | ConcreteStrategy C  |
| Pedido             | Context             |

## Por que é um PATTERN?

- O **contexto** (`Pedido`) não conhece a implementação concreta.  
- Novas formas de pagamento podem ser adicionadas **sem alterar** `Pedido`.  
- Segue **OCP** (Open/Closed Principle) e **DIP** (Dependency Inversion).  
- A estratégia pode ser trocada em **tempo de execução**.
