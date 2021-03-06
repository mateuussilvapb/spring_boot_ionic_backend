package com.mateuussilvapb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.repositories.CidadeRepository;

//=============================================================//
@Service
public class CidadeService {

	// =============================================================//
	@Autowired
	private CidadeRepository cidadeRepository;

	// =============================================================//
	public List<Cidade> findByEstado(Integer estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}

	// =============================================================//
	public Cidade insert(Cidade obj) {
		obj.setId(null);
		obj = cidadeRepository.save(obj);
		return obj;
	}
}
