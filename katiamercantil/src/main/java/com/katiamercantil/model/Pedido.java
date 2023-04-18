package com.katiamercantil.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int id;
	
	private int numPedido;
	
	private LocalDateTime horaInicio;
	
	private String descricao;
	
	private Double quantidade;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Produto produto;
}
