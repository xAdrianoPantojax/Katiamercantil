package com.katiamercantil.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.katiamercantil.dto.ClienteDTO;
import com.katiamercantil.dto.EnderecoDTO;
import com.katiamercantil.model.Cliente;
import com.katiamercantil.model.Endereco;
import com.katiamercantil.repository.ClienteRepository;
import com.katiamercantil.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public ResponseEntity<Object> cadastrarCliente(ClienteDTO clienteDTO) {
		var cliente = new Cliente();
		var endereco = new Endereco();
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/" + clienteDTO.getCep() + "/json/";
		Map<String, String> params = new HashMap<String, String>();
		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		BeanUtils.copyProperties(clienteDTO, cliente);
		BeanUtils.copyProperties(enderecoDTO, endereco);
		endereco.setComplemento(clienteDTO.getComplemento());
		endereco.setNumero(clienteDTO.getNumero());
		cliente.setEndereco(endereco);
		cliente.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		enderecoRepository.save(endereco);
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
	}

	public ResponseEntity<Cliente> atualizarCliente(Long id, ClienteDTO clienteDTO){
		var cliente = clienteRepository.findById(id).get();
		BeanUtils.copyProperties(clienteDTO, cliente);
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
	}
	
	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
