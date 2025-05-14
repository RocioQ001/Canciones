package com.rocioquezada.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rocioquezada.modelos.Cancion;
import com.rocioquezada.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {

	@Autowired
	private final ServicioCanciones servicioCanciones;
	
	public ControladorCanciones(ServicioCanciones servicioCanciones) {
		this.servicioCanciones = servicioCanciones;
	}
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		model.addAttribute("listaCanciones" ,listaCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		if (cancionActual == null) {
			return "redirect:/canciones";
		}
		model.addAttribute("cancion", cancionActual);
		return "detalleCancion.jsp";
	}
}
