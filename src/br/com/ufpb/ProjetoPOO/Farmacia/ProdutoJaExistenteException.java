package br.com.ufpb.projetopoo.farmacia;

public class ProdutoJaExistenteException extends RuntimeException {
	public ProdutoJaExistenteException(String msg) {
		super(msg);
	}
}