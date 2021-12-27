package com.davidson.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.davidson.cursomc.domain.Pedido;
import com.davidson.cursomc.repositories.PedidoRepository;
import com.davidson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	
	public Pedido buscar (Integer id) { 
		
		Optional<Pedido> obj = repo.findById(id); 
		
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
	} 

}
