package com.mateuussilvapb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.domain.Estado;
import com.mateuussilvapb.repositories.EstadoRepository;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

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

	// =============================================================//
	public Estado findBySigla(String sigla) {
		return estadoRepository.findBySigla(sigla);
	}

	// =============================================================//
	public Estado update(Integer estadoId, Integer cidadeId) {
		Estado newObj = find(estadoId);
		newObj = updateCidades(newObj, cidadeId);
		return estadoRepository.save(newObj);
	}

	// =============================================================//
	private Estado updateCidades(Estado newObj, Integer cidadeId) {
		Cidade cidade = new Cidade(cidadeId, null, null);
		newObj.getCidades().add(cidade);
		return newObj;
	}

	// =============================================================//
	public Estado find(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Estado.class.getName()));
	}
}
