package com.estudandoemcasa.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudandoemcasa.curso.entidades.Categoria;
import com.estudandoemcasa.curso.entidades.ItemPedido;
import com.estudandoemcasa.curso.entidades.Pagamento;
import com.estudandoemcasa.curso.entidades.Pedido;
import com.estudandoemcasa.curso.entidades.Produto;
import com.estudandoemcasa.curso.entidades.Usuario;
import com.estudandoemcasa.curso.entidades.enums.PedidoStatus;
import com.estudandoemcasa.curso.repositorios.CategoriaRepositorio;
import com.estudandoemcasa.curso.repositorios.ItemPedidoRepositorio;
import com.estudandoemcasa.curso.repositorios.PedidoRepositorio;
import com.estudandoemcasa.curso.repositorios.ProdutoRepositorio;
import com.estudandoemcasa.curso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepositorio usuarioRePositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRpesitorio;
	
	@Autowired
	private ItemPedidoRepositorio itemPedidoRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores"); 
		categoriaRepositorio.saveAll(Arrays.asList(cat1,cat2,cat3));

		Produto pdt1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pdt2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pdt3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pdt4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pdt5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		produtoRpesitorio.saveAll(Arrays.asList(pdt1,pdt2,pdt3,pdt4,pdt5));

		pdt1.getCategorias().add(cat2);
		pdt2.getCategorias().add(cat1);
		pdt3.getCategorias().add(cat3);
		pdt4.getCategorias().add(cat3);
		pdt5.getCategorias().add(cat2);
		produtoRpesitorio.saveAll(Arrays.asList(pdt1,pdt2,pdt3,pdt4,pdt5));

		Usuario us1 = new Usuario(null, "Miguel Pereira Silva", "miguel.p.silva@gmail.com", "4321", "1234");
		Usuario us2 = new Usuario(null, "Miguel Silva", "miguel.silva@gmail.com", "1234", "4321");
		usuarioRePositorio.saveAll(Arrays.asList(us1,us2));

		Pedido p1 = new Pedido(null,Instant.parse("2019-06-20T19:53:08Z"), PedidoStatus.ENVIADO,us1);
		Pedido p2 = new Pedido(null,Instant.parse("2019-07-20T04:02:28Z"), PedidoStatus.PAGO,us2);
		Pedido p3 = new Pedido(null,Instant.parse("2019-08-20T17:14:38Z"), PedidoStatus.ENTREGUE,us1);
		pedidoRepositorio.saveAll(Arrays.asList(p1,p2,p3));

		ItemPedido ip1 = new ItemPedido(p1,pdt1, 2, pdt1.getPreco());
		ItemPedido ip2 = new ItemPedido(p1,pdt3, 1, pdt4.getPreco());
		ItemPedido ip3 = new ItemPedido(p2,pdt3, 2, pdt1.getPreco());
		ItemPedido ip4 = new ItemPedido(p3,pdt5, 2, pdt5.getPreco());
		itemPedidoRepositorio.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
		
		
		Pagamento pg1 = new Pagamento(null, Instant.parse("2019-07-20T06:02:28Z"), p2);
		p1.setPagamento(pg1);
		pedidoRepositorio.save(p1);
		
	}
}
