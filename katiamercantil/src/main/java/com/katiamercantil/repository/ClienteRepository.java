package com.katiamercantil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.katiamercantil.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	UserDetails findByEmail(String email);

}
