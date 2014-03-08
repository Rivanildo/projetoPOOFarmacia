package br.com.ufpb.projetopoo.farmacia;

import java.util.LinkedList;
import java.util.List;

public class GerenteDeClientes {

	private List <Cliente> clientes;
	
	public GerenteDeClientes(){
		clientes = new LinkedList<Cliente>();
	}

	public void cadastrarCliente(Cliente c) {
		clientes.add(c);
		
	}

	public Cliente pesquisarCliente(String id) {
		for(Cliente c : this.clientes){
			if(c.getId().equals(id)){
				return c; 
			}
		}
		return null;
		
	}

	public List<Cliente> listClientes() {
		return this.clientes;
	}
}
