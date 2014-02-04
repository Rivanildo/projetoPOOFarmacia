package br.com.ufpb.ProjetoPOO.Farmacia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class FarmaciaTest {
	Farmacia farmacia;
	private static final String MSG_FAIL = "Deveria ter lancado a excecao" ;
	
	@Before
	public void iniciar(){
		this.farmacia = new Farmacia();
	}
	
	@Test
	public void verificaSeAFarmaciaFoiCriada(){
		assertNotNull(this.farmacia);
	}
	@Test
	public void verificaSeEstaVazia(){
		assertEquals(0, this.farmacia.getQtdeProdutosCadastrados());
	}
	
	@Test
	public void cadastraUmProduto() {
		farmacia.cadastraProduto(999,2.00);
		assertEquals(1,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void cadastraDoisProdutos() {
		farmacia.cadastraProduto(123,3.30);
		farmacia.cadastraProduto(321,1.00);
		assertEquals(2,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void verificaSeUmProdutoFoiCadastrato() {
		farmacia.cadastraProduto(1234,0.99);
		assertTrue(farmacia.isCadastrado(1234));
	}
	
	@Test (expected=ProdutoJaExistenteException.class)
	public void cadastrarUmProdutoQueJaExiste() {
		farmacia.cadastraProduto(111,2.00);
		farmacia.cadastraProduto(111,2.00);
		fail(MSG_FAIL);
	}
	
	@Test
	public void verificaSeUmProdutoFoiRemovidoTest() {
		farmacia.cadastraProduto(123,2.00);
		farmacia.removerProduto(123);
		assertFalse(farmacia.isCadastrado(123));
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void removerProdutoInexistenteTest() {
		farmacia.cadastraProduto(567,2.00);
		farmacia.removerProduto(999);
		fail(MSG_FAIL);
	}
	
	@Test
	public void cadastraProdutoComPrecoValido() {
		farmacia.cadastraProduto(332,2.00);
		assertTrue(farmacia.isCadastrado(332));
		
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoNegativo(){
		farmacia.cadastraProduto(55, -4);
		fail(MSG_FAIL);
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoIgualAZero(){
		farmacia.cadastraProduto(51, 0);
		fail(MSG_FAIL);
	}
	
}
