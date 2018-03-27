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
import com.luna.rdd.model.Clase;
import com.luna.rdd.repository.ClaseRepository;

@RestController
@RequestMapping("/api")
public class ClaseController {

	@Autowired
	ClaseRepository claseRepository;
	
	// Get All Clases
	@GetMapping("/clases")
	public List<Clase> getAllFichas() {
	    return claseRepository.findAll();
	}
	
	// Create a new Clase
	@PostMapping("/clases")
	public Clase createNote(@Valid @RequestBody Clase clase) {
	    return claseRepository.save(clase);
	}
	
	// Get a Single Clase
	@GetMapping("/clases/{id}")
	public Clase getClaseById(@PathVariable(value = "id") Long claseId) {
	    return claseRepository.findById(claseId).orElseThrow(() -> new ResourceNotFoundException("Clase", "id", claseId));
	}
	
	// Update a Clase
	@PutMapping("/clases/{id}")
	public Clase updateNote(@PathVariable(value = "id") Long claseId,
	                                        @Valid @RequestBody Clase claseDetails) {

		Clase clase = claseRepository.findById(claseId)
	            .orElseThrow(() -> new ResourceNotFoundException("Clase", "id", claseId));

	    Clase updatedClase = claseRepository.save(clase);
	    return updatedClase;
	}
	
	// Delete a Clase
	@DeleteMapping("/clases/{id}")
	public ResponseEntity<?> deleteClase(@PathVariable(value = "id") Long claseId) {
	    Clase clase = claseRepository.findById(claseId)
	            .orElseThrow(() -> new ResourceNotFoundException("Clase", "id", claseId));

	    claseRepository.delete(clase);

	    return ResponseEntity.ok().build();
	}
}
