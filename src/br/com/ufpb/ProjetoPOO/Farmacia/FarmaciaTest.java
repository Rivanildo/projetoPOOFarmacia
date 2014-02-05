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
		farmacia.cadastraProduto("aaa",999,2.00);
		assertEquals(1,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void cadastraDoisProdutos() {
		farmacia.cadastraProduto("bbb",123,3.30);
		farmacia.cadastraProduto("ccc",321,1.00);
		assertEquals(2,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void verificaSeUmProdutoFoiCadastrato() {
		farmacia.cadastraProduto("ddd",1234,0.99);
		assertTrue(farmacia.isCadastrado(1234));
	}
	
	@Test (expected=ProdutoJaExistenteException.class)
	public void cadastrarUmProdutoQueJaExiste() {
		farmacia.cadastraProduto("eee",111,2.00);
		farmacia.cadastraProduto("eee",111,2.00);
		fail(MSG_FAIL);
	}
	
	@Test
	public void verificaSeUmProdutoFoiRemovidoTest() {
		farmacia.cadastraProduto("abc",555,2.00);
		farmacia.removerProdutoPeloCodigo(555);
		assertFalse(farmacia.isCadastrado(555));
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void removerProdutoInexistenteTest() {
		farmacia.cadastraProduto("abb",567,2.00);
		farmacia.removerProdutoPeloCodigo(999);
		fail(MSG_FAIL);
	}
	
	@Test
	public void cadastraProdutoComPrecoValido() {
		farmacia.cadastraProduto("fff",332,2.00);
		assertTrue(farmacia.isCadastrado(332));
		
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoNegativo(){
		farmacia.cadastraProduto("scs",55, -4);
		fail(MSG_FAIL);
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoIgualAZero(){
		farmacia.cadastraProduto("aaa",51, 0);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoJaExistenteException.class)
	public void cadastrarProdutoComNomeJaExistente(){
		farmacia.cadastraProduto("aaa", 123, 2.50);
		farmacia.cadastraProduto("aaa", 444, 3.20);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoSemNomeException.class)
	public void cadastrarProdutoSemNomeTest() {
		farmacia.cadastraProduto("", 123, 2.30);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoSemNomeException.class)
	public void cadastrarProdutoSemNomeTest2() {
		farmacia.cadastraProduto(null, 123, 2.30);
		fail(MSG_FAIL);
	}
	
}
