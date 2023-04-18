package com.katiamercantil.dto;

import java.util.Date;

import com.katiamercantil.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	
	private String nome;
	
	private String sobrenome;
	
	private String cpfCnpj;
	
	private String sexo;
	
	private Date dataNascimento;
	
	private String email;
	
	private String senha;
	 
	private String telefone;
	
	private Boolean status;
	
	private String cep;
	
	private Endereco endereco;
	
	private String numero;
	
	private String complemento;
}
