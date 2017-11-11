/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.aula.marco.aula7.repository;

import io.spring.aula.marco.aula7.entity.Usuario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author MarcoAurelio
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    List<Usuario> findByNomeLikeIgnoreCase(String nome);
    Usuario findByEmail(String email);
}
