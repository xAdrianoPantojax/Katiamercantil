package com.katiamercantil.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.katiamercantil.dto.ProdutoDTO;
import com.katiamercantil.model.Produto;
import com.katiamercantil.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public ResponseEntity<Object> cadastrarProduto(ProdutoDTO produtoDTO) {
		var produto = new Produto();
		BeanUtils.copyProperties(produtoDTO, produto);
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}

	public ResponseEntity<List<Produto>> listarProdutor() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
	}

	public void deletarCliente(Long id) {
		produtoRepository.deleteById(id);
	}
}
