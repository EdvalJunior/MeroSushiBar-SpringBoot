package com.spring.br.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.br.models.PedidoManager;

@Repository
public interface PedidoManagerRepository extends JpaRepository<PedidoManager, Long> {


}
