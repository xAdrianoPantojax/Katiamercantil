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
import com.katiamercantil.model.Cliente;
import com.katiamercantil.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
		return clienteService.cadastrarCliente(clienteDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public void atualizarCliente(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) {
		clienteService.atualizarCliente(id, clienteDTO);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarCliente(){
		return clienteService.listarClientes();
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletarCliente(@PathVariable("id") Long id) {
		clienteService.deletarCliente(id);
	}
	
}
