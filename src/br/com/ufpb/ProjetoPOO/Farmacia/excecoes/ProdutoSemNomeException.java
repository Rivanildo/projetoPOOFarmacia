package br.com.ufpb.projetopoo.farmacia.excecoes;

public class ProdutoSemNomeException extends RuntimeException {
	public ProdutoSemNomeException(String msg) {
		super(msg);
	}
}
