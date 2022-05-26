package com.mateuussilvapb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Estado;
import com.mateuussilvapb.repositories.EstadoRepository;

//=============================================================//
@Service
public class EstadoService {

	// =============================================================//
	@Autowired
	private EstadoRepository estadoRepository;

	// =============================================================//
	public List<Estado> findAll() {
		return estadoRepository.findAllByOrderByNome();
	}
}
