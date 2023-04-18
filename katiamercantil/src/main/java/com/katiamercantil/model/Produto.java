package com.katiamercantil.model;

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
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int id;
	
	private String codigo;
	
	private String descricao;
	
	private String dataEntrada;
	
	private String validade;
	
	private String volume;
	
	private Float quantidade;
	
	private String marca;
	
	private int prateleira;
	
	@ManyToOne
	private Departamento departamento;
}
