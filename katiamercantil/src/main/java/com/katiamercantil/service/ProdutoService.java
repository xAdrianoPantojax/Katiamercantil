package com.katiamercantil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.katiamercantil.dto.ProdutoDTO;
import com.katiamercantil.dto.ProdutoUpdateDTO;
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
	
	public ResponseEntity<Produto> atualizarProduto(ProdutoUpdateDTO produtoDTO){
		var produto = produtoRepository.getReferenceById(produtoDTO.getId());
		produto.updateInfo(produtoDTO);
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}

	public ResponseEntity<List<Produto>> listarProdutor() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
	}

	public ResponseEntity<Produto> buscarProdutoById(Long id){
		Optional<Produto> produto = produtoRepository.findById(id);
		return new ResponseEntity<Produto>(produto.get(),HttpStatus.OK);

	}
	public void deletarCliente(Long id) {
		produtoRepository.deleteById(id);
	}
}
