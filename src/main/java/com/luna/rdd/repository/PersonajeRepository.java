package com.luna.rdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luna.rdd.model.Personaje;

@RepositoryRestResource
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

}
