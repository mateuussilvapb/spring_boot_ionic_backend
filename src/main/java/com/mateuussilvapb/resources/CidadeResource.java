package com.mateuussilvapb.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.services.CidadeService;

//=============================================================//
@RestController
@RequestMapping(value = "/cidade")
public class CidadeResource {

	// =============================================================//
	@Autowired
	private CidadeService cidadeService;

	// =============================================================//
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cidade> insert(@Valid @RequestBody Cidade obj) {
		obj = cidadeService.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
}
