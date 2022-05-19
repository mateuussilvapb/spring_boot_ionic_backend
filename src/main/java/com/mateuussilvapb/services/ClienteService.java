package com.mateuussilvapb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.domain.Cliente;
import com.mateuussilvapb.domain.Endereco;
import com.mateuussilvapb.domain.enums.TipoCliente;
import com.mateuussilvapb.dto.ClienteDTO;
import com.mateuussilvapb.dto.ClienteNewDTO;
import com.mateuussilvapb.repositories.ClienteRepository;
import com.mateuussilvapb.repositories.EnderecoRepository;
import com.mateuussilvapb.services.exeptions.DataIntegrityException;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

//=============================================================//
@Service
public class ClienteService {

	// =============================================================//
	@Autowired
	private ClienteRepository clienteRepository;

	// =============================================================//
	@Autowired
	private EnderecoRepository enderecoRepository;

	// =============================================================//
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// =============================================================//
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	// =============================================================//
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	// =============================================================//
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	// =============================================================//
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		newObj = updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}

	// =============================================================//
	private Cliente updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		return newObj;
	}

	// =============================================================//
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um Cliente com entidades relacionadas.");
		}
	}

	// =============================================================//
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = clienteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	// =============================================================//
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
	}

	// =============================================================//
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				TipoCliente.toEnum(objDto.getTipo()), bCryptPasswordEncoder.encode(objDto.getSenha()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());

		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

}
