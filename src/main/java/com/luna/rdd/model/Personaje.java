package com.luna.rdd.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.luna.rdd.util.salvacion.TiradaSalvacion;

@Entity
@Table(name = "personajes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Personaje {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String nombre;
	private String trasfondo;
	
	@NotBlank
	private String nombreJugador;
	
	@NotBlank
	private Long nivel;
	
	@ManyToOne
	private Clase clase;

	@ManyToOne
	private Raza raza;
	
	@ManyToOne
	public Alineamiento alineamiento;
	
	private Long puntosExperiencia;
	private Long puntosVidaTotales;
	
	private Long fuerza;
	private Long destreza;
	private Long constitucion;
	private Long inteligencia;
	private Long sabiduria;
	private Long carisma;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Raza getRaza() {
		return raza;
	}
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public Alineamiento getAlineamiento() {
		return alineamiento;
	}
	public void setAlineamiento(Alineamiento alineamiento) {
		this.alineamiento = alineamiento;
	}
	public Long getPuntosExperiencia() {
		return puntosExperiencia;
	}
	public void setPuntosExperiencia(Long puntosExperiencia) {
		this.puntosExperiencia = puntosExperiencia;
	}
	
	public Long getPuntosVidaTotales() {
		return puntosVidaTotales;
	}
	public void setPuntosVidaTotales(Long puntosVidaTotales) {
		this.puntosVidaTotales = puntosVidaTotales;
	}
	public String getTrasfondo() {
		return trasfondo;
	}
	public void setTrasfondo(String trasfondo) {
		this.trasfondo = trasfondo;
	}
	public Long getFuerza() {
		return fuerza;
	}
	public void setFuerza(Long fuerza) {
		this.fuerza = fuerza;
	}
	public Long getDestreza() {
		return destreza;
	}
	public void setDestreza(Long destreza) {
		this.destreza = destreza;
	}
	public Long getConstitucion() {
		return constitucion;
	}
	public void setConstitucion(Long constitucion) {
		this.constitucion = constitucion;
	}
	public Long getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(Long inteligencia) {
		this.inteligencia = inteligencia;
	}
	public Long getSabiduria() {
		return sabiduria;
	}
	public void setSabiduria(Long sabiduria) {
		this.sabiduria = sabiduria;
	}
	public Long getCarisma() {
		return carisma;
	}
	public void setCarisma(Long carisma) {
		this.carisma = carisma;
	}

	public Long getTSFuerza() {
		TiradaSalvacion ts = new TiradaSalvacion();
		return ts.calculaTiradaSalvacion(this.fuerza);
	}

	public Long getTSDestreza() {
		TiradaSalvacion ts = new TiradaSalvacion();
		return ts.calculaTiradaSalvacion(this.destreza);
	}

	public Long getTSConstitucion() {
		TiradaSalvacion ts = new TiradaSalvacion();
		return ts.calculaTiradaSalvacion(this.constitucion);
	}

	public Long getTSInteligencia() {
		TiradaSalvacion ts = new TiradaSalvacion();
		return ts.calculaTiradaSalvacion(this.inteligencia);
	}

	public Long getTSSabiduria() {
		TiradaSalvacion ts = new TiradaSalvacion();
		return ts.calculaTiradaSalvacion(this.sabiduria);
	}

	public Long getTSCarisma() {
		TiradaSalvacion ts = new TiradaSalvacion();
		return ts.calculaTiradaSalvacion(this.carisma);
	}
}
