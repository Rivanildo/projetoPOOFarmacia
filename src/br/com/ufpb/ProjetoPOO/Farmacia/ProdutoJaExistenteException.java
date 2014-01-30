package br.com.ufpb.ProjetoPOO.Farmacia;
public class ProdutoJaExistenteException extends RuntimeException{
	public ProdutoJaExistenteException(String msg){
		super(msg);
	}
}