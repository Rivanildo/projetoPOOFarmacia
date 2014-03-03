package br.com.ufpb.projetopoo.farmacia;

import java.util.LinkedList;
import java.util.List;

public class Farmacia {
	private GerenteDeProdutos gerenteProduto;
	
	//Criar a classe gerente de produto e jogar tudo isso aqui dentro
	public Farmacia() {
		gerenteProduto = new GerenteDeProdutos();
	}

	public void cadastraProduto(Produto p){
		this.gerenteProduto.cadastraProduto(p);
	}
	public void removerProdutoPeloCodigo(int numProduto){
		this.gerenteProduto.removerProdutoPeloCodigo(numProduto);
	}
	public Produto pesquisarProdutoPeloNome(String nome) {
		return this.gerenteProduto.pesquisarProdutoPeloNome(nome);
	}
	public void adicionarProdutoEmEstoque(int codProduto, int quantidade) {
		this.gerenteProduto.adicionarProdutoEmEstoque(codProduto, quantidade);
	}
	public List<Produto> buscarProdutosPeloPreco(double preco) {
		return this.gerenteProduto.buscarProdutosPeloPreco(preco);
	}
	public List<Produto> listProdutos() {
		return this.gerenteProduto.listProdutos();
	}
	public Produto getProduto(long codProduto) {
		return this.gerenteProduto.getProduto(codProduto);
	}
}
