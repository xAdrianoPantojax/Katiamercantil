package com.katiamercantil.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.katiamercantil.dto.ClienteDTO;
import com.katiamercantil.dto.ClienteUpdateDTO;
import com.katiamercantil.model.Cliente;
import com.katiamercantil.model.Endereco;
import com.katiamercantil.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PasswordEncoder encoder;

	public ResponseEntity<Object> cadastrarCliente(ClienteDTO clienteDTO) {
		var cliente = new Cliente();
		var endereco = new Endereco();
		BeanUtils.copyProperties(clienteDTO, cliente);
		BeanUtils.copyProperties(clienteDTO.getEndereco(), endereco);
		cliente.setStatus(true);
		cliente.setSenha(encoder.encode(cliente.getSenha()));
		cliente.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
	}

	public ResponseEntity<Cliente> atualizarCliente(ClienteUpdateDTO clienteDTO) {
		var cliente = clienteRepository.getReferenceById(clienteDTO.getId());
		cliente.updateInfo(clienteDTO);
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
