package com.katiamercantil.dto;

import com.katiamercantil.model.Endereco;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private String rg;
	
	private String sexo;
	 
	private String dataNasc;
	
	private String dataAdmissao;
	
	private String dataRecisao;
	
	private String cargo;
	
	private String setor;
	
	private String email;
	
	private String senha;
	
	private String telefone;
	
	private String celular;
	
	private Boolean status;
	
	private Boolean administrador;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
	
	@OneToOne
	private Endereco endereco;
}
