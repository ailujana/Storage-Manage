package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleEmpresa;

/**
 * Implementa uma interface que mostra a lista dos Produtos das Filiais da Empresa
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaProduto implements ActionListener, ListSelectionListener {

  private JFrame janela = new JFrame("Controle dos Produtos");
  private JLabel titulo = new JLabel("Produtos de Estoque");
  private JButton atualizar = new JButton("Atualizar");
  private JButton cadastrarProduto = new JButton("Cadastrar Produto");
  private JList<String> produtosCadastrados;
  private ControleEmpresa dados;
  private int filialSelecionada;
  
  /**
	 * Cria a tela de produtos do sistema
	 * Permite o usuario de editar, cadastrar e remover produtos das filiais
	 * @param dados, importa as informacoes da classe ControleEmpresa
	 * @param i, indica o index da filial selecionada
	 */

  public TelaProduto(ControleEmpresa dados, int i) {
    filialSelecionada = i;
    this.dados = dados;
    produtosCadastrados = new JList<String>(dados.getFilial(filialSelecionada).getNomesProdutos());

    titulo.setFont(new Font("Arial", Font.BOLD, 16));
    titulo.setBounds(190, 10, 170, 30);
    atualizar.setBounds(310, 250, 150, 30);
    cadastrarProduto.setBounds(30, 250, 150, 30);
    produtosCadastrados.setBounds(60, 80, 400, 150);

    janela.setSize(500, 350);
    janela.setLocationRelativeTo(null);

    janela.setLayout(null);

    janela.add(titulo);
    janela.add(atualizar);
    janela.add(cadastrarProduto);
    janela.add(produtosCadastrados);
    janela.setVisible(true);

    atualizar.addActionListener(this);
    cadastrarProduto.addActionListener(this);

    produtosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    produtosCadastrados.setVisibleRowCount(10);
    produtosCadastrados.addListSelectionListener(this);

  }
  
  /**
	 * Captura eventos relacionados aos botoes da interface
	 * @param e, refere a "escuta" do evento
	 */

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == atualizar) {
    	produtosCadastrados.setListData(dados.getFilial(filialSelecionada).getNomesProdutos());
    	produtosCadastrados.updateUI();

    } else if (e.getSource() == cadastrarProduto) {
      new TelaDetalhe().inserirEditar(filialSelecionada,
          dados.getFilial(filialSelecionada).getProdutodeEstoque().size(), dados, 1, true);
    }

  }
  /**
	 * Captura eventos relacionados a JList de produtos
	 * @param event, relacionados aos eventos
	 */

  public void valueChanged(ListSelectionEvent event) {
    if (event.getValueIsAdjusting() && event.getSource() == produtosCadastrados) {
      int op = dados.getControleFiliais().verificarCadastro(filialSelecionada, produtosCadastrados.getSelectedIndex());
      new TelaDetalhe().inserirEditar(filialSelecionada, produtosCadastrados.getSelectedIndex(), dados, op, false);
    }
  }

}
