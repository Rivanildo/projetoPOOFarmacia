package br.com.ufpb.ProjetoPOO.Farmacia;

public class ProdutoInexistenteException extends RuntimeException {
	
	public ProdutoInexistenteException(String m){
		super(m);
	}
}
