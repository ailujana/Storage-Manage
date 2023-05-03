package modelo;

	public class NaoPerecivel extends Produto {
	String Categoria;

	
	
	public NaoPerecivel(String nome, long quantidade, float preco, Filial filial, String Categoria,DataValidade data) {

    this.nome = nome;
    Quantidade = quantidade;
    Preco = preco;
    this.filial = filial;
    this.Categoria = Categoria;
    this.data = data;
	}
	


	public DataValidade getData() {
	return data;
}

	public void setData(DataValidade data) {
	this.data = data;
}

	public String getCategoria() {
	return Categoria;
}

	public void setCategoria(String Categoria) {
	this.Categoria = Categoria;
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
	return "\nCategoria= " + Categoria + "\nNome= " + nome + "\nQuantidade= " + Quantidade + "\nPreco= " + Preco
			+ "\nFilial= " + filial.getNome() + data;
}



}
