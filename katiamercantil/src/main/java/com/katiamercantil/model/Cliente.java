package com.katiamercantil.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.katiamercantil.dto.ClienteUpdateDTO;

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
public class Cliente implements UserDetails{

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
	
	@JsonIgnore
	private String senha;
	 
	private String telefone;
	
	private Boolean status;
	
	@Embedded
	private Endereco endereco;


	public void updateInfo(ClienteUpdateDTO clienteUpdateDTO){
		
		if (clienteUpdateDTO.getNome()!= null) {
			this.nome = clienteUpdateDTO.getNome();
		}

		if (clienteUpdateDTO.getSobrenome() != null) {
			this.sobrenome = clienteUpdateDTO.getSobrenome();
		}

		if (clienteUpdateDTO.getCpfCnpj() != null) {
			this.cpfCnpj = clienteUpdateDTO.getCpfCnpj();
		}

		if (clienteUpdateDTO.getSexo() != null) {
			this.sexo = clienteUpdateDTO.getSexo();
		}

		if (clienteUpdateDTO.getTelefone() != null) {
			this.telefone = clienteUpdateDTO.getTelefone();
		}

		if (clienteUpdateDTO.getStatus() != null) {
			this.status = clienteUpdateDTO.getStatus();
		}

		if (clienteUpdateDTO.getEndereco() != null) {
			this.endereco.updateInfoEnd(clienteUpdateDTO.getEndereco());
		}
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	

	
}
