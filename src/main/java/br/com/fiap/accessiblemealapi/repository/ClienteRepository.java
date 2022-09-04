package br.com.fiap.accessiblemealapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.accessiblemealapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
