
public class Produto {

	private long codProduto;
	private double preco;
	
	public Produto(long codProduto){
		this.codProduto = codProduto;
		
	}
	
	public Produto(long codProduto, double preco){
		this.codProduto = codProduto;
		this.preco = preco; 
	}
	
	public long getCodProduto() {
		return codProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
