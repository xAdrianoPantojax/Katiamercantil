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

import com.katiamercantil.dto.ClienteDTO;
import com.katiamercantil.dto.ClienteUpdateDTO;
import com.katiamercantil.model.Cliente;
import com.katiamercantil.service.ClienteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Object> cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
		return clienteService.cadastrarCliente(clienteDTO);
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public void atualizarCliente(@RequestBody ClienteUpdateDTO clienteDTO) {
		clienteService.atualizarCliente(clienteDTO);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarCliente(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/buscarporid/{id}")
	public ResponseEntity<Cliente> buscarClienteById(@PathVariable("id")Long id){
		return clienteService.buscarClienteById(id);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarCliente(@PathVariable("id") Long id) {
		clienteService.deletarCliente(id);
	}
	
}
