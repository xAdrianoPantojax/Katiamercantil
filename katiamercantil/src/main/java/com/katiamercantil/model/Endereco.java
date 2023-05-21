package com.katiamercantil.model;

import com.katiamercantil.dto.EnderecoDTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data 
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private String localidade;

	private String uf;

	private String numero;

    public void updateInfoEnd(EnderecoDTO endereco) {
    
		if (endereco.getCep() != null) {
			this.cep = endereco.getCep();
		}

		if (endereco.getLogradouro() != null) {
			this.logradouro = endereco.getLogradouro();
		}

		if (endereco.getComplemento() != null) {
			this.complemento = endereco.getComplemento();
		}

		if (endereco.getBairro() != null) {
			this.bairro = endereco.getBairro();
		}
		
		if (endereco.getLocalidade() != null) {
			this.localidade = endereco.getLocalidade();
		}

		if (endereco.getUf() != null) {
			this.uf = endereco.getUf();
		}

		if (endereco.getNumero() != null) {
			this.numero = endereco.getNumero();
		}
	}
}
