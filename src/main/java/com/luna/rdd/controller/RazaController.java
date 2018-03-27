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
import com.luna.rdd.model.Raza;
import com.luna.rdd.repository.RazaRepository;

@RestController
@RequestMapping("/api")
public class RazaController {

	@Autowired
	RazaRepository razaRepository;
	
	// Get All Razas
	@GetMapping("/razas")
	public List<Raza> getAllFichas() {
	    return razaRepository.findAll();
	}
	
	// Create a new Raza
	@PostMapping("/razas")
	public Raza createRaza(@Valid @RequestBody Raza raza) {
	    return razaRepository.save(raza);
	}
	
	// Get a Single Raza
	@GetMapping("/razas/{id}")
	public Raza getRazaById(@PathVariable(value = "id") Long razaId) {
	    return razaRepository.findById(razaId).orElseThrow(() -> new ResourceNotFoundException("Raza", "id", razaId));
	}
	
	// Update a Raza
	@PutMapping("/razas/{id}")
	public Raza updateNote(@PathVariable(value = "id") Long razaId,
	                                        @Valid @RequestBody Raza razaDetails) {

		Raza raza = razaRepository.findById(razaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Raza", "id", razaId));

		raza.setNombre(razaDetails.getNombre());
		
		Raza updatedRaza = razaRepository.save(raza);
	    return updatedRaza;
	}
	
	// Delete a Raza
	@DeleteMapping("/razas/{id}")
	public ResponseEntity<?> deleteRaza(@PathVariable(value = "id") Long razaId) {
		Raza raza = razaRepository.findById(razaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Raza", "id", razaId));

	    razaRepository.delete(raza);

	    return ResponseEntity.ok().build();
	}
}
