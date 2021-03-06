/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.aula.marco.aula7.controller;

import io.spring.aula.marco.aula7.entity.Perfil;
import io.spring.aula.marco.aula7.service.PerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarcoAurelio
 */
@RestController
public class PerfilController {
    
    @Autowired
    PerfilService perfilService;
    
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public List<Perfil> listaPerfil() {
        return this.perfilService.listarPerfil();
    }
    
    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public Perfil salvarPerfil(@RequestBody Perfil perfil) {
        return this.perfilService.salvarPerfil(perfil);
    }
    
    @RequestMapping(value = "/perfil", method = RequestMethod.PUT)
    public Perfil editarPerfil(@RequestBody Perfil perfil) {
        return this.perfilService.salvarPerfil(perfil);
    }
    
    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
    public void deletarPerfil(@PathVariable String id) {
        this.perfilService.deletarPerfil(id);
    }
    
    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public Perfil consultarPerfil(@PathVariable String id) {
        return this.perfilService.getById(id);
    }
    
    @RequestMapping(value="perfil/{page}/{count}", method = RequestMethod.GET)
    public Page<Perfil> listaPaginada(@PathVariable int page, @PathVariable int count) {
        return this.perfilService.listaPaginada(page, count);
    }
    
    @RequestMapping(value = "/perfil/{nome}/nome", method = RequestMethod.GET)
    public List<Perfil> buscaPorNome(@PathVariable String nome) {
        return this.perfilService.buscaPorNome(nome);
    }
}
