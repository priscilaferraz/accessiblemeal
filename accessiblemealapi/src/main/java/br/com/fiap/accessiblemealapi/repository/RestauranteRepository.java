package br.com.fiap.accessiblemealapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.accessiblemealapi.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("select u from Restaurante u where u.acessibilidade like %?1%")
    List<Restaurante> findByAcessibilidade(String acessibilidade);
}
