package controle;

import modelo.*;

/**
 * Classe ControleFilial do pacote controle. Manipula os dados da Model para utilizar nas telas do pacote View. 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * */

public class ControleFilial {
  private Empresa empresa;
  
  /**
   * Parametro do construtor da ControleFilial
   * @param empresa, corresponde a classe modelo Empresa
   */

  public ControleFilial(Empresa empresa) {
    this.empresa = empresa;
  }
  
  /**
   *  Ele e responsavel por converter um objeto da classe Produto em um objeto da classe Alimento, 
   *  caso o objeto seja uma instancia da classe Alimento.
   *  @param posF, representa a posicao da filial
   *  @param posP, representa a posicao do produto
   *  @return Alimento
   * 
   * */
  
  public Alimento converterAlimento(int posF, int posP) {
	    Produto produto = empresa.getFiliais().get(posF).getProdutodeEstoque().get(posP);

	    if (produto instanceof Alimento) {
	        return (Alimento) produto;
	    }
		return null;
	}
  
  
  /**
   *  Ele e responsavel por converter um objeto da classe Produto em um objeto da classe Bebida, 
   *  caso o objeto seja uma instancia da classe Bebida.
   *  @param posF, representa a posicao da filial
   *  @param posP, representa a posicao do produto
   *  @return Bebida
   * 
   * */
  
  public Bebida converterBebida(int posF, int posP) {
	    Produto produto = empresa.getFiliais().get(posF).getProdutodeEstoque().get(posP);

	    if (produto instanceof Bebida) {
	        return (Bebida) produto;
	    }
	    return null;
	}
  
  /**
   * 
   * Metodo responsavel por cadastrar os produtos dentro de uma determinada filial.
   * Depois de serem cadastrados, os produtos, sendo eles Alimento ou Bebida,serão
   * cadastrados no índice da filial escolhida no JList da tela. Caso a opcçao seja 1, um
   * Alimento será cadastrado. Caso seja a opção 2, uma Bebida.
   * @param dadosProduto, array de String que representa os dados do produto
   * @param posF, posicao da filial
   * @param posP, posicao do produto
   * @param op, opcao de Alimento ou Bebida
   * */
  
	public boolean cadastroProduto(String[] dadosProduto, int posF, int posP, int op) {
		Produto produto;

		switch (op) {
		case 1:
			if (dadosProduto[0].matches("^$|^\\s*$") || !dadosProduto[1].matches("[0-9]+")
					|| !dadosProduto[2].matches("[0-9]+") || dadosProduto[3].matches("^$|^\\s*$")
					|| dadosProduto[4].matches("^$|^\\s*$") || dadosProduto[5].matches("^$|^\\s*$")) {
				return false;
			} else {
				produto = new Alimento(dadosProduto[0], Integer.parseInt(dadosProduto[1]),
						Float.parseFloat(dadosProduto[2]), dadosProduto[3], dadosProduto[4], dadosProduto[5]);
			}
			break;
		case 2:
			if (dadosProduto[0].matches("^$|^\\s*$") || !dadosProduto[1].matches("[0-9]+")
					|| !dadosProduto[2].matches("[0-9]+") || dadosProduto[3].matches("^$|^\\s*$")
					|| !dadosProduto[4].matches("[0-9]+") || dadosProduto[5].matches("^$|^\\s*$")) {
				return false;
			} else {
				produto = new Bebida(dadosProduto[0], Integer.parseInt(dadosProduto[1]),
						Float.parseFloat(dadosProduto[2]), dadosProduto[3], Integer.parseInt(dadosProduto[4]),
						dadosProduto[5]);
				}
				break;
		default:
			return false;
		}

		Filial filial = empresa.getFiliais().get(posF);

		for (int i = 0; i < filial.getProdutodeEstoque().size(); i++) {
			if (i == posP) {
				filial.getProdutodeEstoque().set(posP, produto);
				return true;
			}
		}

		filial.setProdutodeEstoque(produto);
		return true;

	}
  
  /**
   * CRUD
   * Metodo criado para deletar um produto cadastrado em uma filial e o remove.
   * @param a, representa o indice do produto
   * @param b, representa o indice da filial
    */

  public void deletarProduto(int a, int b) {
    empresa.getFiliais().get(b).getProdutodeEstoque().remove(a);
  }
  
  /**
   * Metodo que verifica se o objeto e uma instancia da classe Alimento ou da classe Bebida e 
   * retorna um valor inteiro correspondente: 1 para Alimento e 2 para Bebida.
   * @param posF, indica a posicao da filial
   * @param posP, indica a posicao do produto
   * @return int
   * */

  public int verificarCadastro(int posF, int posP) {
    Produto produto = empresa.getFiliais().get(posF).getProdutodeEstoque().get(posP);

    int op = 0;
    if (produto instanceof Alimento)
      op = 1;
    else if (produto instanceof Bebida)
      op = 2;

    return op;

  }

}
