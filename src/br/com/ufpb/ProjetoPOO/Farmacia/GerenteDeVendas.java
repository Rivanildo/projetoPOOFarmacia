package br.com.ufpb.projetopoo.farmacia;

import br.com.ufpb.projetopoo.farmacia.excecoes.QuantidadeInvalidaException;

public class GerenteDeVendas {
	
	GerenteDeProdutos gerenteProduto;
	
	public GerenteDeVendas(GerenteDeProdutos gerente){
		this.gerenteProduto = gerente;
	}
	
	public void venderProduto(long codProduto, int quant) throws QuantidadeInvalidaException{
		Produto p = this.gerenteProduto.getProduto(codProduto);
		if(quant > p.getQuantidade() || quant <= 0){
			throw new QuantidadeInvalidaException("Quantidade Inválida");
		}
		p.setQuantidade(p.getQuantidade()-quant);
	}

	public void vender(Venda v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
