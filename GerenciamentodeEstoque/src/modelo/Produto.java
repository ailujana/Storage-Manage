package modelo;

public abstract class Produto {
    protected String nome;
    protected long Quantidade;
    protected float Preco;
    protected Filial filial;
    protected DataValidade data;


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

	
	public DataValidade getData() {
		return data;
	}

	public void setData(DataValidade data) {
		this.data = data;
	}
}
