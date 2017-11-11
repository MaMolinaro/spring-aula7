/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.aula.marco.aula7.repository;

import io.spring.aula.marco.aula7.entity.Perfil;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author MarcoAurelio
 */
public interface PerfilRepository extends MongoRepository<Perfil, String> {
    List<Perfil> findByNomeLikeIgnoreCase(String nome);
    Perfil findByNome(String nome);
}
