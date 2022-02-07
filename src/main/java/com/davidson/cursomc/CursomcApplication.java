package com.davidson.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
import com.davidson.cursomc.services.S3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		
	}

}



