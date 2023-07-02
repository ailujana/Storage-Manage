package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.*;

/**
 * Implementa uma interface que mostra a tela de busca
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaBusca implements ActionListener {
  private JFrame janelaBusca = new JFrame("Busca de produto");
  private JTextField buscar = new JTextField();
  private JLabel textoBusca = new JLabel("Digite o nome do produto que deseja buscar");
  private JButton botaoBusca = new JButton("Buscar");
  private ControleEmpresa empresa;
  
  
  /**
	 * Cria a tela de busca do sistema
	 * Permite o usuario de buscar o nome dos Produtos da Empresa
	 */
  
  public void mostrarTela(ControleEmpresa e) {
    empresa = e;
    textoBusca.setBounds(30, 15, 300, 50);
    buscar.setBounds(165, 75, 90, 25);
    botaoBusca.setBounds(310, 115, 90, 30);

    janelaBusca.setSize(430, 200);
    janelaBusca.setLayout(null);
    janelaBusca.setVisible(true);
    janelaBusca.setLocationRelativeTo(null);
    botaoBusca.addActionListener(this);

    janelaBusca.add(textoBusca);
    janelaBusca.add(botaoBusca);
    janelaBusca.add(buscar);

  }
  /**
	 * Captura eventos relacionados aos botoes da interface
	 * @param e, representa a escuta do evento
	 **/

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == botaoBusca) {
    	   String nomeProduto = buscar.getText();
    	   int[] posicoes = empresa.buscarProduto(nomeProduto);
    	   
    	   if(posicoes[0] > -1) {
        	   new TelaDetalhe().inserirEditar(posicoes[0], posicoes[1], empresa, posicoes[2], false);
         }
    	   else {
    		   Errobusca();
    	   }
    		
    	
    }

  }
  /**
   * Metodo que mostra mensagem de erro na busca de produtos
   * */
  public void Errobusca() {
    JOptionPane.showMessageDialog(null, "Produto não cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
    janelaBusca.dispose();
  }
}
