package br.com.ufpb.projetopoo.farmacia.excecoes;

public class ProdutoJaExistenteException extends RuntimeException {
	public ProdutoJaExistenteException(String msg) {
		super(msg);
	}
}