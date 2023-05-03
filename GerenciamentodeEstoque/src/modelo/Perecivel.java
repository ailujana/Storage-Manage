package modelo;


public class Perecivel extends Produto {
	String tipo; 
	
	public Perecivel(String nome, long quantidade, float preco, Filial filial, String tipo, DataValidade data) {

	    this.nome = nome;
	    Quantidade = quantidade;
	    Preco = preco;
	    this.filial = filial;
	    this.tipo = tipo;
	    this.data = data;
	}
	
	
	public DataValidade getDatadeValidade() {
		return data;
	}

	public void setDatadeValidade(DataValidade data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public long getQuantidade(){
        return Quantidade;
    }

    public void setQuantidade(long quantidade){
        Quantidade = quantidade;
    }

    public float getPreco(){
        return Preco;
    }

    public void setPreco(float preco){
        Preco = preco;
    }

    public Filial getFilial(){
        return filial;
    }

    public void setFilial(Filial filial){
        this.filial =  filial;
    }


	@Override
	public String toString() {
		return "\nTipo= " + tipo + "\nNome= " + nome + "\nQuantidade= " + Quantidade + "\nPreco= " + Preco
				+ "\nFilial= " + filial.getNome() + data;
	}


	
	

}

