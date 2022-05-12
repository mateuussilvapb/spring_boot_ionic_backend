package com.mateuussilvapb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Categoria;
import com.mateuussilvapb.domain.Produto;
import com.mateuussilvapb.repositories.CategoriaRepository;
import com.mateuussilvapb.repositories.ProdutoRepository;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	// ---------------------------------------------------------
	@Autowired
	private ProdutoRepository produtoRepository;

	// ---------------------------------------------------------
	@Autowired
	private CategoriaRepository categoriaRepository;

	// ---------------------------------------------------------
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Produto.class.getName()));
	}

	// ---------------------------------------------------------
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);

	}
}
