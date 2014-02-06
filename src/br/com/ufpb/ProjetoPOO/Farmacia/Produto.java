package br.com.ufpb.ProjetoPOO.Farmacia;

public class Produto {

	private String nome;
	private long codProduto;
	private double preco;
	private int quantidade;
	public Produto(long codProduto){
		this.codProduto = codProduto;
		
	}
	
	public Produto(String nome, long codProduto, double preco,int qtde){
		this.nome = nome;
		this.codProduto = codProduto;
		this.preco = preco; 
		this.setQuantidade(qtde);
	}
	
	public String getNome() {
		return this.nome;
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
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
