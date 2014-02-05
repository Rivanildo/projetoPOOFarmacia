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


	public void cadastraProduto(String nome, int codProduto, double preco) {
		validarProduto(nome, codProduto, preco);
		Produto produto = new Produto(nome,codProduto, preco);
		this.produtos.add(produto);
	}

	private void validarProduto(String nome, int codProduto, double preco) {
		validarNome(nome);
		validarCodigo(codProduto);
		validarPreco(preco);
	}
	
	private void validarNome(String nome){
		if(isNomeCadastrado(nome)) {
			throw new ProdutoJaExistenteException("Produto já existente!");
		}
		else if(nome == null || nome.equals("")){
			throw new ProdutoSemNomeException("O produto está sem nome!");
		}
	}

	private void validarPreco(double preco) {
		if(preco<=0){
			throw new PrecoInvalidoException("Cadastre um pre�o maior que R$ 0,00");
		}
	}

	private void validarCodigo(int codProduto) {
		if (isCadastrado(codProduto)) {
			throw new ProdutoJaExistenteException("Produto j� existente!");			
		}
	}
	
	public boolean isCadastrado(int codProduto) {
		for(Produto p : this.produtos){
			if(p.getCodProduto() == codProduto){
				return true;
			}
		}
		return false;	
	}
	
	public boolean isNomeCadastrado(String nome){
		for(Produto p: this.produtos){
			if(p.getNome() == nome){
				return true;
			}
		}
		return false;
	}

	public void removerProdutoPeloCodigo(int numProduto) {
		boolean removeu = false;
		for(Produto p: this.produtos){
			if(p.getCodProduto() == numProduto){
				this.produtos.remove(p);
				removeu = true;
				break;
			}
		}
		if(!removeu){
			throw new ProdutoInexistenteException("Produto n�o existe ");
		}
		
	}
	
	public Produto pesquisarProdutoPeloNome(String nome){
		
		for(Produto p : this.produtos){
			if(p.getNome().equals(nome)){
				return p;
			}
		}
		throw new ProdutoInexistenteException("Produto inexistente");
	}

	public Produto pesquisaProdutoPeloCodigo(int codProduto){
		for(Produto p: this.produtos){
			if(p.getCodProduto()==codProduto){
				return p;
				
			}
		}
		throw new ProdutoInexistenteException("Produto com c�digo inexistente");
	}
}
