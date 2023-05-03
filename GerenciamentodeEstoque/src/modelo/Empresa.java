package modelo;

import java.util.ArrayList;

public class Empresa {

    protected String nome;
    protected long NumTel;
    protected String endereco;
    protected String CNPJ;
    protected ArrayList<Filial> Filiais = new ArrayList<Filial>();
    

    public Empresa(String nome, long NumTel, String endereco, String CNPJ){
        this.nome = nome;
        this.NumTel = NumTel;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
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


	public ArrayList<Filial> getFiliais() {
		return Filiais;
	}


	public void setFiliais(ArrayList<Filial> filiais) {
		Filiais = filiais;
	}


	@Override
	public String toString() {
		return "Nome da Empresa= " + nome + "\nNumero do Telefone= " + NumTel + "\nEndereco= " + endereco + "\nCNPJ= " + CNPJ
				+ "\nFiliais= " + Filiais;
	}
    
    
    
    
}
    
	


