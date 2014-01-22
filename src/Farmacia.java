import java.util.LinkedList;
import java.util.List;


public class Farmacia {

	
	List<Produto> produtos;
	
	public Farmacia(){
		produtos = new LinkedList<Produto>();
	}

	public Object getQtdeProdutosCadastrados() {
		return this.produtos.size();
	}

	public void cadastraProduto(long i) {
		Produto a = new Produto(i);
		this.produtos.add(a);
		
	}
}
