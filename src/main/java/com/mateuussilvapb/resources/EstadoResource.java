package com.mateuussilvapb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.domain.Estado;
import com.mateuussilvapb.dto.CidadeDTO;
import com.mateuussilvapb.dto.EstadoDTO;
import com.mateuussilvapb.services.CidadeService;
import com.mateuussilvapb.services.EstadoService;

//=============================================================//
@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	// =============================================================//
	@Autowired
	private EstadoService estadoService;

	// =============================================================//
	@Autowired
	private CidadeService cidadeService;

	// =============================================================//
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> estados = estadoService.findAll();
		List<EstadoDTO> estadosDto = estados.stream().map(t -> new EstadoDTO(t)).collect(Collectors.toList());
		return ResponseEntity.ok().body(estadosDto);
	}

	// =============================================================//
	@RequestMapping(value = "/{estadoId}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> cidades = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> cidadesDto = cidades.stream().map(c -> new CidadeDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(cidadesDto);
	}
}
