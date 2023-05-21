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
import com.katiamercantil.dto.FuncionarioUpdateDTO;
import com.katiamercantil.model.Funcionario;
import com.katiamercantil.service.FuncionarioService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
		return funcionarioService.cadastrarFuncionario(funcionarioDTO);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarCliente(@RequestBody FuncionarioUpdateDTO funcionarioDTO) {
		funcionarioService.atualizarFuncionario(funcionarioDTO);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Funcionario>> listarFuncionarios(){
		return funcionarioService.listarFuncionarios();
	}
	
	@GetMapping("/buscarporid/{id}")
	public ResponseEntity<Funcionario> buscarClienteById(@PathVariable("id")Long id){
		return funcionarioService.buscarFuncionarioById(id);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletarCliente(@PathVariable("id") Long id) {
		funcionarioService.deletarFuncionario(id);
	}
}
