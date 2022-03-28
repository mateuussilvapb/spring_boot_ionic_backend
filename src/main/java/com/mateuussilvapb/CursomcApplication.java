package com.mateuussilvapb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateuussilvapb.domain.Categoria;
import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.domain.Cliente;
import com.mateuussilvapb.domain.Endereco;
import com.mateuussilvapb.domain.Estado;
import com.mateuussilvapb.domain.Produto;
import com.mateuussilvapb.domain.enums.TipoCliente;
import com.mateuussilvapb.repositories.CategoriaRepository;
import com.mateuussilvapb.repositories.CidadeRepository;
import com.mateuussilvapb.repositories.ClienteRepository;
import com.mateuussilvapb.repositories.EnderecoRepository;
import com.mateuussilvapb.repositories.EstadoRepository;
import com.mateuussilvapb.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	// -----------------------------------------
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	// -----------------------------------------
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// -----------------------------------------
	@Override
	public void run(String... args) throws Exception {
		// -------------------------------------------------------------
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		// -------------------------------------------------------------
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		// -------------------------------------------------------------
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		// -------------------------------------------------------------
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		// -------------------------------------------------------------
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		// -------------------------------------------------------------
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		// -------------------------------------------------------------
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		// -------------------------------------------------------------
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		// -------------------------------------------------------------
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		// -------------------------------------------------------------
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		// -------------------------------------------------------------
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
