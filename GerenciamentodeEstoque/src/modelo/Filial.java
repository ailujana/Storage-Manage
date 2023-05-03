package modelo;

import java.util.ArrayList;

public class Filial{

    protected String nome;
    protected long NumTel;
    protected String endereco;
    protected String CNPJ;
    protected ArrayList<Produto> ProdutodeEstoques = new ArrayList<Produto>();
    protected String tipo;



    public Filial(String nome, long NumTel, String endereco, String CNPJ, String tipo){
        this.nome = nome;
        this.NumTel = NumTel;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
        this.tipo = tipo;
    }



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public long getNumTel() {
		return NumTel;
	}



	public void setNumTel(long numTel) {
		NumTel = numTel;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getCNPJ() {
		return CNPJ;
	}



	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}



	public ArrayList<Produto> getProdutodeEstoques() {
		return ProdutodeEstoques;
	}



	public void setProdutodeEstoques(ArrayList<Produto> produtodeEstoques) {
		ProdutodeEstoques = produtodeEstoques;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	@Override
	public String toString() {
		return "\nNome da Filial= " + nome + "\nNumero do Telefone= " + NumTel + "\nEndereco= " + endereco + "\nCNPJ=" + CNPJ
				+ "\nProdutos de Estoque= " + ProdutodeEstoques + "\nTipo= " + tipo;
	}
    
    
    
    

    

}