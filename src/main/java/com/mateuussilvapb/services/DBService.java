package com.mateuussilvapb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mateuussilvapb.domain.Categoria;
import com.mateuussilvapb.domain.Cidade;
import com.mateuussilvapb.domain.Cliente;
import com.mateuussilvapb.domain.Endereco;
import com.mateuussilvapb.domain.Estado;
import com.mateuussilvapb.domain.ItemPedido;
import com.mateuussilvapb.domain.Pagamento;
import com.mateuussilvapb.domain.PagamentoComBoleto;
import com.mateuussilvapb.domain.PagamentoComCartao;
import com.mateuussilvapb.domain.Pedido;
import com.mateuussilvapb.domain.Produto;
import com.mateuussilvapb.domain.enums.EstadoPagamento;
import com.mateuussilvapb.domain.enums.Perfil;
import com.mateuussilvapb.domain.enums.TipoCliente;
import com.mateuussilvapb.repositories.CategoriaRepository;
import com.mateuussilvapb.repositories.CidadeRepository;
import com.mateuussilvapb.repositories.ClienteRepository;
import com.mateuussilvapb.repositories.EnderecoRepository;
import com.mateuussilvapb.repositories.EstadoRepository;
import com.mateuussilvapb.repositories.ItemPedidoRepository;
import com.mateuussilvapb.repositories.PagamentoRepository;
import com.mateuussilvapb.repositories.PedidoRepository;
import com.mateuussilvapb.repositories.ProdutoRepository;

// =============================================================//
@Service
public class DBService {

	// =============================================================//
	@Autowired
	CategoriaRepository categoriaRepository;
	// =============================================================//
	@Autowired
	ProdutoRepository produtoRepository;
	// =============================================================//
	@Autowired
	CidadeRepository cidadeRepository;
	// =============================================================//
	@Autowired
	EstadoRepository estadoRepository;
	// =============================================================//
	@Autowired
	ClienteRepository clienteRepository;
	// =============================================================//
	@Autowired
	EnderecoRepository enderecoRepository;
	// =============================================================//
	@Autowired
	PedidoRepository pedidoRepository;
	// =============================================================//
	@Autowired
	PagamentoRepository pagamentoRepository;
	// =============================================================//
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	// =============================================================//
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void instantiateTestDatabase() throws ParseException {

		// =============================================================//
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		// =============================================================//
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		// =============================================================//
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		// =============================================================//
		Estado est1 = new Estado(null, "Acre", "AC");
		Estado est2 = new Estado(null, "Alagoas", "AL");
		Estado est3 = new Estado(null, "Amapá", "AP");
		Estado est4 = new Estado(null, "Amazonas", "AM");
		Estado est5 = new Estado(null, "Bahia", "BA");
		Estado est6 = new Estado(null, "Ceará", "CE");
		Estado est7 = new Estado(null, "Distrito Federal", "DF");
		Estado est8 = new Estado(null, "Espírito Santo", "ES");
		Estado est9 = new Estado(null, "Goiás", "GO");
		Estado est10 = new Estado(null, "Maranhão", "MA");
		Estado est11 = new Estado(null, "Mato Grosso", "MT");
		Estado est12 = new Estado(null, "Mato Grosso do Sul", "MS");
		Estado est13 = new Estado(null, "Minas Gerais", "MG");
		Estado est14 = new Estado(null, "Pará", "PA");
		Estado est15 = new Estado(null, "Paraíba", "PB");
		Estado est16 = new Estado(null, "Paraná", "PR");
		Estado est17 = new Estado(null, "Pernambuco", "PE");
		Estado est18 = new Estado(null, "Piauí", "PI");
		Estado est19 = new Estado(null, "Rio de Janeiro", "RJ");
		Estado est20 = new Estado(null, "Rio Grande do Norte", "RN");
		Estado est21 = new Estado(null, "Rio Grande do Sul", "RS");
		Estado est22 = new Estado(null, "Rondônia", "RO");
		Estado est23 = new Estado(null, "Roraima", "RR");
		Estado est24 = new Estado(null, "Santa Catarina", "SC");
		Estado est25 = new Estado(null, "São Paulo", "SP");
		Estado est26 = new Estado(null, "Sergipe", "SE");
		Estado est27 = new Estado(null, "Tocantins", "TO");
		// =============================================================//
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		// =============================================================//
		Cliente cli1 = new Cliente(null, "Maria Silva", "mateuussilvapb@gmail.com", "36378912377",
				TipoCliente.PESSOA_FISICA, bCryptPasswordEncoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Ana Costa", "mateus.dias@gmail.com", "33076574027", TipoCliente.PESSOA_FISICA,
				bCryptPasswordEncoder.encode("123"));
		// =============================================================//
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "38777011", cli2, c2);
		// =============================================================//
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		// =============================================================//
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		// =============================================================//
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		// =============================================================//
		cat1.getProdutos()
				.addAll(Arrays.asList(p1, p2, p3, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
						p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45,
						p46, p47, p48, p49, p50));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		// =============================================================//
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		p12.getCategorias().addAll(Arrays.asList(cat1));
		p13.getCategorias().addAll(Arrays.asList(cat1));
		p14.getCategorias().addAll(Arrays.asList(cat1));
		p15.getCategorias().addAll(Arrays.asList(cat1));
		p16.getCategorias().addAll(Arrays.asList(cat1));
		p17.getCategorias().addAll(Arrays.asList(cat1));
		p18.getCategorias().addAll(Arrays.asList(cat1));
		p19.getCategorias().addAll(Arrays.asList(cat1));
		p20.getCategorias().addAll(Arrays.asList(cat1));
		p21.getCategorias().addAll(Arrays.asList(cat1));
		p22.getCategorias().addAll(Arrays.asList(cat1));
		p23.getCategorias().addAll(Arrays.asList(cat1));
		p24.getCategorias().addAll(Arrays.asList(cat1));
		p25.getCategorias().addAll(Arrays.asList(cat1));
		p26.getCategorias().addAll(Arrays.asList(cat1));
		p27.getCategorias().addAll(Arrays.asList(cat1));
		p28.getCategorias().addAll(Arrays.asList(cat1));
		p29.getCategorias().addAll(Arrays.asList(cat1));
		p30.getCategorias().addAll(Arrays.asList(cat1));
		p31.getCategorias().addAll(Arrays.asList(cat1));
		p32.getCategorias().addAll(Arrays.asList(cat1));
		p33.getCategorias().addAll(Arrays.asList(cat1));
		p34.getCategorias().addAll(Arrays.asList(cat1));
		p35.getCategorias().addAll(Arrays.asList(cat1));
		p36.getCategorias().addAll(Arrays.asList(cat1));
		p37.getCategorias().addAll(Arrays.asList(cat1));
		p38.getCategorias().addAll(Arrays.asList(cat1));
		p39.getCategorias().addAll(Arrays.asList(cat1));
		p40.getCategorias().addAll(Arrays.asList(cat1));
		p41.getCategorias().addAll(Arrays.asList(cat1));
		p42.getCategorias().addAll(Arrays.asList(cat1));
		p43.getCategorias().addAll(Arrays.asList(cat1));
		p44.getCategorias().addAll(Arrays.asList(cat1));
		p45.getCategorias().addAll(Arrays.asList(cat1));
		p46.getCategorias().addAll(Arrays.asList(cat1));
		p47.getCategorias().addAll(Arrays.asList(cat1));
		p48.getCategorias().addAll(Arrays.asList(cat1));
		p49.getCategorias().addAll(Arrays.asList(cat1));
		p50.getCategorias().addAll(Arrays.asList(cat1));
		// =============================================================//
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		// =============================================================//
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli1.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("123654789", "987456321"));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		// =============================================================//
		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);
		// =============================================================//
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		// =============================================================//
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		// =============================================================//
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16,
				p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		estadoRepository.saveAll(
				Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10, est11, est12, est13, est14,
						est15, est16, est17, est18, est19, est20, est21, est22, est23, est24, est25, est26, est27));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
