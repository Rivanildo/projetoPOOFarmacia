package br.com.ufpb.ProjetoPOO.Farmacia;

public class ProdutoSemNomeException extends RuntimeException {
	public ProdutoSemNomeException (String msg){
		super(msg);
	}
}
