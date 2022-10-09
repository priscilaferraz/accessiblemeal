package br.com.fiap.accessiblemealapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.accessiblemealapi.model.Cliente;
import br.com.fiap.accessiblemealapi.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<Cliente> listAll() {
        return repository.findAll();
    }

    public void save(Cliente cliente) {
        repository.save(cliente);
    } 

    public Optional<Cliente> getById(Long id) {
        return repository.findById(id);
    }
    
    public Optional<Cliente> findByEmailAndSenha(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }
}
