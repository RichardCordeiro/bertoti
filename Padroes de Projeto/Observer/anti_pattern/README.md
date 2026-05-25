# Observer AntiPattern — Diagrama UML (ASCII)

## Estrutura

```
+---------------------------------------------+
|         GerenciadorPedidoAntiPattern        |
|---------------------------------------------|
| - numeroPedido: String                      |
| - status: String                            |
| - notificarEmail: boolean   ← hardcoded     |
| - emailDestinatario: String ← hardcoded     |
| - notificarSMS: boolean     ← hardcoded     |
| - telefoneDestinatario: String              |
| - notificarPush: boolean    ← hardcoded     |
| - dispositivoDestinatario: String           |
|---------------------------------------------|
| + configurarEmail(String)                   |
| + configurarSMS(String)                     |
| + configurarPush(String)                    |
| + atualizarStatus(String)                   |
|   ┌─────────────────────────────────────┐   |
|   │ if notificarEmail → envia email     │   |
|   │ if notificarSMS   → envia SMS       │   |
|   │ if notificarPush  → envia Push      │   |
|   │ // WhatsApp? → editar aqui ❌       │   |
|   └─────────────────────────────────────┘   |
+---------------------------------------------+
```

## Problemas

| Problema                    | Descrição                                                     |
|-----------------------------|---------------------------------------------------------------|
| Alto acoplamento            | Subject conhece todos os canais concretos                    |
| Viola OCP                   | Novo canal = modificar `atualizarStatus()`                   |
| Não extensível              | Impossível registrar/remover observers em runtime            |
| Responsabilidade única      | Uma classe gerencia pedido E envia notificações              |
| Difícil de testar           | Não há como mockar canais individualmente                    |

## Como corrigir?

→ Aplicar o **Observer Pattern**: criar a interface `NotificacaoObserver`  
  e fazer o subject manter uma lista de observers, sem conhecer suas implementações.
