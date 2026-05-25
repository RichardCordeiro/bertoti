package pattern;

public class Main {
    public static void main(String[] args) {
        // Raiz do menu
        CategoriaMenu menuCompleto = new CategoriaMenu("Cardápio do Restaurante");

        // Categorias de primeiro nível
        CategoriaMenu entradas = new CategoriaMenu("Entradas");
        CategoriaMenu pratosPrincipais = new CategoriaMenu("Pratos Principais");
        CategoriaMenu sobremesas = new CategoriaMenu("Sobremesas");

        // Subcategorias
        CategoriaMenu carnes = new CategoriaMenu("Carnes");
        CategoriaMenu massas = new CategoriaMenu("Massas");

        // Itens folha (Leaf)
        entradas.adicionar(new ItemCardapio("Bruschetta", 18.90));
        entradas.adicionar(new ItemCardapio("Caldo de Feijão", 12.00));

        carnes.adicionar(new ItemCardapio("Picanha na Brasa", 89.90));
        carnes.adicionar(new ItemCardapio("Frango Grelhado", 52.00));

        massas.adicionar(new ItemCardapio("Spaghetti Carbonara", 45.00));
        massas.adicionar(new ItemCardapio("Lasanha Bolonhesa", 49.90));

        pratosPrincipais.adicionar(carnes);
        pratosPrincipais.adicionar(massas);

        sobremesas.adicionar(new ItemCardapio("Pudim de Leite", 15.00));
        sobremesas.adicionar(new ItemCardapio("Mousse de Chocolate", 17.00));

        menuCompleto.adicionar(entradas);
        menuCompleto.adicionar(pratosPrincipais);
        menuCompleto.adicionar(sobremesas);

        // Exibe a árvore inteira de forma uniforme
        menuCompleto.exibir("");

        System.out.printf("%nValor total do cardápio: R$ %.2f%n", menuCompleto.getPreco());
    }
}
