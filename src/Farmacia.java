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

	public void cadastraProduto(long numProduto) {
		Produto produto = new Produto(numProduto);
		this.produtos.add(produto);
		
	}

	public boolean isCadastrado(int numProduto) {
		
		for(Produto p : this.produtos){
			if(p.getNumProduto() == numProduto ){
				return true;
			}
		}
		return false;
		
	}
}
