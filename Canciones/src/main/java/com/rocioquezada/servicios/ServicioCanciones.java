package com.rocioquezada.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocioquezada.modelos.Cancion;
import com.rocioquezada.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	
	@Autowired
	private final RepositorioCanciones repositorioCanciones;

	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	
	public List<Cancion> obtenerTodasLasCanciones(){
		return this.repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long idCancion) {
		return this.repositorioCanciones.findById(idCancion).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancionNueva) {
		return this.repositorioCanciones.save(cancionNueva);
	}
	
	public Cancion actualizaCancion(Cancion cancionActualizada) {
		return this.repositorioCanciones.save(cancionActualizada);
	}
	
	public void eliminaCancion(Long idCancion) {
		this.repositorioCanciones.deleteById(idCancion);
	}
}
