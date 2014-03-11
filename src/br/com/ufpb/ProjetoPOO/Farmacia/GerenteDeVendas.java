package br.com.ufpb.projetopoo.farmacia;

public class GerenteDeVendas {
	
	GerenteDeProdutos gerenteProduto;
	
	public GerenteDeVendas(GerenteDeProdutos gerente){
		this.gerenteProduto = gerente;
	}
	
	
	public void venderProduto(long codProduto, int quant){
		Produto p = this.gerenteProduto.getProduto(codProduto);
		p.setQuantidade(p.getQuantidade()-quant);
	}

}
