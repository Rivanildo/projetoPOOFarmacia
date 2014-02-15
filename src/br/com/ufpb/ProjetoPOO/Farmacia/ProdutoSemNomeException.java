package br.com.ufpb.projetopoo.farmacia;

public class ProdutoSemNomeException extends RuntimeException {
	public ProdutoSemNomeException(String msg) {
		super(msg);
	}
}
