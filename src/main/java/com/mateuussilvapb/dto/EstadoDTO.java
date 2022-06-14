package com.mateuussilvapb.dto;

import java.io.Serializable;

import com.mateuussilvapb.domain.Estado;

//=============================================================//
public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// =============================================================//
	private Integer id;

	// =============================================================//
	private String nome;

	// =============================================================//
	private String sigla;

	// =============================================================//
	public EstadoDTO() {
	}

	// =============================================================//
	public EstadoDTO(Estado obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sigla = obj.getSigla();
	}

	// =============================================================//
	public Integer getId() {
		return id;
	}

	// =============================================================//
	public void setId(Integer id) {
		this.id = id;
	}

	// =============================================================//
	public String getNome() {
		return nome;
	}

	// =============================================================//
	public void setNome(String nome) {
		this.nome = nome;
	}

	// =============================================================//
	public String getSigla() {
		return sigla;
	}

	// =============================================================//
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
