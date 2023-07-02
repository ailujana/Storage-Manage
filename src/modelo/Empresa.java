package modelo;

import java.util.ArrayList;

/**
 * Classe Empresa que armazena suas filiais 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * */

public class Empresa {

	private String nome;
	private int numTel;
	private String endereco;
	private String cnpj;
	private ArrayList<Filial> filiais = new ArrayList<Filial>();
	
	/**
	 * Parametros do Construtor da Classe Empresa
	 * @param nome
	 * @param numTel
	 * @param endereco
	 * @param cnpj
	 * */

	public Empresa(String nome, int numTel, String endereco, String cnpj) {
		this.nome = nome;
		this.numTel = numTel;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}

	public Empresa() {

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

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	public void setFiliais(Filial filial) {
		filiais.add(filial);
	}

	@Override
	public String toString() {
		return "Nome da Empresa= " + nome + "\nNumero do Telefone= " + numTel + "\nEndereco= " + endereco + "\nCNPJ= "
				+ cnpj
				+ "\nFiliais= " + filiais;
	}

	/**
	 * Metodo criado para preencher os dados pre cadastrados para colocar na Jlist da Tela Filial
	 * do pacote View.
	 * Foi criada uma instancia da classe Filial e foram colocados exemplos de atributos.
	 * A Filial "teste" foi inserida no ArrayList de Filiais.
	 * */ 
	public void fillWithSomeData() {
		for (int e = 0; e < 5; e++) {
			Filial teste = new Filial();
			String nome = "Filial" + e;
			int numTel = 645678123 + e;
			String endereco = "rua" + e;
			String cnpj = "123456789" + e;
			String tipo = "Fornece" + e;

			teste.setCNPJ(cnpj);
			teste.setNome(nome);
			teste.setNumTel(numTel);
			teste.setTipo(tipo);
			teste.setEndereco(endereco);

			filiais.add(teste);

		}
	}
	
	/**
	 * Metodo criado para armazenar os nomes das Filiais cadastradas em um vetor de String.
	 * @return String[]
	 * */

	public String[] getNomesFiliais() {
		int t = filiais.size();
		String s[] = new String[t];
		int i = 0;
		for (Filial j : filiais) {
			s[i] = j.getNome();
			i++;
		}
		return s;
	}
	
	/**
	 * O codigo itera sobre as filiais e os produtos de estoque de cada filial, 
	 * adicionando os nomes dos produtos em um ArrayList chamado todosProdutos. 
	 * No final, e retornado um array de String contendo todos os produtos 
	 * convertendo o ArrayList usando o metodo toArray(). 
	 * @return String[]
	 * */
	
	public String[] listarTodosProdutos() {
	    ArrayList<String> todosProdutos = new ArrayList<>();

	    for (Filial filial : filiais) {
	        for (Produto produto : filial.getProdutodeEstoque()) {
	            todosProdutos.add(produto.getNome());
	        }
	    }

	    return todosProdutos.toArray(new String[todosProdutos.size()]);
	}

	
	

}
