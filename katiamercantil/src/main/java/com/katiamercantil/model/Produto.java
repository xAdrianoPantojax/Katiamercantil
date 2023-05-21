package com.katiamercantil.model;

import com.katiamercantil.dto.ProdutoUpdateDTO;
import com.katiamercantil.enums.Departamento;

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

	public void updateInfo(ProdutoUpdateDTO produtoUpdateDTO) {
		if (produtoUpdateDTO.getCodigo()!= null) {
			this.codigo = produtoUpdateDTO.getCodigo();
		}

		if (produtoUpdateDTO.getDescricao() != null) {
			this.descricao = produtoUpdateDTO.getDescricao();
		}

		if (produtoUpdateDTO.getDataEntrada() != null) {
			this.dataEntrada = produtoUpdateDTO.getDataEntrada();
		}

		if (produtoUpdateDTO.getValidade() != null) {
			this.validade = produtoUpdateDTO.getValidade();
		}

		if (produtoUpdateDTO.getVolume() != null) {
			this.volume = produtoUpdateDTO.getVolume();
		}

		if (produtoUpdateDTO.getQuantidade() != null) {
			this.quantidade = produtoUpdateDTO.getQuantidade();
		}

		if (produtoUpdateDTO.getPrecoCusto() != null) {
			this.precoCusto = produtoUpdateDTO.getPrecoCusto();
		}

		if (produtoUpdateDTO.getPrecoVenda() != null) {
			this.precoVenda = produtoUpdateDTO.getPrecoVenda();
		}

		if (produtoUpdateDTO.getMarca() != null) {
			this.marca = produtoUpdateDTO.getMarca();
		}

		if (produtoUpdateDTO.getDepartamento() != null) {
			this.departamento = produtoUpdateDTO.getDepartamento();
		}

		if (produtoUpdateDTO.getPrateleira() != null) {
			this.prateleira = produtoUpdateDTO.getPrateleira();
		}
	}


}
