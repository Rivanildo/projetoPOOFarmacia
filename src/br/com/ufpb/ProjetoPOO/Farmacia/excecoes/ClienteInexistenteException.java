package br.com.ufpb.projetopoo.farmacia.excecoes;

public class ClienteInexistenteException extends RuntimeException {
	
	public ClienteInexistenteException(String m){
		super(m);
	}

}
