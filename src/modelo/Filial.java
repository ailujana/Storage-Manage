package modelo;

import java.util.ArrayList;

/**
 * Classe Filial que armazena seus produtos
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * 
 */

public class Filial {

	private String nome;
	private int numTel;
	private String endereco;
	private String cnpj;
	private ArrayList<Produto> produtodeEstoque = new ArrayList<Produto>();
	private String tipo;

	/**
	 * Parametros do Construtor da Classe Filial
	 * 
	 * @param nome
	 * @param numTel
	 * @param endereco
	 * @param cnpj
	 * @param tipo
	 */

	public Filial(String nome, int numTel, String endereco, String cnpj, String tipo) {
		this.nome = nome;
		this.numTel = numTel;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.tipo = tipo;
	}

	public Filial() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Produto> getProdutodeEstoque() {
		return produtodeEstoque;
	}

	public void setProdutodeEstoque(Produto ProdutodeEstoque) {
		produtodeEstoque.add(ProdutodeEstoque);
	}

	public void setProdutodeEstoque(ArrayList<Produto> produtodeEstoque) {
		this.produtodeEstoque = produtodeEstoque;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "\nNome da Filial= " + nome + "\nNumero do Telefone= " + numTel + "\nEndereco= " + endereco + "\nCNPJ="
				+ cnpj
				+ "\nProdutos de Estoque= " + produtodeEstoque + "\nTipo= " + tipo;
	}

	/**
	 * Metodo criado para armazenar os nomes dos Produtos cadastrados
	 * nas Filiais em um vetor de String.
	 * 
	 * @return String[]
	 */

	public String[] getNomesProdutos() {
		int tamanho = produtodeEstoque.size();
		String[] nomes = new String[tamanho];

		for (int i = 0; i < tamanho; i++) {
			Produto produto = produtodeEstoque.get(i);
			nomes[i] = produto.getNome();
		}

		return nomes;
	}

	/**
	 * Esse codigo compara as filiais com base em seus nomes.
	 * Se os nomes forem iguais, as filiais são consideradas iguais
	 * e o método retorna true, caso contrario, retorna false.
	 * 
	 * @return boolean
	 */

	@Override
	public boolean equals(Object filial) {
		if (this.nome == ((Filial) filial).getNome()) {
			return true;
		}
		return false;
	}
}