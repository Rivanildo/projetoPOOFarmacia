package br.com.ufpb.projetopoo.farmacia;

public class ProdutoInexistenteException extends RuntimeException {

	public ProdutoInexistenteException(String m) {
		super(m);
	}
}
