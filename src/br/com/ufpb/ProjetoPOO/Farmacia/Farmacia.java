package br.com.ufpb.ProjetoPOO.Farmacia;

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


	public void cadastraProduto(int codProduto, double preco) {
		validarProduto(codProduto, preco);
		Produto produto = new Produto(codProduto, preco);
		this.produtos.add(produto);
	}

	private void validarProduto(int codProduto, double preco) {
		validarCodigo(codProduto);
		validarPreco(preco);
	}

	private void validarPreco(double preco) {
		if(preco<=0){
			throw new PrecoInvalidoException("Cadastre um preço maior que R$ 0,00");
		}
	}

	private void validarCodigo(int codProduto) {
		if (isCadastrado(codProduto)) {
			throw new ProdutoJaExistenteException("Produto já existente!");			
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
			throw new ProdutoInexistenteException("Produto não existe ");
		}
		
	}
}
