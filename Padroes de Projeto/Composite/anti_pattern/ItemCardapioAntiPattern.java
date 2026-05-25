package anti_pattern;

public class ItemCardapioAntiPattern {
    private String nome;
    private double preco;

    public ItemCardapioAntiPattern(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
