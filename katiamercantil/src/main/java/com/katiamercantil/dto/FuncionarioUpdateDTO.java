package com.katiamercantil.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioUpdateDTO {

	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private String rg;
	
	private String sexo;
	 
	private String dataNasc;
	
	private String dataAdmissao;
	
	private String dataRecisao;
	
	private String cargo;
	
	private String email;
	
	private String senha;
	
	private String celular;
	
	private Boolean status;
	
	private EnderecoDTO endereco;
}
