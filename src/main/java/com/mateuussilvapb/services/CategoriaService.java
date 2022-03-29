package com.mateuussilvapb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Categoria;
import com.mateuussilvapb.repositories.CategoriaRepository;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	// ---------------------------------------------------------
	@Autowired
	private CategoriaRepository repo;

	// ---------------------------------------------------------
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	// ---------------------------------------------------------
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// ---------------------------------------------------------
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
