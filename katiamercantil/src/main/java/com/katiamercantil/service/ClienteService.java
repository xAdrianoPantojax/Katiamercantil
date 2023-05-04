package com.katiamercantil.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

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
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
	}

	public ResponseEntity<Cliente> atualizarCliente(Long id, ClienteDTO clienteDTO) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		var cliente = clienteOptional.get();
		var endereco = new Endereco();
		cliente.setNome(clienteDTO.getNome());
		cliente.setSobrenome(clienteDTO.getSobrenome());
		cliente.setCpfCnpj(clienteDTO.getCpfCnpj());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setSenha(clienteDTO.getSenha());
		cliente.setTelefone(clienteDTO.getTelefone());
		cliente.setStatus(clienteDTO.getStatus());
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/" + clienteDTO.getCep() + "/json/";
		Map<String, String> params = new HashMap<String, String>();
		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		BeanUtils.copyProperties(enderecoDTO, endereco);
		endereco.setComplemento(clienteDTO.getComplemento());
		endereco.setNumero(clienteDTO.getNumero());
		cliente.setEndereco(endereco);
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
	}

	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
	}
	
	public ResponseEntity<Cliente> buscarClienteById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
