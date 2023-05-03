package modelo;

public class Bebida extends Produto {
	private String Marca;
	private long VCal;
	

	public Bebida(String nome, long quantidade, float preco, Filial filial, String Marca, long VCal,DataValidade data) {
	    this.nome = nome;
	    Quantidade = quantidade;
	    Preco = preco;
	    this.filial = filial;
	    this.Marca = Marca;
	    this.VCal = VCal;
	    this.data = data;
	}
	
	public Bebida() {
		super();
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
	
	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public long getVCal() {
		return VCal;
	}

	public void setVCal(long vCal) {
		VCal = vCal;
	}
	
	public DataValidade getData() {
		return data;
	}

	public void setData(DataValidade data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "\nMarca da Bebida= " + Marca + "\nValor Calorico= " + VCal + "\nNome= " + nome + "\nQuantidade= " + Quantidade
				+ "\nPreco= " + Preco + "\nFilial= " + filial.getNome() + data;
	}

	
	
}

