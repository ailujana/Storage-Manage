package testesJUnit;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import controle.*;

/**
 * Implementa testes unitarios de validacao
 * @author Ana Júlia Mendes, Caua Araujo
 * @since 2023
 * @version 1.0 
 */

class testesJUnit {
	ControleEmpresa empresa = new ControleEmpresa();
	ControleFilial filiais = new ControleFilial(empresa.getDados());
	
	/**
	 * Verifica se o metodo em questao esta funcionando corretamente, 
	 * dado os parametros
	 * @return void
	 */

	@Test
	void testeCadastroFilial() {
		String[] dados = new String[5];
		int posicao = 4;
		
		dados[0] = "FilialX";
		dados[1] = "12345678";
		dados[2] = "Rua 0, número 0, bairro 0";
		dados[3] = "123321324-123";
		dados[4] = "Produtos de Limpeza";
		
		assertTrue(empresa.cadastroFilial(dados, posicao));	
	}
	
	/**
	 * Verifica se o parametro 3,representa a posicao da filial no array,
	 * funciona para o metodo em questao
	 * @return void
	 */
	
	@Test
	void testeDeletarFilial() {
		int a = 3;
		assertTrue(empresa.deletarFilial(a));
	}
	
	/**
	 * Verifica se o posicoes representa o item "Alimento8" no metodo buscarProduto
	 * @return void
	 */
	
	@Test
	void testeEncontrarProduto() {
		int[] posicoes = {1,2,1};
		assertArrayEquals(posicoes, empresa.buscarProduto("Alimento8"));
	}
	
	
	
	
	

}
