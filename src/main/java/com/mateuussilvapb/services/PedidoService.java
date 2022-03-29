package com.mateuussilvapb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Pedido;
import com.mateuussilvapb.repositories.PedidoRepository;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

@Service
public class PedidoService {

	// -----------------------------------------
	@Autowired
	private PedidoRepository repo;

	// -----------------------------------------
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
