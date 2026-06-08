# Composite Pattern - UML

## Diagrama de classes

```mermaid
classDiagram
    class ComponenteMenu {
        <<interface>>
        +exibir(String indentacao) void
        +getPreco() double
    }

    class ItemCardapio {
        -String nome
        -double preco
        +ItemCardapio(String nome, double preco)
        +exibir(String indentacao) void
        +getPreco() double
    }

    class CategoriaMenu {
        -String nome
        -List~ComponenteMenu~ filhos
        +CategoriaMenu(String nome)
        +adicionar(ComponenteMenu componente) void
        +remover(ComponenteMenu componente) void
        +exibir(String indentacao) void
        +getPreco() double
    }

    ComponenteMenu <|.. ItemCardapio
    ComponenteMenu <|.. CategoriaMenu
    CategoriaMenu o-- "0..*" ComponenteMenu : filhos
```

## Compatibilidade com o padrão

| Elemento | Papel |
|----------|-------|
| `ComponenteMenu` | Component |
| `ItemCardapio` | Leaf |
| `CategoriaMenu` | Composite |
| `filhos` | Lista que permite compor itens e categorias |

## Por que é um pattern?

- `ItemCardapio` e `CategoriaMenu` compartilham a mesma interface.
- O cliente pode tratar folhas e grupos como `ComponenteMenu`.
- `CategoriaMenu` pode conter outros `ComponenteMenu`, permitindo hierarquias recursivas.
- `getPreco()` soma os valores dos filhos, propagando o calculo pela arvore.
- O diagrama é compatível com o código em `Composite/Pattern`.
