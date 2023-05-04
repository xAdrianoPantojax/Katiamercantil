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
import com.katiamercantil.model.Cliente;
import com.katiamercantil.security.DadosTokenJWTDTO;
import com.katiamercantil.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody ClienteDTO dados) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
		var authentication = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.gerarToken((Cliente) authentication.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJWTDTO(tokenJWT));
	}
}
