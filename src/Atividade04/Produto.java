package Atividade04;



public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco2) {
        this.id = id;
        this.nome = nome;
        this.preco = preco2;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco;
    }
}
