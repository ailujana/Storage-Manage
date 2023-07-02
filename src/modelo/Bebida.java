package modelo;

/**
 * Classe Bebida representa uma Bebida e herda da Classe Produto.
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * */

public class Bebida extends Produto {
	private String marca;
	private int vCal;

	/** 
	 * Parametros do Construtor da CBebida
	 * @param nome
	 * @param quantidade
	 * @param preco
	 * @param marca
	 * @param vCal
	 * @param data
	 * */
	
	public Bebida(String nome, int quantidade, float preco, String marca, int vCal, String data) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.marca = marca;
		this.vCal = vCal;
		this.data = data;
	}

	public Bebida() {

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getVCal() {
		return vCal;
	}

	public void setVCal(int vCal) {
		this.vCal = vCal;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "\nMarca da Bebida= " + marca + "\nValor Calorico= " + vCal + "\nNome= " + nome + "\nQuantidade= "
				+ quantidade
				+ "\nPreco= " + preco + "\nData= " + data;
	}

}
