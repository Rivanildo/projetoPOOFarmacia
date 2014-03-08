package br.com.ufpb.projetopoo.farmacia.excecoes;

public class ClienteJaExistenteException extends RuntimeException {
	
	public ClienteJaExistenteException(String m){
		super(m);
	}

}
