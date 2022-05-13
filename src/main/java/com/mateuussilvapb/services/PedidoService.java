package com.mateuussilvapb.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mateuussilvapb.domain.ItemPedido;
import com.mateuussilvapb.domain.PagamentoComBoleto;
import com.mateuussilvapb.domain.Pedido;
import com.mateuussilvapb.domain.enums.EstadoPagamento;
import com.mateuussilvapb.repositories.ItemPedidoRepository;
import com.mateuussilvapb.repositories.PagamentoRepository;
import com.mateuussilvapb.repositories.PedidoRepository;
import com.mateuussilvapb.services.exeptions.ObjectNotFoundException;

// ---------------------------------------------------------
@Service
public class PedidoService {

	// ---------------------------------------------------------
	@Autowired
	private PedidoRepository repo;

	// ---------------------------------------------------------
	@Autowired
	private BoletoService boletoService;

	// ---------------------------------------------------------
	@Autowired
	private PagamentoRepository pagamentoRepository;

	// ---------------------------------------------------------
	@Autowired
	private ProdutoService produtoService;

	// ---------------------------------------------------------
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	// ---------------------------------------------------------
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	// ---------------------------------------------------------
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
