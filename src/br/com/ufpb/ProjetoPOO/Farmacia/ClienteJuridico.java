package br.com.ufpb.projetopoo.farmacia;

public class ClienteJuridico extends Cliente {

	
	
	public ClienteJuridico(String nome,String cnpj) {
		super(nome,cnpj);
		
		
	}
	@Override
	public String toString() {
		return "Cliente "+super.getNome()+" - Cfp: "+super.getId();
	}

	

}
