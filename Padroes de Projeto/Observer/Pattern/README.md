# Observer Pattern — Diagrama UML (ASCII)

## Estrutura

```
+-----------------------------+
|       <<interface>>         |
|     NotificacaoObserver     |
|-----------------------------|
| + atualizar(numeroPedido,   |
|             status): void   |
+-----------------------------+
              ^
              |  implements
    __________|_______________
    |          |              |
    v          v              v
+----------+ +----------+ +-----------+
| Notificacao| Notificacao| Notificacao|
|   Email   | |   SMS    | |   Push    |
|----------| |----------| |-----------|
|- email   | |-telefone | |-dispositivo|
|+atualizar| |+atualizar| |+atualizar | |
+----------+ +----------+ +-----------+

+-------------------------------+
|      GerenciadorPedido        |  <Subject / Publisher>
|-------------------------------|
| - numeroPedido: String        |
| - status: String              |
| - observers: List<Observer>   |
|-------------------------------|
| + adicionarObserver(Observer) |
| + removerObserver(Observer)   |
| + atualizarStatus(String)     |
| - notificarTodos()            |
+-------------------------------+
        |
        | notifica (1..*)
        v
+-----------------------------+
|     NotificacaoObserver     |
+-----------------------------+
```

## Relações

| Elemento             | Papel                        |
|----------------------|------------------------------|
| NotificacaoObserver  | Observer (interface)         |
| NotificacaoEmail     | ConcreteObserver A           |
| NotificacaoSMS       | ConcreteObserver B           |
| NotificacaoPush      | ConcreteObserver C           |
| GerenciadorPedido    | Subject (Publisher)          |

## Por que é um PATTERN?

- O `GerenciadorPedido` **não conhece** os tipos concretos de notificação.  
- Novos canais (WhatsApp, Telegram…) se registram **sem alterar** o subject.  
- Segue **OCP** e promove **baixo acoplamento** entre publisher e subscribers.
