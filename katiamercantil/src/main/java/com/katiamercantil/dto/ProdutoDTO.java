package com.katiamercantil.dto;

import com.katiamercantil.enums.Departamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
	
	private String codigo;
	
	private String descricao;
	
	private String dataEntrada;
	
	private String validade;
	
	private String volume;
	
	private Float quantidade;
	
	private Double precoCusto;
	
	private Double precoVenda;
	
	private String marca;
	
	private Long prateleira;
	
	private Departamento departamento;
}
