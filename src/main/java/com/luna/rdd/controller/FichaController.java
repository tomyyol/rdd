package com.luna.rdd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luna.rdd.exception.ResourceNotFoundException;
import com.luna.rdd.model.Ficha;
import com.luna.rdd.repository.FichaRepository;

@RestController
@RequestMapping("/api")
public class FichaController {

	@Autowired
	FichaRepository fichaRepository;
	
	// Get All Fichas
	@GetMapping("/fichas")
	public List<Ficha> getAllFichas() {
	    return fichaRepository.findAll();
	}
	
	// Create a new Ficha
	@PostMapping("/fichas")
	public Ficha createNote(@Valid @RequestBody Ficha ficha) {
	    return fichaRepository.save(ficha);
	}
	
	// Get a Single Ficha
	@GetMapping("/fichas/{id}")
	public Ficha getFichaById(@PathVariable(value = "id") Long fichaId) {
	    return fichaRepository.findById(fichaId).orElseThrow(() -> new ResourceNotFoundException("Ficha", "id", fichaId));
	}
	
	// Update a Note
	@PutMapping("/fichas/{id}")
	public Ficha updateNote(@PathVariable(value = "id") Long fichaId,
	                                        @Valid @RequestBody Ficha fichaDetails) {

	    Ficha ficha = fichaRepository.findById(fichaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Ficha", "id", fichaId));

	    ficha.setDescripcion(fichaDetails.getDescripcion());

	    Ficha updatedFicha = fichaRepository.save(ficha);
	    return updatedFicha;
	}
	
	// Delete a Note
	@DeleteMapping("/fichas/{id}")
	public ResponseEntity<?> deleteFicha(@PathVariable(value = "id") Long fichaId) {
	    Ficha ficha = fichaRepository.findById(fichaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Ficha", "id", fichaId));

	    fichaRepository.delete(ficha);

	    return ResponseEntity.ok().build();
	}
}
