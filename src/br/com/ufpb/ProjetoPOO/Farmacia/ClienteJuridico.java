package br.com.ufpb.projetopoo.farmacia;

public class ClienteJuridico extends Cliente {

	private String cnpj;
	
	public ClienteJuridico(String nome,String cnpj) {
		super(nome);
		this.cnpj = cnpj;
		
	}
	@Override
	public String toString() {
		return "Cliente "+super.getNome()+" - Cfp: "+this.cnpj;
	}

	

}
