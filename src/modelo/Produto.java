package modelo;

/**
 * Classe Abstrata que representa um Produto e possui nome, quantidade, preco e data.
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * */


public abstract class Produto {
    protected String nome;
    protected int quantidade;
    protected float preco;
    protected String data;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}