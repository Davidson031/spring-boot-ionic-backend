package com.davidson.cursomc.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.davidson.cursomc.domain.Pedido;
import com.davidson.cursomc.services.PedidoService;






@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	PedidoService service;
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.POST) //1)END POINT É ACIONADO
	public ResponseEntity<Void>insert(@Valid @RequestBody Pedido obj){ //1.1 RECEBE O CORPO DO JSON E MAPEIA OS CAMPOS EM UM Pedido obj
		
		obj = service.insert(obj); //2 INICIA PROCESSO DE INSERÇÃO DE PEDIDO (PedidoService.java)
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	
	
	
	public ResponseEntity<List<Pedido>> findPage(
			//public ResponseEntity<Page<Pedido>> findPage(
					@RequestParam(value="page", defaultValue="0")Integer page, 
					@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
					@RequestParam(value="orderBy", defaultValue="instante")String orderBy, 
					@RequestParam(value="direction", defaultValue="DESC")String direction) {
				
				//Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);
				List<Pedido> list = service.findPage();
				
				return ResponseEntity.ok().body(list);
			}

	
	
	
}
