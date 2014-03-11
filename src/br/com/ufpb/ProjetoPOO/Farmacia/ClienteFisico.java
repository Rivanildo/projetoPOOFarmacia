package br.com.ufpb.projetopoo.farmacia;

public class ClienteFisico extends Cliente {

	
	public ClienteFisico(String nome,String cpf) {
		super(nome,cpf);
		
		
		
	}

	@Override
	public String toString() {
		return "Cliente "+super.getNome()+" - Cfp: "+super.getId();
	}

}
