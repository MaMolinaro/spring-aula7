/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.aula.marco.aula7.service;

import io.spring.aula.marco.aula7.entity.Usuario;
import io.spring.aula.marco.aula7.repository.UsuarioRepository;
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
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }
    
    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    } 
    
    public void deletarUsuario(String id) {
        usuarioRepository.delete(id);
    }
    
    public Usuario getById(String id) {
        return usuarioRepository.findOne(id);
    }
    
    public Page<Usuario> listaPaginada(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return usuarioRepository.findAll(pages);
    }
    
    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }
}
