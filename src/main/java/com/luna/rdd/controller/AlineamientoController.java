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
import com.luna.rdd.model.Alineamiento;
import com.luna.rdd.repository.AlineamientoRepository;

@RestController
@RequestMapping("/api")
public class AlineamientoController {

	@Autowired
	AlineamientoRepository alineamientoRepository;
	
	// Get All Alineamientos
	@GetMapping("/alineamientos")
	public List<Alineamiento> getAllFichas() {
	    return alineamientoRepository.findAll();
	}
	
	// Create a new Alineamiento
	@PostMapping("/alineamientos")
	public Alineamiento createAlineamiento(@Valid @RequestBody Alineamiento alineamiento) {
	    return alineamientoRepository.save(alineamiento);
	}
	
	// Get a Single Alineamiento
	@GetMapping("/alineamientos/{id}")
	public Alineamiento getAlineamientoById(@PathVariable(value = "id") Long alineamientoId) {
	    return alineamientoRepository.findById(alineamientoId).orElseThrow(() -> new ResourceNotFoundException("Alineamiento", "id", alineamientoId));
	}
	
	// Update a Alineamiento
	@PutMapping("/alineamientos/{id}")
	public Alineamiento updateNote(@PathVariable(value = "id") Long alineamientoId,
	                                        @Valid @RequestBody Alineamiento alineamientoDetails) {

		Alineamiento alineamiento = alineamientoRepository.findById(alineamientoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Alineamiento", "id", alineamientoId));

		alineamiento.setNombre(alineamientoDetails.getNombre());
		
		Alineamiento updatedAlineamiento = alineamientoRepository.save(alineamiento);
	    return updatedAlineamiento;
	}
	
	// Delete a Alineamiento
	@DeleteMapping("/alineamientos/{id}")
	public ResponseEntity<?> deleteAlineamiento(@PathVariable(value = "id") Long alineamientoId) {
		Alineamiento alineamiento = alineamientoRepository.findById(alineamientoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Alineamiento", "id", alineamientoId));

	    alineamientoRepository.delete(alineamiento);

	    return ResponseEntity.ok().build();
	}
}
