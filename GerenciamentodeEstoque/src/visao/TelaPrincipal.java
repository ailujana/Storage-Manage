package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controle.*;

/**
 * Implementa uma interface que mostra o menu principal
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaPrincipal implements ActionListener {

  private static JFrame janela = new JFrame("Controle da Empresa");
  private static JLabel titulo = new JLabel("Frutaria Tudo da Roça");
  private static JButton cadastro = new JButton("Filiais");
  private static JButton busca = new JButton("Busca de Produtos");
  private static JButton listagem = new JButton("Listagem de Produtos");
  private static ControleEmpresa dadosEmpresa = new ControleEmpresa();
  
  /**
	 * Cria a tela do menu do sistema
	 */

  public TelaPrincipal() {
    titulo.setFont(new Font("Arial", Font.BOLD, 16));
    titulo.setBounds(155, 10, 190, 30);
    cadastro.setBounds(150, 85, 170, 40);
    busca.setBounds(150, 140, 170, 40);
    listagem.setBounds(150, 200, 170, 40);

    janela.setSize(500, 350);
    janela.setLocationRelativeTo(null);

    janela.setLayout(null);

    janela.add(titulo);
    janela.add(cadastro);
    janela.add(busca);
    janela.add(listagem);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setVisible(true);

  }
  /**
	 * Instacia os ActioListener para os botoes do menu
	 * @param args
	 */

  public static void main(String[] args) {
    TelaPrincipal menu = new TelaPrincipal();

    cadastro.addActionListener(menu);
    busca.addActionListener(menu);
    listagem.addActionListener(menu);
  }
  
  /**
	 * Captura eventos relacionados aos botoes da interface
	 * @param e, refere aos eventos da tela
	 **/

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == cadastro) {
      new TelaFilial(dadosEmpresa);
    }

    else if (e.getSource() == busca) {
      new TelaBusca().mostrarTela(dadosEmpresa);
    }

    else if (e.getSource() == listagem) {
      new TelaListagemCompleta(dadosEmpresa);
    }
  }

}