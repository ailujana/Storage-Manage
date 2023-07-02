package modelo;

/**
 * Classe Alimento representa um Alimento e herda da Classe Produto.
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * */


public class Alimento extends Produto {
	private String tipo;
	private String categoria;

	/**
	 * Parametros do Construtor da Classe Alimento
	 * @param nome
	 * @param quantidade
	 * @param preco
	 * @param tipo
	 * @param categoria
	 * @param data
	 * */
	
	public Alimento(String nome, int quantidade, float preco, String tipo, String categoria, String data) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.tipo = tipo;
		this.categoria = categoria;
		this.data = data;
	}
	
	public Alimento() {

	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "\nCategoria= " + categoria + "\nTipo= " + tipo + "\nNome= " + nome + "\nQuantidade= " + quantidade
				+ "\nPreco= " + preco
				+ data;
	}

}
