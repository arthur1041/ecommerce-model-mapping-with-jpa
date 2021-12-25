package com.artcruz.ecommerce.mapeamentobasico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.artcruz.ecommerce.EntityManagerTest;
import com.artcruz.ecommerce.model.EnderecoEntregaPedido;
import com.artcruz.ecommerce.model.Pedido;
import com.artcruz.ecommerce.model.StatusPedido;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest{

	@Test
	public void analisarMapeamentoObjetoEmbutido() {
		EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
		
		endereco.setCep("59594-000");
		endereco.setLogradouro("seila");
		endereco.setBairro("Centro");
		endereco.setNumero("10");
		endereco.setCidade("Fim do mudo");
		endereco.setEstado("RN");
		
		Pedido pedido = new Pedido();
		pedido.setId(1);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(1000));
		pedido.setEnderecoEntrega(endereco);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerificacao);
		Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
		Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
	}
	
}
