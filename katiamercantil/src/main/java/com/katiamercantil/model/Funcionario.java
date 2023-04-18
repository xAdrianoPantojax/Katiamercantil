package com.katiamercantil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
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
	
	private String setor;
	
	private String email;
	
	private String senha;
	
	private String telefone;
	
	private String celular;
	
	private Boolean status;
	
	private Long administrador;
	
	@OneToOne
	private Endereco endereco;
}
