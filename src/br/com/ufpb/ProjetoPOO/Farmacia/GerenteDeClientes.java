package br.com.ufpb.projetopoo.farmacia;

import java.util.LinkedList;
import java.util.List;

import br.com.ufpb.projetopoo.farmacia.excecoes.ClienteInexistenteException;
import br.com.ufpb.projetopoo.farmacia.excecoes.ClienteJaExistenteException;

public class GerenteDeClientes {

	private List <Cliente> clientes;
	
	public GerenteDeClientes(){
		clientes = new LinkedList<Cliente>();
	}

	public void cadastrarCliente(Cliente c) {
		if(isCadastrado(c.getId())){
			throw new ClienteJaExistenteException("Cliente já cadastrado");
		}
		clientes.add(c);
		
	}
	
	public boolean isCadastrado(String Id){
		for(Cliente c: clientes){
			if(c.getId().equals(Id)){
				return true;
			}
		}
		return false;
	}

	public Cliente pesquisarCliente(String id) {
		for(Cliente c : this.clientes){
			if(c.getId().equals(id)){
				return c; 
			}
		}
		throw new ClienteInexistenteException("Cliente Inexistente!");
	}

	public List<Cliente> listClientes() {
		return this.clientes;
	}

	public void removerCliente(String id) {
		
		if(!this.isCadastrado(id)){
			throw new RuntimeException("Cliente inexistente");
		}
		this.clientes.remove(this.pesquisarCliente(id));
		
	}
}
