package com.spring.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.br.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	 Cliente findByEmail(String email);

}
