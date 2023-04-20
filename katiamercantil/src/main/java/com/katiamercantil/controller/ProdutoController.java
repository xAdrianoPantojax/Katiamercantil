package com.katiamercantil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katiamercantil.dto.ProdutoDTO;
import com.katiamercantil.model.Produto;
import com.katiamercantil.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO){
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.cadastrarProduto(produtoDTO));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Produto>> listarProduto(){
		return produtoService.listarProdutor();
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarCliente(@PathVariable("id") Long id) {
		produtoService.deletarCliente(id);
	}
}
