package br.com.ufpb.projetopoo.farmacia;

import java.util.LinkedList;
import java.util.List;

import br.com.ufpb.projetopoo.farmacia.excecoes.PrecoInvalidoException;
import br.com.ufpb.projetopoo.farmacia.excecoes.ProdutoInexistenteException;
import br.com.ufpb.projetopoo.farmacia.excecoes.ProdutoJaExistenteException;
import br.com.ufpb.projetopoo.farmacia.excecoes.ProdutoSemNomeException;
import br.com.ufpb.projetopoo.farmacia.excecoes.QuantidadeInvalidaException;

public class GerenteDeProdutos {
	
	private List<Produto> produtos;
	
	public GerenteDeProdutos(){
		produtos = new LinkedList<Produto>();
	}
	
	public void cadastraProduto(Produto p) {
		validarProduto(p.getNome(), p.getCodProduto(),p.getPreco(),p.getQuantidade());
		this.produtos.add(p);
	}

	private void validarProduto(String nome, long codProduto, double preco, int qtde) {
		validarNome(nome);
		validarCodigo(codProduto);
		validarPreco(preco);
		validarQuantidade(qtde);
	}

	private void validarQuantidade(int qtde) {
		if (qtde < 0) {
			throw new QuantidadeInvalidaException("Quantidade Inv�lida");
		}

	}

	private void validarNome(String nome) {
		if (isNomeCadastrado(nome)) {
			throw new ProdutoJaExistenteException("Produto já existente!");
		} else if (nome == null || nome.equals("")) {
			throw new ProdutoSemNomeException("O produto está sem nome!");
		}
	}

	private void validarPreco(double preco) {
		if (preco <= 0) {
			throw new PrecoInvalidoException(
					"Cadastre um pre�o maior que R$ 0,00");
		}
	}

	private void validarCodigo(long codProduto) {
		if (isCadastrado(codProduto)) {
			throw new ProdutoJaExistenteException("Produto j� existente!");
		}
	}

	private boolean isCadastrado(long codProduto) {
		for (Produto p : this.produtos) {
			if (p.getCodProduto() == codProduto) {
				return true;
			}
		}
		return false;
	}

	private boolean isNomeCadastrado(String nome) {
		for (Produto p : this.produtos) {
			if (p.getNome() == nome) {
				return true;
			}
		}
		return false;
	}

	public void removerProdutoPeloCodigo(int numProduto) {
		
		Produto p = this.getProduto(numProduto);
		if(p == null){
			throw new ProdutoInexistenteException("Produto inexistente!");
		}
		this.produtos.remove(p);
		
	}

	public Produto pesquisarProdutoPeloNome(String nome) {

		for (Produto p : this.produtos) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		return null;
	}

	public void adicionarProdutoEmEstoque(int codProduto, int quantidade) {
		Produto p = this.getProduto(codProduto);
		p.adicionarQuantidadeDeProdutoEmEstoque(quantidade);
	}

	public List<Produto> buscarProdutosPeloPreco(double preco) {
		List<Produto> listaProdutos = new LinkedList<Produto>();
		for (Produto p : this.produtos) {
			if (p.getPreco() == preco) {
				listaProdutos.add(p);
			}
		}
		if (listaProdutos.size() == 0) {
			throw new ProdutoInexistenteException(
					"Não existe produto com esse preço");
		}
		return listaProdutos;
	}

	public List<Produto> listProdutos() {
		return this.produtos;
	}

	public Produto getProduto(long codProduto) {
		for (Produto p : this.produtos) {
			if (p.getCodProduto() == codProduto) {
				return p;
			}
		}
		return null;
	}

	public void atualizarProduto(Produto p1) {
			
		for(Produto p : this.produtos){
			
			if(p.getCodProduto() == p1.getCodProduto()){
				p.setNome(p1.getNome());
				p.setPreco(p1.getPreco());
				p.setQuantidade(p1.getQuantidade());
			}
		}
	}

	public double verificarValorDoProduto(long codProduto) {
		Produto p = this.getProduto(codProduto);
		double preco = 0.0;
		if (p != null){
			return p.getPreco();
		}
		throw new ProdutoInexistenteException("Produto inexistente");
	}

	public void alterarQuantidade(long codProduto, int quantidade) {
		Produto p = this.getProduto(codProduto);
		if (p != null && quantidade >= 0){
			if (quantidade >= 0){
				p.setQuantidade(quantidade);
			}
			else {
				throw new QuantidadeInvalidaException("Quantidade Invalida");
			}
		}
		else {
			throw new ProdutoInexistenteException("Produto inexistente!");
		}
	}
}
