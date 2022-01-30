package com.davidson.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.davidson.cursomc.domain.Cliente;
import com.davidson.cursomc.domain.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Transactional(readOnly=true)
	//Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
	//List<Pedido> findByCliente(Cliente cliente);
	List<Pedido> findByCpf(String cpf);


}
