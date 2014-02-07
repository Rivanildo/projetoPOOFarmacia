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
		farmacia.cadastraProduto("aaa",999,2.00, 2);
		assertEquals(1,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void cadastraDoisProdutos() {
		farmacia.cadastraProduto("bbb",123,3.30, 2);
		farmacia.cadastraProduto("ccc",321,1.00, 2);
		assertEquals(2,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void verificaSeUmProdutoFoiCadastrato() {
		farmacia.cadastraProduto("ddd",1234,0.99, 2);
		assertTrue(farmacia.isCadastrado(1234));
	}
	
	@Test (expected=ProdutoJaExistenteException.class)
	public void cadastrarUmProdutoQueJaExiste() {
		farmacia.cadastraProduto("eee",111,2.00, 2);
		farmacia.cadastraProduto("eee",111,2.00, 2);
		fail(MSG_FAIL);
	}
	
	@Test
	public void verificaSeUmProdutoFoiRemovidoTest() {
		farmacia.cadastraProduto("abc",555,2.00, 2);
		farmacia.removerProdutoPeloCodigo(555);
		assertFalse(farmacia.isCadastrado(555));
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void removerProdutoInexistenteTest() {
		farmacia.cadastraProduto("abb",567,2.00, 2);
		farmacia.removerProdutoPeloCodigo(999);
		fail(MSG_FAIL);
	}
	
	@Test
	public void cadastraProdutoComPrecoValido() {
		farmacia.cadastraProduto("fff",332,2.00, 2);
		assertTrue(farmacia.isCadastrado(332));
		
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoNegativo(){
		farmacia.cadastraProduto("scs",55, -4, 2);
		fail(MSG_FAIL);
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoIgualAZero(){
		farmacia.cadastraProduto("aaa",51, 0, 2);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoJaExistenteException.class)
	public void cadastrarProdutoComNomeJaExistente(){
		farmacia.cadastraProduto("aaa", 123, 2.50, 2);
		farmacia.cadastraProduto("aaa", 444, 3.20, 2);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoSemNomeException.class)
	public void cadastrarProdutoSemNomeTest() {
		farmacia.cadastraProduto("", 123, 2.30, 2);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoSemNomeException.class)
	public void cadastrarProdutoSemNomeTest2() {
		farmacia.cadastraProduto(null, 123, 2.30, 2);
		fail(MSG_FAIL);
	}
	@Test
	public void pesquisarProdutoPeloNomeTest(){
		farmacia.cadastraProduto("Dipirona", 1234, 5.00, 2);
		assertEquals("Dipirona", farmacia.pesquisarProdutoPeloNome("Dipirona").getNome());
		assertEquals(1234, farmacia.pesquisarProdutoPeloNome("Dipirona").getCodProduto());
		assertEquals(new Double(5.00),new Double(farmacia.pesquisarProdutoPeloNome("Dipirona").getPreco()));
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void pesquisarProdutoInexistentePeloNomeTest(){
		farmacia.cadastraProduto("Paracetamol",654,4.20, 2);
		farmacia.pesquisarProdutoPeloNome("Dorflex");
		fail(MSG_FAIL);
	}
	
	@Test
	public void pesquisarProdutoPeloCodigoTest(){
		farmacia.cadastraProduto("Paracetamol",654,4.20, 2);
		Produto p = farmacia.pesquisarProdutoPeloCodigo(654);
		assertEquals("Paracetamol", p.getNome());
		assertEquals(654, p.getCodProduto());
		assertEquals(new Double(4.20),new Double(p.getPreco()));
	}
	
	@Test (expected = ProdutoInexistenteException.class)
	public void pesquisarProdutoInexistentePeloCodigoTest(){
		farmacia.pesquisarProdutoPeloCodigo(998);
		fail(MSG_FAIL);
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void pesquisarProdutoInexistenteTest(){
		farmacia.cadastraProduto("Anador",145,3.00, 3);
		farmacia.pesquisarProdutoPeloCodigo(146);
		fail(MSG_FAIL);
	}
	
	@Test
	public void adicionarQuantidadeDeUmProdutoNoEstoqueTest(){
		farmacia.cadastraProduto("Dipirona", 123, 1.20, 0);
		farmacia.adicionarProdutoEmEstoque(123, 10);
		assertEquals(10,farmacia.pesquisarProdutoPeloCodigo(123).getQuantidade());
	}
	
	@Test
	public void verificaQuantidadeEmEstoqueTest(){
		farmacia.cadastraProduto("Escova de dente - Oral-B", 5543, 5.00, 30);
		farmacia.adicionarProdutoEmEstoque(5543, 20);
		assertEquals(50,farmacia.pesquisarProdutoPeloCodigo(5543).getQuantidade());	
	}
	
	@Test
	public void buscarProdutosPeloPrecoTest(){
		farmacia.cadastraProduto("Anador", 123, 2.30, 0);
		assertEquals(1,farmacia.buscarProtudosPeloPreco(2.30).size());
	}
}
