package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controle.*;

/**
 * Implementa uma interface que mostra todos os produtos cadastrados na Empresa
 * 
 * @author Ana Julia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaListagemCompleta implements ActionListener {
	private JFrame janelaLista = new JFrame("Produtos da Empresa Tudo da Roça");
	private JLabel textoLista = new JLabel("Todos os produtos");
	private JButton atualizar = new JButton("Atualizar");
	private JList<String> produtos;
	private ControleEmpresa dadosEmpresa;
	private JScrollPane scroll;
	
	/**
	 * Cria a tela de listagem completa dos Produtos
	 * Parametros dos construtores:
	 * @param dadosEmpresa, representa os dados vindo da classe ControleEmpresa
	 **/

	public TelaListagemCompleta(ControleEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	    textoLista.setFont(new Font("Arial", Font.BOLD, 16));
		produtos = new JList<String>(dadosEmpresa.getDados().listarTodosProdutos());
		scroll = new JScrollPane(produtos);

		janelaLista.setLayout(null);
		janelaLista.setSize(500, 350);
		atualizar.setBounds(280, 210, 100, 30);
		textoLista.setBounds(170, 10, 200, 40);
		scroll.setBounds(90, 45, 300, 150);
		produtos.setBounds(40, 50, 160, 150);

		produtos.setVisibleRowCount(10);
		produtos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		janelaLista.setLocationRelativeTo(null);

		janelaLista.add(textoLista);
		janelaLista.add(atualizar);
		janelaLista.setVisible(true);
		janelaLista.add(scroll);

		atualizar.addActionListener(this);
		

	}
	
	/**
	 * Captura eventos relacionados ao JList
	 * @param e, representa a escuta do evento
	 **/

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == atualizar) {
			produtos.setListData(dadosEmpresa.getDados().listarTodosProdutos());
			produtos.updateUI();
		}
	}

}
