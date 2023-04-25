package com.katiamercantil.model;

import com.katiamercantil.enums.Departamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Long id;

	private String codigo;

	private String descricao;

	private String dataEntrada;

	private String validade;

	private String volume;

	private Float quantidade;

	private Double precoCusto;

	private Double precoVenda;

	private String marca;

	@Enumerated
	private Departamento departamento;

	private Long prateleira;

}
