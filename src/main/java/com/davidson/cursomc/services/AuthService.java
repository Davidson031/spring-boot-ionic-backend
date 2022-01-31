package com.davidson.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.davidson.cursomc.domain.Cliente;
import com.davidson.cursomc.repositories.ClienteRepository;
import com.davidson.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	
	
	

	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if(cliente==null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		
		
		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		
		char[] vet = new char[10];
		
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		
		return new String(vet);
					
	}

	private char randomChar() {
		
		int opt = rand.nextInt(3);
		
		if(opt==0) { //DIGITO
			return (char)(rand.nextInt(10)+48);
		}
		else if(opt==1) { //MAIUSCULA
			return (char)(rand.nextInt(26)+65);
		}
		else { //MINUSCULA
			return (char)(rand.nextInt(26)+97);
		}
	
	
	}
	
	
	

}
