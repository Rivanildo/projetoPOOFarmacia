package br.com.ufpb.projetopoo.farmacia.excecoes;

public class ProdutoInexistenteException extends RuntimeException {

	public ProdutoInexistenteException(String m) {
		super(m);
	}
}
