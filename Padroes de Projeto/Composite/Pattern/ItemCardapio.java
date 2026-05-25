package pattern;

// Leaf: elemento folha (não tem filhos)
public class ItemCardapio implements ComponenteMenu {
    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s- %s: R$ %.2f%n", indentacao, nome, preco);
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
