package br.com.fiap.accessiblemealapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.accessiblemealapi.model.Restaurante;
import br.com.fiap.accessiblemealapi.repository.RestauranteRepository;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository repository;

    public List<Restaurante> listAll() {
        return repository.findAll();
    }

    public void save(Restaurante restaurante) {
        repository.save(restaurante);
    } 

    public Optional<Restaurante> getById(Long id) {
        return repository.findById(id);
    }

    public List<Restaurante> findByAcessibilidade(String acessibilidade) {
        return repository.findByAcessibilidade(acessibilidade);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
