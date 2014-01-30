import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FarmaciaTest {
	Farmacia farmacia;
	
	@Before
	public void iniciar(){
		this.farmacia = new Farmacia();
	}
	
	@Test
	public void verificaSeAFarmaciaEstaVazia(){
		assertNotNull(this.farmacia);
	}
	@Test
	public void isEmpty(){
		assertEquals(0, this.farmacia.getQtdeProdutosCadastrados());
	}
	
	@Test
	public void cadastraUmProduto() throws ProdutoJaExistenteException{
		farmacia.cadastraProduto(999);
		assertEquals(1,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void cadastraDoisProdutos() throws ProdutoJaExistenteException{
		farmacia.cadastraProduto(123);
		farmacia.cadastraProduto(321);
		assertEquals(2,farmacia.getQtdeProdutosCadastrados());
	}
	@Test
	public void verificaSeUmProdutoFoiCadastrato() throws ProdutoJaExistenteException{
		farmacia.cadastraProduto(1234);
		assertTrue(farmacia.isCadastrado(1234));
	}
	
	@Test (expected=ProdutoJaExistenteException.class)
	public void cadastrarUmProdutoQueJaExiste() throws ProdutoJaExistenteException{
		farmacia.cadastraProduto(111);
		farmacia.cadastraProduto(111);
		fail("devia ter lançado exception");
	}
	
	@Test
	public void verificaSeUmProdutoFoiRemovidoTest() throws ProdutoJaExistenteException{
		farmacia.cadastraProduto(123);
		farmacia.removerProduto(123);
		assertFalse(farmacia.isCadastrado(123));
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void removerProdutoInexistenteTest() throws ProdutoJaExistenteException{
		farmacia.cadastraProduto(567);
		farmacia.removerProduto(999);
		fail("Deveria ter lancado a excecao");
	}
	
	

}
