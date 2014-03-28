package br.com.ufpb.projetopoo.farmacia;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.ufpb.projetopoo.farmacia.excecoes.*;

public class FarmaciaTest {
	Farmacia farmacia;
	
	@Before
	public void iniciar() {
		this.farmacia = new Farmacia();
	}
	
	@Test
	public void verificaSeEstaVazia() {
		assertEquals(0, this.farmacia.listProdutos().size());
	}
	
	@Test
	public void cadastraUmProduto() {
		Produto produto1 = new Produto("aaa", 999, 2.00, 2);
		farmacia.cadastraProduto(produto1);
		List<Produto> produtos = this.farmacia.listProdutos();
		assertEquals(1, produtos.size());
		assertEquals(produto1, produtos.get(0));
	}
	
	@Test
	public void cadastraDoisProdutos() {
		Produto produto1 = new Produto("bbb", 123, 3.30, 2);
		Produto produto2 = new Produto("ccc", 321, 1.00, 2);
		farmacia.cadastraProduto(produto1);
		farmacia.cadastraProduto(produto2);
		assertEquals(2, farmacia.listProdutos().size());
	}
	
	@Test
	public void verificaSeUmProdutoFoiCadastrato() {
		Produto produto1 = new Produto("ddd", 1234, 0.99);
		farmacia.cadastraProduto(produto1);
		assertEquals(produto1, farmacia.getProduto(1234));
	}
	
	@Test(expected = ProdutoJaExistenteException.class)
	public void cadastrarUmProdutoQueJaExiste() {
		Produto produto1 = new Produto("eee", 111, 2.00);
		Produto produto2 = new Produto("eee", 111, 2.00);
		farmacia.cadastraProduto(produto1);
		farmacia.cadastraProduto(produto2);
	}
	
	@Test
	public void verificaSeUmProdutoFoiRemovidoTest() {
		Produto p = new Produto("abc", 555, 2.00, 5);
		farmacia.cadastraProduto(p);
		farmacia.removerProdutoPeloCodigo(555);
		assertNull(farmacia.getProduto(555));
	}
	
	@Test(expected = ProdutoInexistenteException.class)
	public void removerProdutoInexistenteTest() {
		Produto p = new Produto("abb", 567, 2.00);
		farmacia.cadastraProduto(p);
		farmacia.removerProdutoPeloCodigo(999);
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoNegativo() {
		Produto p = new Produto("scs", 55, -4);
		farmacia.cadastraProduto(p);
	}
	
	@Test(expected = PrecoInvalidoException.class)
	public void cadastraProdutoComPrecoIgualAZero() {
		Produto p = new Produto("aaa", 51, 0, 2);
		farmacia.cadastraProduto(p);
	}
	
	@Test(expected = ProdutoJaExistenteException.class)
	public void cadastrarProdutoComNomeJaExistente() {
		Produto p1 = new Produto("aaa", 123, 2.50, 10);
		Produto p2 = new Produto("aaa", 444, 3.20, 50);
		farmacia.cadastraProduto(p1);
		farmacia.cadastraProduto(p2);
	}
	
	@Test(expected = ProdutoSemNomeException.class)
	public void cadastrarProdutoSemNomeTest() {
		Produto p = new Produto("", 123, 2.30, 2);
		farmacia.cadastraProduto(p);
	}
	
	@Test(expected = ProdutoSemNomeException.class)
	public void cadastrarProdutoSemNomeTest2() {
		Produto p = new Produto(null, 123, 2.30, 7);
		farmacia.cadastraProduto(p);
	}
	
	@Test //Mexido
	public void pesquisarProdutoPeloNomeTest() {
		Produto p = new Produto("Dipirona", 1234, 5.00, 4);
		farmacia.cadastraProduto(p);
		Produto produtoPeloNome = farmacia.pesquisarProdutoPeloNome("Dipirona");
		assertEquals(p, produtoPeloNome);
	}
	
	@Test
	public void pesquisarProdutoInexistentePeloNomeTest() {
		Produto p = new Produto("Paracetamol", 654, 4.20);
		farmacia.cadastraProduto(p);
		assertNull(farmacia.pesquisarProdutoPeloNome("Dorflex"));
	}
	
	@Test
	public void pesquisarProdutoPeloCodigoTest() {
		Produto p1 = new Produto("Paracetamol", 654, 4.20, 100);
		farmacia.cadastraProduto(p1);
		Produto p2 = farmacia.getProduto(654);
		assertEquals(p1, p2);
	}
	
	@Test
	public void pesquisarProdutoInexistentePeloCodigoTest() {
		Produto p = new Produto("Paracetamol", 654, 4.20, 400);
		farmacia.cadastraProduto(p);
		assertNull(farmacia.getProduto(998));
	}
	
	@Test
	public void pesquisarProdutoInexistenteTest() {
		Produto p = new Produto("Anador", 145, 3.00, 3);
		farmacia.cadastraProduto(p);
		assertNull(farmacia.getProduto(146));
	}
	
	@Test
	public void adicionarQuantidadeDeUmProdutoNoEstoqueTest() {
		Produto p = new Produto("Dipirona", 123, 1.20);
		farmacia.cadastraProduto(p);
		farmacia.adicionarProdutoEmEstoque(123, 10);
		assertEquals(10, farmacia.getProduto(123).getQuantidade());
	}
	
	@Test
	public void verificaQuantidadeEmEstoqueTest() {
		Produto p = new Produto("Escova de dente - Oral-B", 5543, 5.00, 30);
		farmacia.cadastraProduto(p);
		farmacia.adicionarProdutoEmEstoque(5543, 50);
		assertEquals(80, farmacia.getProduto(5543).getQuantidade());
	}
	
	@Test(expected = QuantidadeInvalidaException.class)
	public void cadastraProdutoQuantidadeNegativaTest(){
		Produto p1 = new Produto("Dipirona",334,1.00,-3);
		farmacia.cadastraProduto(p1);
	}
	
	@Test
	public void buscarProdutosPeloPrecoTest() {
		Produto p = new Produto("Anador", 123, 2.30);
		farmacia.cadastraProduto(p);
		assertEquals(1, farmacia.buscarProdutosPeloPreco(2.30).size());
	}
	
	@Test
	public void buscarProdutosPeloPrecoTest2() {
		Produto p1 = new Produto("Anador", 111, 2.30);
		Produto p2 = new Produto("Dipirona", 222, 4.80);
		Produto p3 = new Produto("Benegrip", 333, 5.10);
		Produto p4 = new Produto("Doril", 444, 2.30);
		farmacia.cadastraProduto(p1);
		farmacia.cadastraProduto(p2);
		farmacia.cadastraProduto(p3);
		farmacia.cadastraProduto(p4);
		assertEquals(2, farmacia.buscarProdutosPeloPreco(2.30).size());
	}
	
	@Test
	public void alterarNomeTest(){
		Produto p1 = new Produto("Anador",1234,3.00);
		farmacia.cadastraProduto(p1);
		p1.setNome("Dorflex");
		farmacia.atualizarProduto(p1);
		assertEquals(p1.getNome(), farmacia.getProduto(1234).getNome());
	}
	
	@Test
	public void alterarNomeTest2(){
		Produto p1 = new Produto("Narix",9581,12.00);
		farmacia.cadastraProduto(p1);
		p1.setNome("Vick");
		farmacia.atualizarProduto(p1);
		assertEquals(p1.getNome(), farmacia.getProduto(9581).getNome());
		p1.setNome("Valda");
		farmacia.atualizarProduto(p1);
		assertEquals(p1.getNome(), farmacia.getProduto(9581).getNome());
	}
	
	@Test
	public void alterarPrecoTest(){
		Produto p1 = new Produto("Cataflan",7788,5.50);
		farmacia.cadastraProduto(p1);
		p1.setPreco(9.00);
		farmacia.atualizarProduto(p1);
		assertEquals(new Double(p1.getPreco()),new Double(farmacia.getProduto(7788).getPreco()));
	}
	
	@Test
	public void alterarPrecoTest2(){
		Produto p1 = new Produto("Vick",9318,8.30);
		farmacia.cadastraProduto(p1);
		p1.setPreco(9.00);
		farmacia.atualizarProduto(p1);
		assertEquals(new Double(p1.getPreco()),new Double(farmacia.getProduto(9318).getPreco()));
		p1.setPreco(9.99);
		farmacia.atualizarProduto(p1);
		assertEquals(new Double(p1.getPreco()),new Double(farmacia.getProduto(9318).getPreco()));
	}
	
	@Test
	public void alterarProdutoTest(){
		Produto p1 = new Produto("Kinker ovo",6677,12.00);
		farmacia.cadastraProduto(p1);
		p1.setNome("Ovo surpresa");
		p1.setPreco(19.99);
		farmacia.atualizarProduto(p1);
		assertEquals(p1,farmacia.getProduto(6677));
	}
	
	@Test
	public void cadastrarCliente(){
		Cliente c = new Cliente("Rivanildo","535.764.974-15");
		farmacia.cadastrarCliente(c);
		List<Cliente> clientes = farmacia.listClientes();
		assertEquals(1,clientes.size());		
		assertEquals(c, clientes.get(0));
	}
	
	@Test
	public void	pesquisaClienteTest(){
		Cliente c = new Cliente("Tayná","434.865.555-45");
		farmacia.cadastrarCliente(c);
		assertEquals(c, farmacia.pesquisarCliente("434.865.555-45"));
	}
	
	@Test(expected = ClienteJaExistenteException.class)
	public void cadastraClienteComMesmoIdTest(){
		Cliente c = new Cliente("Tayná","434.865.555-45");
		farmacia.cadastrarCliente(c);
		Cliente d = new Cliente("Tayná","434.865.555-45");
		farmacia.cadastrarCliente(d);
	}
	
	@Test
	public void removeClienteTest(){
		Cliente c = new Cliente("Vanessa","123.345.567-90");
		farmacia.cadastrarCliente(c);
		farmacia.removerCliente(c.getId());
		List<Cliente> lista = farmacia.listClientes();
		assertEquals(0, lista.size());
	}
	
	@Test(expected = Exception.class)
	public void removeClienteInexistenteTest(){
		Cliente c = new Cliente("Vanessa","123.345.567-90");
		farmacia.cadastrarCliente(c);
		farmacia.removerCliente("234.977.553-56");
	}
	
	@Test
	public void removeClienteTest2(){
		Cliente c1 = new Cliente("Vanessa","123.345.567-90");
		Cliente c2= new Cliente("Rhaleff","321.856.097-80");
		Cliente c3 = new Cliente("Elze","132.145.067-10");
		farmacia.cadastrarCliente(c1);
		farmacia.cadastrarCliente(c2);
		farmacia.cadastrarCliente(c3);
		farmacia.removerCliente(c2.getId());
		List<Cliente> lista = farmacia.listClientes();
		assertEquals(2,lista.size());
	}
	
	@Test
	public void pesquisarClienteNaoCadastradoTest(){
		Cliente c1 = new Cliente("Vanessa","123.345.567-90");
		farmacia.cadastrarCliente(c1);
		Cliente e = farmacia.pesquisarCliente("132.145.067-10");
		assertNull(e);
	}
	
	@Test
	public void venderProdutoTest(){
		Produto p = new Produto("Dipirona", 123, 2.00, 5);
		farmacia.cadastraProduto(p);
		farmacia.venderProduto(123,2);
		assertEquals(3,p.getQuantidade());
	}
	
	@Test (expected = Exception.class)
	public void venderProdutoQuantidadeMaiorTest(){
		Produto p = new Produto("Anador", 444, 1.00, 10);
		farmacia.cadastraProduto(p);
		farmacia.venderProduto(444,11);
	}
	
	@Test (expected = Exception.class)
	public void venderProdutoQuantidadeInvalidaTest() {
		Produto p = new Produto("Nimesulida", 222, 3.00, 5);
		farmacia.cadastraProduto(p);
		farmacia.venderProduto(222,-1);
	}
	
	@Test (expected = Exception.class)
	public void venderProdutoQuantidadeZeroTest() {
		Produto p = new Produto("Doril", 101, 1.50, 3);
		farmacia.cadastraProduto(p);
		farmacia.venderProduto(101,0);
	}
	
	@Test
	public void venderItensTest() {
		Produto p = new Produto("Doril", 101, 1.50, 3);
		farmacia.cadastraProduto(p);
		ItemDeVenda i = new ItemDeVenda(p,2);
		Venda v = new Venda();
		v.adicionarItem(i);
		farmacia.vender(v);
	}
	
	@Test (expected = Exception.class)
	public void venderProdutoInexistenteTest() {
		farmacia.venderProduto(123, 2);
	}
	
	@Test (expected = Exception.class)
	public void verificarValorDoProdutoInexistenteTest(){
		farmacia.verificarValorDoProduto(999);
	}
	
	@Test (expected = Exception.class)
	public void alterarQuantidadeInvalidaTest(){
		Produto p = new Produto("Dipirona", 111, 1.20, 50);
		farmacia.cadastraProduto(p);
		farmacia.alterarQuantidade(111,-1);
	}
	
	@Test (expected = Exception.class)
	public void alterarQuantidadeDeProdutoInexistenteTest(){
		farmacia.alterarQuantidade(111,5);
	}
}