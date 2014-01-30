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

<<<<<<< HEAD
	public void cadastraProduto(long numProduto) throws ProdutoJaExistenteException {
		for (Produto p: this.produtos) {
			if (p.getNumProduto() == numProduto) {
				throw new ProdutoJaExistenteException("Produto já existente!");
			}
		}
=======
	public void cadastraProduto(long numProduto) {
>>>>>>> 01d84d3f3e246e1ce1a3566c9df1a4d1d796ee5a
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
