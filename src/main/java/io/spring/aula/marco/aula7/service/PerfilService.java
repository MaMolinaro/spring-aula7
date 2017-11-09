/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.aula.marco.aula7.service;

import io.spring.aula.marco.aula7.entity.Perfil;
import io.spring.aula.marco.aula7.repository.PerfilRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarcoAurelio
 */
@Service
public class PerfilService {
    
    @Autowired
    PerfilRepository perfilRepository;
    
    public List<Perfil> listarPerfil() {
        return perfilRepository.findAll();
    }
    
    public Perfil salvarPerfil(Perfil perfilAdd) {
        return perfilRepository.save(perfilAdd);
    } 
    
    public void deletarPerfil(String id) {
        perfilRepository.delete(id);
    }
    
    public Perfil getById(String id) {
        return perfilRepository.findOne(id);
    }
    
    public Page<Perfil> listaPaginada(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return perfilRepository.findAll(pages);
    }
    
    public List<Perfil> buscaPorNome(String nome) {
        return perfilRepository.findByNomeLikeIgnoreCase(nome);
    }
}
