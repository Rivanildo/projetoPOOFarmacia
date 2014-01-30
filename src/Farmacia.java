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


	public void cadastraProduto(long codProduto, double preco) throws ProdutoJaExistenteException {
		for (Produto p: this.produtos) {
			if (p.getCodProduto() == codProduto) {
				throw new ProdutoJaExistenteException("Produto já existente!");
			}
		}
		Produto produto = new Produto(codProduto, preco);
		this.produtos.add(produto);
		
	}

	

	public boolean isCadastrado(int codProduto) {
		
		for(Produto p : this.produtos){
			if(p.getCodProduto() == codProduto ){
				return true;
			}
		}
		return false;
		
	}

	public void removerProduto(int numProduto) {
		boolean removeu = false;
		for(Produto p : this.produtos){
			if(p.getCodProduto() == numProduto){
				produtos.remove(p);
				removeu = true;
			}
		}
		if(!removeu){
			throw new ProdutoInexistenteException("Produto não existe ");
		}
		
	}
}
