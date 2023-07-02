package visao;

import javax.swing.*;

import controle.*;

import java.awt.event.*;

/**
 * Implementa uma interface para mostrar os detalhes de cada filial e produto cadastrados e
 * permitir a edicao desses dados, alem de poder mostrar a interface de cadastro
 * de um novo produto e de uma nova filial
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaDetalhe implements ActionListener {

	private JFrame janela;
	private JPanel painelDetalhe = new JPanel();

	private JButton bebida = new JButton("Bebida");
	private JButton alimento = new JButton("Alimento");
	private JButton produto = new JButton("estoque");

	private JLabel nomeItem = new JLabel("Nome: ");
	private JTextField nome;
	private JLabel numTel = new JLabel("Número do Telefone: ");
	private JTextField num;
	private JLabel endereco = new JLabel("Endereço: ");
	private JTextField end;
	private JLabel cnpj = new JLabel("CNPJ: ");
	private JTextField textoCnpj;
	private JLabel tipo = new JLabel("Tipo: ");
	private JTextField textoTipo;

	private JLabel quantidade = new JLabel("Quantidade: ");
	private JTextField qtd = new JTextField();
	private JLabel preco = new JLabel("Preço: ");
	private JTextField prc = new JTextField();
	private JLabel datavalidade = new JLabel("Data de Validade: ");
	private JTextField date = new JTextField();
	private JButton excluir = new JButton("excluir");
	private JButton salvar = new JButton("salvar");

	private JLabel marca = new JLabel("Marca da Bebida: ");
	private JTextField marcaBebida = new JTextField();
	private JLabel valorCalorico = new JLabel("Valor calórico: ");
	private JTextField valor = new JTextField();

	private JLabel categoria = new JLabel("Categoria: ");
	private JTextField ctg = new JTextField();
	private JLabel tipoAlimento = new JLabel("Tipo: ");
	private JTextField tipoA = new JTextField();
	private ControleEmpresa empresa;
	int tela;
	private int fTeste, pTeste, op;
	
	
	/**
	 * Cadastra novas filiais e mostra detalhes das ja existentes, permitindo a
	 * edicao desses dados
	 * @param t,define se cadastra ou edita uma filial
	 * @param pos, define a posicao da filial
	 * @param e, importa as informacoes da classe ControleEmpresa
	 */

	public void inserirEditar(int pos, ControleEmpresa e, boolean t) {
		//Cadastro de Filial
		tela = 1;
		empresa = e;
		fTeste = pos;

		if (t == true) {
			nome = new JTextField();
			num = new JTextField();
			end = new JTextField();
			textoCnpj = new JTextField();
			textoTipo = new JTextField();
			
			produto.setVisible(false);

		}

		else {
			nome = new JTextField(empresa.getDados().getFiliais().get(pos).getNome());
			num = new JTextField(String.valueOf(empresa.getDados().getFiliais().get(pos).getNumTel()));
			end = new JTextField(empresa.getDados().getFiliais().get(pos).getEndereco());
			textoCnpj = new JTextField(String.valueOf(empresa.getDados().getFiliais().get(pos).getCNPJ()));
			textoTipo = new JTextField(empresa.getDados().getFiliais().get(pos).getTipo());
		}

		janela = new JFrame("Cadastro Filial");
		janela.setSize(500, 350);
		janela.setLocationRelativeTo(null);

		nomeItem.setBounds(40, 60, 60, 20);
		nome.setBounds(200, 60, 130, 20);

		numTel.setBounds(40, 80, 140, 20);
		num.setBounds(200, 80, 130, 20);

		endereco.setBounds(40, 100, 60, 20);
		end.setBounds(200, 100, 130, 20);

		cnpj.setBounds(40, 120, 110, 20);
		textoCnpj.setBounds(200, 120, 130, 20);

		tipo.setBounds(40, 140, 60, 20);
		textoTipo.setBounds(200, 140, 130, 20);

		produto.setBounds(170, 220, 150, 30);

		janela.add(nomeItem);
		janela.add(numTel);
		janela.add(endereco);
		janela.add(cnpj);
		janela.add(tipo);
		janela.add(nome);
		janela.add(num);
		janela.add(end);
		janela.add(textoCnpj);
		janela.add(textoTipo);
		janela.add(produto);

		produto.addActionListener(this);

		janela.setLayout(null);
		painelDetalhe.setLayout(null);

		excluir.setBounds(20, 220, 100, 30);
		salvar.setBounds(360, 220, 100, 30);

		janela.add(salvar);
		janela.add(excluir);

		janela.add(painelDetalhe);
		janela.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);

	}
	/**
	 * Cadastra novos produtos das filiais e mostra detalhes dos ja existentes, permitindo a
	 * edicao desses dados
	 * @param t,define se cadastra ou edita um produto
	 * @param posf, define a posicao da filial
	 * @param pos, define a posicao do produto
	 * @param c, importa as informacoes da classe ControleEmpresa
	 */

	public void inserirEditar(int posf, int pos, ControleEmpresa c, int op, boolean t) {
		tela = 2;
		empresa = c;
		this.op = op;
		fTeste = posf;
		pTeste = pos;

		janela = new JFrame("Cadastro Produtos");
		janela.setSize(500, 300);
		janela.setLocationRelativeTo(null);

		if (t == true) {
			nome = new JTextField();
			qtd = new JTextField();
			prc = new JTextField();
			date = new JTextField();

			if (op == 1) {
				//Alimento
				ctg = new JTextField();
				textoTipo = new JTextField();
				CadastrarProduto("Alimento");
			}

			else if (op == 2) {
				//Bebida
				marcaBebida = new JTextField();
				valor = new JTextField();
				CadastrarProduto("Bebida");

			}
		}

		else if (t == false) {
			nome = new JTextField(empresa.getFilial(fTeste).getProdutodeEstoque().get(pos).getNome());
			qtd = new JTextField(String.valueOf(empresa.getFilial(fTeste).getProdutodeEstoque().get(pos).getQuantidade()));
			prc = new JTextField(String.valueOf(empresa.getFilial(fTeste).getProdutodeEstoque().get(pos).getPreco()));
			date = new JTextField(empresa.getFilial(fTeste).getProdutodeEstoque().get(pos).getData());

			// Alimento
			if (op == 1) {
				tipoA = new JTextField(empresa.getControleFiliais().converterAlimento(fTeste, pos).getTipo());
				ctg = new JTextField(empresa.getControleFiliais().converterAlimento(fTeste, pos).getCategoria());
				CadastrarProduto("Alimento");
			}
			//Bebida

			if (op == 2) {
				marcaBebida = new JTextField(empresa.getControleFiliais().converterBebida(fTeste, pos).getMarca());
				valor = new JTextField(String.valueOf(empresa.getControleFiliais().converterBebida(fTeste, pos).getVCal()));
				CadastrarProduto("Bebida");
			}

		}

		alimento.setBounds(20, 15, 100, 30);
		bebida.setBounds(360, 15, 100, 30);

		janela.add(alimento);
		janela.add(bebida);

		alimento.addActionListener(this);
		bebida.addActionListener(this);

		// configuracoes basicas para ambas as telas
		janela.setLayout(null);
		painelDetalhe.setLayout(null);

		excluir.setBounds(20, 220, 100, 30);
		salvar.setBounds(360, 220, 100, 30);

		janela.add(salvar);
		janela.add(excluir);

		janela.add(painelDetalhe);
		janela.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);
	}
	

	/**
	 * Cadastra novos produtos das filiais dependendo do tipo escolhido.
	 * @param filha, define se vai cadastrar Produto ou Alimento
	 **/

	public void CadastrarProduto(String filha) {
		painelDetalhe.setSize(500, 350);
		painelDetalhe.removeAll();
		painelDetalhe.setSize(500, 400);

		nomeItem.setBounds(40, 60, 100, 20);
		nome.setBounds(150, 60, 130, 20);

		if (filha.equals("Alimento")) {

			quantidade.setBounds(40, 80, 100, 20);
			qtd.setBounds(150, 80, 130, 20);

			preco.setBounds(40, 100, 60, 20);
			prc.setBounds(150, 100, 130, 20);

			categoria.setBounds(40, 120, 80, 20);
			ctg.setBounds(150, 120, 130, 20);

			tipoAlimento.setBounds(40, 140, 60, 20);
			tipoA.setBounds(150, 140, 130, 20);

			datavalidade.setBounds(40, 160, 110, 20);
			date.setBounds(150, 160, 130, 20);

			excluir.setBounds(20, 220, 100, 30);
			salvar.setBounds(360, 220, 100, 30);

			painelDetalhe.add(quantidade);
			painelDetalhe.add(preco);
			painelDetalhe.add(datavalidade);
			painelDetalhe.add(qtd);
			painelDetalhe.add(prc);
			painelDetalhe.add(date);
			painelDetalhe.add(categoria);
			painelDetalhe.add(ctg);
			painelDetalhe.add(tipoAlimento);
			painelDetalhe.add(tipoA);
			painelDetalhe.add(excluir);
			painelDetalhe.add(salvar);
		}

		if (filha.equals("Bebida")) {

			quantidade.setBounds(40, 80, 100, 20);
			qtd.setBounds(150, 80, 130, 20);

			preco.setBounds(40, 100, 60, 20);
			prc.setBounds(150, 100, 130, 20);

			marca.setBounds(40, 120, 110, 20);
			marcaBebida.setBounds(150, 120, 130, 20);

			valorCalorico.setBounds(40, 140, 100, 20);
			valor.setBounds(150, 140, 130, 20);

			datavalidade.setBounds(40, 160, 110, 20);
			date.setBounds(150, 160, 130, 20);

			excluir.setBounds(20, 220, 100, 30);
			salvar.setBounds(360, 220, 100, 30);

			painelDetalhe.add(quantidade);
			painelDetalhe.add(preco);
			painelDetalhe.add(datavalidade);
			painelDetalhe.add(qtd);
			painelDetalhe.add(prc);
			painelDetalhe.add(date);
			painelDetalhe.add(marca);
			painelDetalhe.add(marcaBebida);
			painelDetalhe.add(valorCalorico);
			painelDetalhe.add(valor);
			painelDetalhe.add(excluir);
			painelDetalhe.add(salvar);
		}

		painelDetalhe.add(nomeItem);
		painelDetalhe.add(nome);

		//funcoes de refresh painel
		janela.revalidate();
		janela.repaint();
	}
	
	/**
	 * Captura eventos relacionados aos botões da interface e realizando as funcoes de cadastro
	 * e de remover
	 * @param e, representa a escuta do evento
	 **/

	public void actionPerformed(ActionEvent e) {
		boolean certo = true;
		if (e.getSource() == salvar) {
			if (tela == 1) {
				String[] filial = new String[5];

				filial[0] = nome.getText();
				filial[1] = num.getText();
				filial[2] = end.getText();
				filial[3] = textoCnpj.getText();
				filial[4] = textoTipo.getText();

				certo = empresa.cadastroFilial(filial, fTeste);
			}

			else if (tela == 2) {
				String[] produtos = new String[7];

				produtos[0] = nome.getText();
				produtos[1] = qtd.getText();
				produtos[2] = prc.getText();
				produtos[5] = date.getText();

				if (op == 1) {
					//Alimento
					produtos[3] = tipoA.getText();
					produtos[4] = ctg.getText();
					certo = empresa.getControleFiliais().cadastroProduto(produtos, fTeste, pTeste, 1);
				}

				else if (op == 2) {
					//Bebida
					produtos[3] = marcaBebida.getText();
					produtos[4] = valor.getText();
					certo = empresa.getControleFiliais().cadastroProduto(produtos, fTeste, pTeste, 2);

				}

			}

			if (certo == true) {
				certoCadastro();
			} else {
				erroCadastro();
			}
			salvar.removeActionListener(this);

		}

		else if (e.getSource() == excluir) {
			if (tela == 1) {
				empresa.deletarFilial(fTeste);
			} else if (tela == 2) {
				empresa.getControleFiliais().deletarProduto(pTeste, fTeste);
			}
			certoExclusao();

		}

		else if (e.getSource() == produto) {
			new TelaProduto(empresa, fTeste);
		}

		else if (e.getSource() == alimento) {
			janela.dispose();
			inserirEditar(fTeste, pTeste, empresa, 1, true);
		}

		else if (e.getSource() == bebida) {
			janela.dispose();
			inserirEditar(fTeste, pTeste, empresa, 2, true);
		}

	}
	
	/**
	 * Metodo que retorna uma mensagem de sucesso ao cadastrar filial ou produto
	 * */

	public void certoCadastro() {
		if (tela == 1)
			JOptionPane.showMessageDialog(null, "Filial Cadastrada", null, JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Produto Cadastrado", null, JOptionPane.INFORMATION_MESSAGE);

		janela.dispose();
	}
	
	/**
	 * Metodo que retorna uma mensagem de falha ao cadastrar filial ou produto
	 * */

	public void erroCadastro() {
		if (tela == 1)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar filial", null, JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto", null, JOptionPane.ERROR_MESSAGE);

		janela.dispose();
	}
	
	/**
	 * Metodo que retorna uma mensagem de sucesso ao excluir filial ou produto
	 * */

	public void certoExclusao() {
		if (tela == 1)
			JOptionPane.showMessageDialog(null, "Filial Removida", null, JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Produto Removido", null, JOptionPane.ERROR_MESSAGE);

		janela.dispose();
	}
}
