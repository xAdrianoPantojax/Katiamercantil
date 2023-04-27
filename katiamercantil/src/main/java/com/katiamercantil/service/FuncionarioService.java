package com.katiamercantil.service;

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

import com.katiamercantil.dto.EnderecoDTO;
import com.katiamercantil.dto.FuncionarioDTO;
import com.katiamercantil.model.Endereco;
import com.katiamercantil.model.Funcionario;
import com.katiamercantil.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public ResponseEntity<Object> cadastrarFuncionario(FuncionarioDTO funcionarioDTO){
		var funcionario = new Funcionario();
		var endereco = new Endereco();
		RestTemplate resteTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/" + funcionarioDTO.getCep() + "/json/";
		Map<String, String> params = new HashMap<String,String>();
		EnderecoDTO enderecoDTO = resteTemplate.getForObject(uri, EnderecoDTO.class, params);
		BeanUtils.copyProperties(enderecoDTO, endereco);
		BeanUtils.copyProperties(funcionarioDTO, funcionario);
		endereco.setComplemento(funcionarioDTO.getComplemento());
		endereco.setNumero(funcionarioDTO.getNumero());
		funcionario.setEndereco(endereco);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
	}
	
	public ResponseEntity<Funcionario> atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO){
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
		var funcionario = funcionarioOptional.get();
		var endereco = new Endereco();
		funcionario.setNome(funcionarioDTO.getNome());
		funcionario.setSobrenome(funcionarioDTO.getSobrenome());
		funcionario.setCpf(funcionarioDTO.getCpf());
		funcionario.setRg(funcionarioDTO.getRg());
		funcionario.setSexo(funcionarioDTO.getSexo());
		funcionario.setDataRecisao(funcionarioDTO.getDataRecisao());
		funcionario.setCargo(funcionario.getCargo());
		funcionario.setSetor(funcionario.getSetor());
		funcionario.setEmail(funcionarioDTO.getEmail());
		funcionario.setSenha(funcionarioDTO.getSenha());
		funcionario.setTelefone(funcionarioDTO.getTelefone());
		funcionario.setCelular(funcionarioDTO.getCelular());
		funcionario.setStatus(funcionarioDTO.getStatus());
		funcionario.setAdministrador(funcionarioDTO.getAdministrador());
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/" + funcionarioDTO.getCep() + "/json/";
		Map<String, String> params = new HashMap<String, String>();
		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
		BeanUtils.copyProperties(enderecoDTO, endereco);
		endereco.setComplemento(funcionarioDTO.getComplemento());
		endereco.setNumero(funcionarioDTO.getNumero());
		funcionario.setEndereco(endereco);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
	}
	
	public ResponseEntity<List<Funcionario>> listarFuncionarios() {
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findAll());
	}
	
	public void deletarFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}
}
