package com.luna.rdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Personaje {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	@NotBlank
	private Long nivel;
	
	@ManyToOne
	private Clase clase;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getNivel() {
		return nivel;
	}
	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
}
