package com.katiamercantil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katiamercantil.dto.FuncionarioDTO;
import com.katiamercantil.model.Funcionario;
import com.katiamercantil.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioServivce;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
		return funcionarioServivce.cadastrarFuncionario(funcionarioDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public void atualizarCliente(@PathVariable("id") Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
		funcionarioServivce.atualizarFuncionario(id, funcionarioDTO);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Funcionario>> listarFuncionarios(){
		return funcionarioServivce.listarFuncionarios();
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarCliente(@PathVariable("id") Long id) {
		funcionarioServivce.deletarFuncionario(id);
	}
}
