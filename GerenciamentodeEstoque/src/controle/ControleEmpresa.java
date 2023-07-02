package controle;

import modelo.*;


/**
 * Classe ControleEmpresa do pacote controle. Manipula os dados da Model para utilizar nas telas do pacote View. 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 * */

public class ControleEmpresa {
  private Empresa dados;
  private ControleFilial filiais;
  
  /**
   * Construtor da classe ControleEmpresa
   * */

  public ControleEmpresa() {
    dados = new Empresa();
    filiais = new ControleFilial(dados);
    dados.fillWithSomeData();
    fillFiliaisWithSomeData();
  }

  
  /**
   * CRUD
   * Cadastra uma filial e percorre todas as filiais ja cadastradas no sistema, verificando se
   * a posicao pos passada como parametro e igual ao indice atual do loop.
   * Caso seja, a filial e atualizada na posicao pos do vetor de 
   * filiais e o metodo retorna true.
   * E depois a filial cadastrada e inserida dentro do ArrayList de Filiais da Classe Empresa.
   * @param dadosFilial[]
   * @param pos
   * @return boolean
   * */
  
  public boolean cadastroFilial(String dadosFilial[], int pos) {
	  if(dadosFilial[0].matches("^$|^\\s*$") || !dadosFilial[1].matches("[0-9]+") || dadosFilial[2].matches("^$|^\\s*$") 
			  || dadosFilial[3].matches("^$|^\\s*$") || dadosFilial[4].matches("^$|^\\s*$") ) {
		  return false;
	  }
    Filial filial = new Filial(dadosFilial[0], Integer.parseInt((dadosFilial[1])), dadosFilial[2],
        (dadosFilial[3]), dadosFilial[4]);

    for (int i = 0; i < dados.getFiliais().size(); i++) {
      if (i == pos) {
        dados.getFiliais().set(pos, filial);
        return true;
      }
    }

    dados.setFiliais(filial);
    return true;

  }
  
  /**
   * CRUD, Metodo criado para deletar uma filial cadastrada 
   * que recebe o indice da filial e a remove.
   * @param a, indica o indice da filial a ser removida 
   * @return boolean
   **/

  public boolean deletarFilial(int a) {
    dados.getFiliais().remove(a);
    return true;
  }

  public Empresa getDados() {
    return dados;
  }

  public void setDados(Empresa dados) {
    this.dados = dados;
  }

  public Filial getFilial(int i) {
    return dados.getFiliais().get(i);
  }

  public ControleFilial getControleFiliais() {
    return filiais;
  }
  
  /**
   * CRUD
   * @param nomeProduto
   * @return int[]
   * O metodo comeca criando um array de inteiros posicoes com tres posicoes. 
   * Em seguida, ele percorre todas as filiais cadastradas no sistema e, para cada filial, 
   * percorre a lista de produtos em estoque. Se o nome do produto for igual ao nome passado como parametro, 
   * o metodo preenche as posicoes do array posicoes com a posicao da filial
   * e a posicao do produto na lista de produtos da filial. 
   * Alem disso, ele verifica se o produto e uma instancia da classe Alimento
   * ou da classe Bebida e preenche a terceira posicao do array posicoes com o valor 1 ou 2,
   * respectivamente. Por fim, o metodo retorna o array posicoes.
   * 
   * */
  
  public int[] buscarProduto(String nomeProduto) {
		int[] posicoes = new int[3];
		posicoes[0] = -1;
		
		for (Filial filial : dados.getFiliais()) {
			for (Produto produto : filial.getProdutodeEstoque()) {
				if (produto.getNome().equals(nomeProduto)) {
					posicoes[0] = dados.getFiliais().indexOf(filial);
					posicoes[1] = filial.getProdutodeEstoque().indexOf(produto);

					if (produto instanceof Alimento) {
						posicoes[2] = 1;
					}
					if (produto instanceof Bebida) {
						posicoes[2] = 2;
					}
					return posicoes;

				}
			}
		}
		return posicoes;
	}
  
  
  
  /**
	 * Metodo criado para preencher os dados pre cadastrados para colocar na Jlist da Tela Produto
	 * do pacote View.
	 * Nesse metodo especifico foi preciso converter as classes Alimento e Bebida na sua classe pai.
	 * Foi criada uma instancia da classe Produto e foram colocados exemplos de atributos.
	 * O Produto "teste" foi inserido no ArrayList de Produtos.
	 * */ 
	public void fillFiliaisWithSomeData() {
		int i = 0;
		for (Filial filial : dados.getFiliais()) {
			for (int l = 0; l < 6; l++) {
				Produto teste;
				String nome;

				if (l < 3) {
					teste = new Alimento();
					nome = "Alimento" + (l + i);
					((Alimento) teste).setCategoria("Enlatados");
					((Alimento) teste).setTipo("de Feijão");

				} else {
					teste = new Bebida();
					nome = "Bebida" + (l + i);
					((Bebida) teste).setMarca("Coca");
					((Bebida) teste).setVCal(123 + (l + i));

				}

				int quantidade = 5 + (l + i);
				float preco = 8 + (l + i);
				String data = "12/12/12";

				teste.setNome(nome);
				teste.setQuantidade(quantidade);
				teste.setPreco(preco);
				teste.setData(data);

				filial.setProdutodeEstoque(teste);

			}
			i += 6;
		}
	}
  
  
}
