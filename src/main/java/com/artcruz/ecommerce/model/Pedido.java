package com.artcruz.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;
	
	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;
	
	@Column(name = "nota_fiscal_id")
	private Integer notaFiscalId;
	
	private BigDecimal total;
	
	private Integer quantidade;
	
	@Enumerated(value = EnumType.STRING)
	private StatusPedido status;
	
	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;
}

