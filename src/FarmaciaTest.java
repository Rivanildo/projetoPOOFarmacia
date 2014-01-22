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
	public void cadastraUmProduto(){
		farmacia.cadastraProduto(999);
		assertEquals(1,farmacia.getQtdeProdutosCadastrados());
	}

}
