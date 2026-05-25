# Composite AntiPattern — Diagrama UML (ASCII)

## Estrutura

```
+-------------------------------+    +-------------------------------+
|   CategoriaMenuAntiPattern    |    |   ItemCardapioAntiPattern     |
|-------------------------------|    |-------------------------------|
| - nome: String                |    | - nome: String                |
| - itens: List<ItemCardapio>   |    | - preco: double               |
| - subcategorias: List<Categ.> |    |-------------------------------|
|-------------------------------|    | + getNome(): String           |
| + adicionarItem(Item)         |    | + getPreco(): double          |
| + adicionarSubcategoria(Categ)|    +-------------------------------+
| + getItens(): List<Item>      |
| + getSubcategorias(): List<C> |
| + getNome(): String           |
+-------------------------------+
```

## Problema

Não existe interface comum entre `CategoriaMenuAntiPattern` e `ItemCardapioAntiPattern`.  
O cliente precisa saber exatamente com qual tipo está lidando para tratá-los diferente:

```
Application
  → chama getItens()        // só funciona em Categoria
  → chama getSubcategorias()// só funciona em Categoria
  → chama getNome/getPreco  // só funciona em Item
```

## Relações

| Elemento                   | Papel no AntiPattern                        |
|----------------------------|---------------------------------------------|
| CategoriaMenuAntiPattern   | Composite sem interface compartilhada       |
| ItemCardapioAntiPattern     | Leaf sem interface compartilhada            |
| Application                | Trata os dois tipos manualmente             |

## Como corrigir?

→ Criar a interface `ComponenteMenu` com `exibir()` e `getPreco()`.  
  Ambas as classes a implementam — cliente passa a tratar tudo de forma uniforme.
