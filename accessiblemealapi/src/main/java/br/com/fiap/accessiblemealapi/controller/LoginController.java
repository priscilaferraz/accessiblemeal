package br.com.fiap.accessiblemealapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.accessiblemealapi.model.Login;
import br.com.fiap.accessiblemealapi.service.ClienteService;

@RestController
@RequestMapping("/api/cliente/login")
public class LoginController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public HttpStatus login(@RequestBody Login login) {

        var optional = service.findByEmailAndSenha(login.getEmail(), login.getSenha());
        
        if(optional.isEmpty())
            return HttpStatus.UNAUTHORIZED;
        return HttpStatus.OK;
    }
}
