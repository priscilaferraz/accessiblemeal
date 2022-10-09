package br.com.fiap.accessiblemealapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.accessiblemealapi.model.Cliente;
import br.com.fiap.accessiblemealapi.model.Restaurante;
import br.com.fiap.accessiblemealapi.repository.ClienteRepository;
import br.com.fiap.accessiblemealapi.repository.RestauranteRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @Override
    public void run(String... args) throws Exception {

        clienteRepository.save( 
            new Cliente(
                "Mariana Alves",
                "456.098.654-45", 
                "mari@gmail.com",
                "123",
                "Av Cantareira, 1010"
            )
        );    

            clienteRepository.save( 
            new Cliente(
                "Amanda Silva",
                "456.098.654-80", 
                "admin@fiap.com.br",
                "127",
                "Av Cantareira, 1010"
            )
        );

        restauranteRepository.saveAll(List.of(
            new Restaurante(
                "Meals Ltda",
                "17.987.765/0001-32",
                "meals@gmail.com",
                "(11) 6543-7634",
                "Rua Horace Clark, 45",
                "Deficiência visual"
            ),
            new Restaurante(
                "Cantareira Ltda",
                "10.876.456/0002-23",
                "cantareira@gmail.com",
                "(11) 8743-2345",
                "Rua Orlando de Morais, 1010",
                "Deficiência mental"
            ),
            new Restaurante(
                "Food True",
                "54.098.654/0001-67",
                "food@gmail.com",
                "(11) 5498-3456",
                "Av Nazaréh, 2456",
                "Deficiência motora"
            ),
            new Restaurante(
                "Saborosos Pratos Ltda",
                "87.543.765/0001-43",
                "saborosos@gmail.com",
                "(11) 2345-8765",
                "Av Santos Silva, 81",
                "Deficiência auditiva"
            )
        ));
    }
    
}
