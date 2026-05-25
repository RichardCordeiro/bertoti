# Strategy AntiPattern — Diagrama UML (ASCII)

## Estrutura

```
+-----------------------------------------------+
|              PedidoAntiPattern                |
|-----------------------------------------------|
| - valor: double                               |
| - tipoPagamento: String  ← magic value        |
| - parcelas: int                               |
|-----------------------------------------------|
| + finalizarPedido()                           |
|   ┌──────────────────────────────────────┐    |
|   │ if (tipo == "pix")    → paga via pix │    |
|   │ elif (tipo == "cartao") → parcela    │    |
|   │ elif (tipo == "boleto") → gera boleto│    |
|   │ else → erro                          │    |
|   └──────────────────────────────────────┘    |
+-----------------------------------------------+
```

## Problemas

| Problema                   | Descrição                                              |
|----------------------------|--------------------------------------------------------|
| Viola OCP                  | Adicionar pagamento exige editar `finalizarPedido()`   |
| Magic strings              | Typos causam erros silenciosos em runtime              |
| Sem polimorfismo           | Nenhuma abstração — lógica toda numa classe só         |
| Difícil de testar          | Impossível mockar estratégias individualmente          |
| Alto acoplamento           | Contexto conhece TODOS os comportamentos concretos     |

## Como corrigir?

→ Aplicar o **Strategy Pattern**: extrair cada `if` em uma classe concreta  
  que implementa uma interface comum (`PagamentoStrategy`).
