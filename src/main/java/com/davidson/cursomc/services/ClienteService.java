package com.davidson.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.davidson.cursomc.domain.Cliente;
import com.davidson.cursomc.repositories.ClienteRepository;
import com.davidson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	
	public Cliente buscar (Integer id) { 
		
		Optional<Cliente> obj = repo.findById(id); 
		
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
	} 

}
