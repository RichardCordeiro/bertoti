# Composite Pattern — Diagrama UML (ASCII)

## Estrutura

```
+-----------------------------+
|       <<interface>>         |
|      ComponenteMenu         |
|-----------------------------|
| + exibir(indent: String)    |
| + getPreco(): double        |
+-----------------------------+
              ^
              |  implements
       _______|_______
       |              |
       v              v
+---------------+  +---------------------------+
| ItemCardapio  |  |       CategoriaMenu       |
| (Leaf)        |  | (Composite)               |
|---------------|  |---------------------------|
| - nome: String|  | - nome: String            |
| - preco:double|  | - filhos: List<Componente>|
|---------------|  |---------------------------|
| +exibir()     |  | + adicionar(Componente)   |
| +getPreco()   |  | + remover(Componente)     |
+---------------+  | + exibir()               |
                   | + getPreco()              |
                   +---------------------------+
                          |
                          | contém (0..*)
                          v
                   +--------------------+
                   |   ComponenteMenu   |
                   +--------------------+
                   (pode ser ItemCardapio
                    ou outra CategoriaMenu)
```

## Hierarquia de exemplo

```
[Cardápio do Restaurante]
  [Entradas]
    - Bruschetta: R$ 18,90
    - Caldo de Feijão: R$ 12,00
  [Pratos Principais]
    [Carnes]
      - Picanha na Brasa: R$ 89,90
      - Frango Grelhado: R$ 52,00
    [Massas]
      - Spaghetti Carbonara: R$ 45,00
      - Lasanha Bolonhesa: R$ 49,90
  [Sobremesas]
    - Pudim de Leite: R$ 15,00
    - Mousse de Chocolate: R$ 17,00
```

## Relações

| Elemento       | Papel                  |
|----------------|------------------------|
| ComponenteMenu | Component (interface)  |
| ItemCardapio   | Leaf (nó folha)        |
| CategoriaMenu  | Composite (nó interno) |

## Por que é um PATTERN?

- Cliente usa a mesma interface `ComponenteMenu` para **folhas e compostos**.  
- Permite construir **hierarquias arbitrárias** sem if/else no cliente.  
- `getPreco()` propaga recursivamente por toda a árvore — transparência total.
