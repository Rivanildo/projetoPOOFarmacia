package br.com.ufpb.projetopoo.farmacia;

public class ClienteFisico extends Cliente {

	private String cpf;
	public ClienteFisico(String nome,String cpf) {
		super(nome);
		this.cpf = cpf;
		
		
	}

	@Override
	public String toString() {
		return "Cliente "+super.getNome()+" - Cfp: "+this.cpf;
	}

}
