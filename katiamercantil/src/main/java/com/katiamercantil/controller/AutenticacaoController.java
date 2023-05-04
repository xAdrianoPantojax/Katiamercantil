package com.katiamercantil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katiamercantil.dto.ClienteDTO;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody ClienteDTO dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
		var authentication = manager.authenticate(token);
		return ResponseEntity.ok().build();
	}
}
