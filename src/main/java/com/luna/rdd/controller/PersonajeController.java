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
import com.luna.rdd.model.Personaje;
import com.luna.rdd.repository.PersonajeRepository;

@RestController
@RequestMapping("/api")
public class PersonajeController {

	@Autowired
	PersonajeRepository personajeRepository;
	
	// Get All Personajes
	@GetMapping("/personajes")
	public List<Personaje> getAllPersonajes() {
	    return personajeRepository.findAll();
	}
	
	// Create a new Personaje
	@PostMapping("/personajes")
	public Personaje createNote(@Valid @RequestBody Personaje personaje) {
	    return personajeRepository.save(personaje);
	}
	
	// Get a Single Personaje
	@GetMapping("/personajes/{id}")
	public Personaje getPersonajeById(@PathVariable(value = "id") Long personajeId) {
	    return personajeRepository.findById(personajeId).orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", personajeId));
	}
	
	// Update a Personaje
	@PutMapping("/personajes/{id}")
	public Personaje updateNote(@PathVariable(value = "id") Long personajeId,
	                                        @Valid @RequestBody Personaje personajeDetails) {

		Personaje personaje = personajeRepository.findById(personajeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", personajeId));

		personaje.setNombre(personajeDetails.getNombre());
		personaje.setTrasfondo(personajeDetails.getTrasfondo());
		personaje.setNombreJugador(personajeDetails.getNombreJugador());
		personaje.setNivel(personajeDetails.getNivel());
		personaje.setClase(personajeDetails.getClase());
		personaje.setRaza(personajeDetails.getRaza());
		personaje.setAlineamiento(personajeDetails.getAlineamiento());
		personaje.setPuntosExperiencia(personajeDetails.getPuntosExperiencia());
		personaje.setPuntosVidaTotales(personajeDetails.getPuntosVidaTotales());
		personaje.setFuerza(personajeDetails.getFuerza());
		personaje.setDestreza(personajeDetails.getDestreza());
		personaje.setConstitucion(personajeDetails.getConstitucion());
		personaje.setInteligencia(personajeDetails.getInteligencia());
		personaje.setSabiduria(personajeDetails.getSabiduria());
		personaje.setCarisma(personajeDetails.getCarisma());

	    Personaje updatedPersonaje = personajeRepository.save(personaje);
	    return updatedPersonaje;
	}
	
	// Delete a Personaje
	@DeleteMapping("/personajes/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable(value = "id") Long personajeId) {
		Personaje personaje = personajeRepository.findById(personajeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", personajeId));

		personajeRepository.delete(personaje);

	    return ResponseEntity.ok().build();
	}
}
