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


	public void cadastraProduto(long codProduto, double preco) {
		for (Produto p: this.produtos) {
			if (p.getCodProduto() == codProduto) {
				throw new ProdutoJaExistenteException("Produto j� existente!");
			}
		}
		if(preco <= 0){
			throw new PrecoInvalidoException("Cadastre um pre�o maior que R$ 0,00");
		}else{
			Produto produto = new Produto(codProduto, preco);
                	this.produtos.add(produto);
		}
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
			throw new ProdutoInexistenteException("Produto n�o existe ");
		}	
	}
}
