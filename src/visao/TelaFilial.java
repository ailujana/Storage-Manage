package visao;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;



/**
 * Implementa uma interface que mostra a lista de Filiais da Empresa
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaFilial implements ActionListener, ListSelectionListener {

  private JFrame janela = new JFrame("Controle dos Produtos");
  private JLabel titulo = new JLabel("Filial");
  private JButton cadastrar = new JButton("Cadastrar filial");
  private JButton atualizar = new JButton("Atualizar");
  private JList<String> filiaisCadastradas;
  private ControleEmpresa d;
  
  /**
 	 * Cria a tela de filiais do sistema
 	 * Permite o usuario de editar, cadastrar e remover filiais
 	 * @param d, refere se aos dados da classe ControleEmpresa
 	 */
  
  public TelaFilial(ControleEmpresa d) {
    this.d = d;
    filiaisCadastradas = new JList<String>(d.getDados().getNomesFiliais());

    titulo.setFont(new Font("Arial", Font.BOLD, 16));
    titulo.setBounds(215, 10, 170, 30);

    cadastrar.setBounds(30, 250, 150, 30);
    atualizar.setBounds(310, 250, 150, 30);
    filiaisCadastradas.setBounds(60, 80, 400, 120);

    janela.setSize(500, 350);
    janela.setLocationRelativeTo(null);

    janela.setLayout(null);

    janela.add(titulo);
    janela.add(cadastrar);
    janela.add(atualizar);
    janela.add(filiaisCadastradas);

    janela.setVisible(true);

    filiaisCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    filiaisCadastradas.setVisibleRowCount(10);
    filiaisCadastradas.addListSelectionListener(this);

    cadastrar.addActionListener(this);
    atualizar.addActionListener(this);

  }
  /**
	 * Captura eventos relacionados aos botoes da interface
	 * @param e, refere se a "escuta" do evento
	 **/

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == cadastrar) {
      new TelaDetalhe().inserirEditar(d.getDados().getFiliais().size(), d, true);
    }

    if (e.getSource() == atualizar) {
    	filiaisCadastradas.setListData(d.getDados().getNomesFiliais());
    	filiaisCadastradas.updateUI();
    }

  }
  /**
	 * Captura eventos relacionados ao JList
	 * @param event, refere se ao evento
	 **/

  public void valueChanged(ListSelectionEvent event) {
    if (event.getValueIsAdjusting() && event.getSource() == filiaisCadastradas) {
      new TelaDetalhe().inserirEditar(filiaisCadastradas.getSelectedIndex(), d, false);
    }
  }

}
