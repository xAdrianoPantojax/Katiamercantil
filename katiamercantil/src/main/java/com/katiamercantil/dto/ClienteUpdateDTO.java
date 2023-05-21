package com.katiamercantil.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteUpdateDTO {
    
    private Long id;

	private String nome;
	
	private String sobrenome;
	
	private String cpfCnpj;
	
	private String sexo;
	
	private Date dataNascimento;
	
	private String email;
	
	private String senha;
	
    private String telefone;
	
	private Boolean status;
	
	private EnderecoDTO endereco;

}
