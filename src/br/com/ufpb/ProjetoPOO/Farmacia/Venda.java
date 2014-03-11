package br.com.ufpb.projetopoo.farmacia;

import java.util.List;
import java.util.LinkedList;

public class Venda {
	
	List <ItemDeVenda> itens;
	
	public Venda(){
		itens = new LinkedList <ItemDeVenda> ();
	}
	
	public void adicionarItem(ItemDeVenda i) {
		itens.add(i);
	}

}
