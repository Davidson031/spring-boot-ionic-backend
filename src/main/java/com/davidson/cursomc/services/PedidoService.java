package com.davidson.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import com.davidson.cursomc.domain.ItemPedido;
import com.davidson.cursomc.domain.PagamentoComBoleto;
import com.davidson.cursomc.domain.Pedido;
import com.davidson.cursomc.domain.enums.EstadoPagamento;
import com.davidson.cursomc.repositories.ItemPedidoRepository;
import com.davidson.cursomc.repositories.PagamentoRepository;
import com.davidson.cursomc.repositories.PedidoRepository;
import com.davidson.cursomc.repositories.ProdutoRepository;
import com.davidson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	
	
	public Pedido find (Integer id) { 
		
		Optional<Pedido> obj = repo.findById(id); 
		
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
	} 
	
	
	public Pedido insert(Pedido obj) { //3) RECEBE UM OBJETO DO TIPO "Pedido" PARA SER CADASTRADO
		
		obj.setId(null); //3.1 PREPARANDO "Pedido" 
	
		obj.setInstante(new Date()); //3.2 PREPARANDO "Pedido" 
	
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE); //4) SETA O PAGAMENTO DO PEDIDO PARA PENDENTE
		
		obj.getPagamento().setPedido(obj); //5) SETA O PEDIDO DO PAGAMENTO
		
		if(obj.getPagamento() instanceof PagamentoComBoleto) { //6 CUIDA DA DATA DE VCTO DO PAGAMENTO CASO SEJA POR BOLETO
			
			PagamentoComBoleto pgto = (PagamentoComBoleto)obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());
		}
		
		
		
		obj = repo.save(obj); //7 SALVANDO PEDIDO NO BD 
		pagamentoRepository.save(obj.getPagamento()); //8 SALVANDO O PAGAMENTO NO BD
		
		
		
		for(ItemPedido ip: obj.getItens()) { //9) PERCORRE A LISTA DE ITENS DESSE PEDIDO
			
			ip.setDesconto(0.0); //9.1) SETA OS DESCONTOS P/ 0.
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco()); //9.2) ENCONTRA O PREÇO DE UM PRODUTO(PELO ID) USANDO PRODUTOSERVICE E O SETA NO ITEMPEDIDO.
			ip.setPedido(obj); //10) CADA ITEMPEDIDO TEM QUE SE REFERENCIAR A UM PEDIDO.
		}
		
		itemPedidoRepository.saveAll(obj.getItens()); //SALVANDO OS ITENSPEDIDOS NO BD.
		return obj; //RETORNA.
		
		
	}

}
