package com.mateuussilvapb.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Cliente;
import com.mateuussilvapb.repositories.ClienteRepository;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

//=============================================================//
@Service
public class AuthService {

	// =============================================================//
	@Autowired
	private ClienteRepository clienteRepository;

	// =============================================================//
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// =============================================================//
	@Autowired
	private EmailService emailService;

	// =============================================================//
	private Random rand = new Random();

	// =============================================================//
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			StringBuilder builder = new StringBuilder();
			builder.append("Email: \'");
			builder.append(email);
			builder.append("\' não encontrado.");
			throw new ObjectNotFoundException(builder.toString());
		}
		String newPass = newPassword();
		cliente.setSenha(bCryptPasswordEncoder.encode(newPass));
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);

	}

	// =============================================================//
	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	// =============================================================//
	private char randomChar() {
		int opt = rand.nextInt(4);
		if (opt == 0) { // Gera um dígito
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) { // Gera uma letra maiúscula
			return (char) (rand.nextInt(26) + 65);
		} else if (opt == 2) { // Gera letra minúscula
			return (char) (rand.nextInt(26) + 97);
		} else {
			return (char) (rand.nextInt(15) + 33);
		}
	}
}
