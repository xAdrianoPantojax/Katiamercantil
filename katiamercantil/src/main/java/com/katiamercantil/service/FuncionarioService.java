package com.katiamercantil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.katiamercantil.dto.FuncionarioDTO;
import com.katiamercantil.dto.FuncionarioUpdateDTO;
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
		BeanUtils.copyProperties(funcionarioDTO, funcionario);
		BeanUtils.copyProperties(funcionarioDTO.getEndereco(), endereco);
		funcionario.setStatus(true);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
	}
	
	public ResponseEntity<Funcionario> atualizarFuncionario(FuncionarioUpdateDTO funcionarioDTO){
		var funcionario = funcionarioRepository.getReferenceById(funcionarioDTO.getId());
		funcionario.updateInfo(funcionarioDTO);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(funcionario));
	}
	
	public ResponseEntity<List<Funcionario>> listarFuncionarios() {
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findAll());
	}
	
	public ResponseEntity<Funcionario> buscarFuncionarioById(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
			return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);
		
	}

	public void deletarFuncionario(Long id) {
		funcionarioRepository.deleteById(id);
	}
}
