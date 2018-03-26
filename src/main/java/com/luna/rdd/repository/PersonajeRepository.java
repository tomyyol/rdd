package com.luna.rdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luna.rdd.Personaje;

@RepositoryRestResource
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {

}
