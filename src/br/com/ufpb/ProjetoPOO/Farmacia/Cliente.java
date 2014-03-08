package br.com.ufpb.projetopoo.farmacia;

public abstract class Cliente{

	private String nome;
	public Cliente(String nome) {
		this.nome = nome;
		// TODO Auto-generated constructor stub
	}

	public abstract String toString();

	public String getNome() {
		return this.nome;
	}

}
