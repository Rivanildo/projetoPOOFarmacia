import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FarmaciaTest {
	Farmacia farmacia;
	
	@Before
	public void iniciar(){
		farmacia = new Farmacia();
	}
	
	@Test
	public void isEmpty(){
		assertEquals(0, farmacia.getQtdeProdutosCadastrados());
	}

}
