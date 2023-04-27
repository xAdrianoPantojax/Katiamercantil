package com.katiamercantil.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpfCnpj;
	
	private String sexo;
	
	private Date dataNascimento;
	
	private LocalDateTime dataRegistro;
	
	private String email;
	
	private String senha;
	 
	private String telefone;
	
	private Boolean status;
	
	@Embedded
	private Endereco endereco;
	
	
}
