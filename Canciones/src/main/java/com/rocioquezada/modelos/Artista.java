package com.rocioquezada.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="artistas")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, message = "Por favor ingrese un nombre con más de tres caracteres.")
	private String nombre;
	
	@Size(min=3, message = "Por favor ingrese un apellido con más de tres caracteres.")
	private String apellido;
	
	@Size(min=15, message = "Por favor ingrese la biografía del artísta.")
	private String biografia;
	
	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cancion> canciones;
	
	@Column(updatable = false, name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCreacion;
	
	@Column(name="fecha_actualizacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaActualizacion;
	
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
		this.fechaActualizacion = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();
	}

	public Artista() {}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
}
