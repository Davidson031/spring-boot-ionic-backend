package com.davidson.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.davidson.cursomc.domain.Categoria;
import com.davidson.cursomc.repositories.CategoriaRepository;
import com.davidson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar (Integer id) { 
		
		Optional<Categoria> obj = repo.findById(id); 
		
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
	} 

}
