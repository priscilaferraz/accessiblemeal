package br.com.fiap.accessiblemealapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.accessiblemealapi.model.Restaurante;
import br.com.fiap.accessiblemealapi.service.RestauranteService;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @GetMapping
    public List<Restaurante> index(@RequestParam(required = false) String acessibilidade) {
        if (acessibilidade != null) {
            return service.findByAcessibilidade(acessibilidade);
        }
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Restaurante> create(@Valid @RequestBody Restaurante restaurante) {
        service.save(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurante> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "restaurante", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Restaurante> update(@PathVariable Long id, @RequestBody Restaurante newRestaurante){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        var restaurante = optional.get();
        BeanUtils.copyProperties(newRestaurante, restaurante);
        restaurante.setId(id);
        service.save(restaurante);
        return ResponseEntity.ok(restaurante);
    }    
}
