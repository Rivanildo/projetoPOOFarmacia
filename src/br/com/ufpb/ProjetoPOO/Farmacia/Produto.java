package br.com.ufpb.projetopoo.farmacia;

public class Produto {

	private String nome;
	private long codProduto;
	private double preco;
	private int quantidade;

	//Fazer o método equals
	public Produto(long codProduto) {
		this.codProduto = codProduto;
	}

	public Produto(String nome, long codProduto, double preco) {
		this.nome = nome;
		this.codProduto = codProduto;
		this.preco = preco;
		this.quantidade = 0;
	}

	public Produto(String nome, long codProduto, double preco, int qtde) {
		this.nome = nome;
		this.codProduto = codProduto;
		this.preco = preco;
		this.quantidade = qtde;
	}

	public String getNome() {
		return this.nome;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduto != other.codProduto)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(int quant){
		this.quantidade = quant;
	}

	public void adicionarQuantidadeDeProdutoEmEstoque(int quantidade) {
		this.quantidade += quantidade;
	}

	
}
