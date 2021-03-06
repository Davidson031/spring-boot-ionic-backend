package com.davidson.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.davidson.cursomc.domain.Categoria;
import com.davidson.cursomc.domain.Cidade;
import com.davidson.cursomc.domain.Cliente;
import com.davidson.cursomc.domain.Endereco;
import com.davidson.cursomc.domain.Estado;
import com.davidson.cursomc.domain.ItemPedido;
import com.davidson.cursomc.domain.Pagamento;
import com.davidson.cursomc.domain.PagamentoComBoleto;
import com.davidson.cursomc.domain.PagamentoComCartao;
import com.davidson.cursomc.domain.Pedido;
import com.davidson.cursomc.domain.Produto;
import com.davidson.cursomc.domain.enums.EstadoPagamento;
import com.davidson.cursomc.domain.enums.Perfil;
import com.davidson.cursomc.domain.enums.TipoCliente;
import com.davidson.cursomc.repositories.CategoriaRepository;
import com.davidson.cursomc.repositories.CidadeRepository;
import com.davidson.cursomc.repositories.ClienteRepository;
import com.davidson.cursomc.repositories.EnderecoRepository;
import com.davidson.cursomc.repositories.EstadoRepository;
import com.davidson.cursomc.repositories.ItemPedidoRepository;
import com.davidson.cursomc.repositories.PagamentoRepository;
import com.davidson.cursomc.repositories.PedidoRepository;
import com.davidson.cursomc.repositories.ProdutoRepository;


@Service
public class DBService {

	//dependencias
		@Autowired
		private BCryptPasswordEncoder pe;
		@Autowired
		private CategoriaRepository categoriaRepository;
		@Autowired
		private ProdutoRepository produtoRepository;
		@Autowired
		private EstadoRepository estadoRepository;
		@Autowired
		private CidadeRepository cidadeRepository;
		@Autowired
		private ClienteRepository clienteRepository;
		@Autowired
		private EnderecoRepository enderecoRepository;
		@Autowired
		private PedidoRepository pedidoRepository;
		@Autowired
		private PagamentoRepository pagamentoRepository;
		@Autowired
		private ItemPedidoRepository itemPedidoRepository;
	
		
		
		public void instantiateTestDatabase() throws ParseException {
			
				//criando categorias
				Categoria cat1 = new Categoria(null, "Inform??tica");
				Categoria cat2 = new Categoria(null, "Escrit??rio");
				Categoria cat3 = new Categoria(null, "Cama mesa e banho");
				Categoria cat4 = new Categoria(null, "Eletr??nicos");
				Categoria cat5 = new Categoria(null, "Jardinagem");
				Categoria cat6 = new Categoria(null, "Decora????o");
				Categoria cat7 = new Categoria(null, "Perfumaria");
				Categoria cat8 = new Categoria(null, "Teste");
				
				//criando produtos
				Produto p1 = new Produto(null, "Computador", 2000.00);
				Produto p2 = new Produto(null, "Impressora", 800.00);
				Produto p3 = new Produto(null, "Mouse", 80.00);
				Produto p4 = new Produto(null, "Mesa de Escrit??rio", 300.00);
				Produto p5 = new Produto(null, "Toalha", 50.00);
				Produto p6 = new Produto(null, "Colcha", 200.00); 
				Produto p7 = new Produto(null, "TV True Color", 1200.00);
				Produto p8 = new Produto(null, "Ro??adeira", 800.00);
				Produto p9 = new Produto(null, "Abajour", 100.00);
				Produto p10 = new Produto(null, "Pendente", 180.00);
				Produto p11 = new Produto(null, "Shampoo", 90.00);
				
				//criando estados
				Estado est1 = new Estado(null, "Minas Gerais");
				Estado est2 = new Estado(null, "S??o paulo");
				
				//criando cidades
				Cidade c1 = new Cidade(null, "Uberl??ndia", est1);
				Cidade c2 = new Cidade(null, "S??o Paulo", est2);
				Cidade c3 = new Cidade(null, "Campinas", est2);
				
				//criando clientes
				Cliente cli1 = new Cliente(null, "Maria Silva", "davidson0031@gmail.com", "21421545479", TipoCliente.PESSOAFISICA, pe.encode("123"));
				Cliente cli2 = new Cliente(null, "Jo??o Pedro", "davidson@gmail.com", "97160293061", TipoCliente.PESSOAFISICA, pe.encode("123"));
				Cliente cli3 = new Cliente(null, "Nathalia", "nathalia@gmail.com", "123456789", TipoCliente.PESSOAFISICA, pe.encode("123"));
				//criando endere??os
				Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
				Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "88751541", cli1, c2);
				Endereco e3 = new Endereco(null, "Avenida 1", "105", "Sala 8", "Centro", "22751741", cli2, c2);
				Endereco e4 = new Endereco(null, "Avenida 10", "10", "Sala 10", "Centro", "22871741", cli3, c2);
				//criando pedidos
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
				Pedido ped2 = new Pedido(null, sdf.parse("11/10/2017 19:35"), cli1, e2);
				Pedido ped3 = new Pedido(null, sdf.parse("12/10/2017 19:35"), cli1, e2);
				Pedido ped4 = new Pedido(null, sdf.parse("13/10/2017 19:35"), cli1, e2);
				Pedido ped5 = new Pedido(null, sdf.parse("14/10/2017 19:35"), cli1, e2);
				
				
				Pedido ped6 = new Pedido(null, sdf.parse("10/10/2017 11:35"), cli2, e2);
				Pedido ped7 = new Pedido(null, sdf.parse("10/10/2017 12:35"), cli2, e2);
				Pedido ped8 = new Pedido(null, sdf.parse("10/10/2017 13:35"), cli2, e2);
				
				Pedido ped9 = new Pedido(null, sdf.parse("10/10/2017 13:35"), cli3, e2);
				//criando pagamentos
				Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
				Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
				
				//criando itens de pedido
				ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
				ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
				ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
				ItemPedido ip4 = new ItemPedido(ped9, p2, 100.00, 1, 1000.00);
				
				//adicionando enderecos aos clientes
				cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
				cli2.getEnderecos().addAll(Arrays.asList(e3));
				
				//adicionando telefones aos clientes
				cli1.getTelefones().addAll(Arrays.asList("4575-8741", "4475-8574"));
				cli2.getTelefones().addAll(Arrays.asList("8888-8888", "9999-9999"));
				
				//adicionando cidades aos estados
				est1.getCidades().addAll(Arrays.asList(c1));
				est2.getCidades().addAll(Arrays.asList(c2, c3));
				
				//adicionando produtos as categorias
				cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
				cat2.getProdutos().addAll(Arrays.asList(p2, p4));
				cat3.getProdutos().addAll(Arrays.asList(p5, p6));
				cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
				cat5.getProdutos().addAll(Arrays.asList(p8));
				cat6.getProdutos().addAll(Arrays.asList(p9, p10));
				cat7.getProdutos().addAll(Arrays.asList(p11));
				
				//adicioanando categorias aos produtos
				p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
				p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
				p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
				p4.getCategorias().addAll(Arrays.asList(cat2));
				p5.getCategorias().addAll(Arrays.asList(cat3));
				p6.getCategorias().addAll(Arrays.asList(cat3));
				p7.getCategorias().addAll(Arrays.asList(cat4));
				p8.getCategorias().addAll(Arrays.asList(cat5));
				p9.getCategorias().addAll(Arrays.asList(cat6));
				p10.getCategorias().addAll(Arrays.asList(cat6));
				p11.getCategorias().addAll(Arrays.asList(cat7));

				
				//misc
				
				cli2.addPerfil(Perfil.ADMIN);
				ped1.setPagamento(pagto1);
				ped2.setPagamento(pagto2);
				cli1.getPedidos().addAll(Arrays.asList(ped1, ped2, ped3, ped4, ped5));
				cli2.getPedidos().addAll(Arrays.asList(ped6, ped7, ped8));
				cli3.getPedidos().addAll(Arrays.asList(ped6, ped7, ped8));
				ped1.getItens().addAll(Arrays.asList(ip1, ip2));
				ped2.getItens().addAll(Arrays.asList(ip3));
				p1.getItens().addAll(Arrays.asList(ip1));
				p2.getItens().addAll(Arrays.asList(ip3));
				p3.getItens().addAll(Arrays.asList(ip2));
				ped9.getItens().addAll(Arrays.asList(ip4));
				
				
				//jogando no BD
				categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
				produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
				estadoRepository.saveAll(Arrays.asList(est1, est2));
				cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
				clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
				enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
				pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4, ped5, ped6,ped7,ped8, ped9));
				pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
				itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
	}
}
