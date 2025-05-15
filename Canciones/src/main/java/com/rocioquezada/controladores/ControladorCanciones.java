package com.rocioquezada.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.rocioquezada.modelos.Cancion;
import com.rocioquezada.servicios.ServicioCanciones;

import jakarta.validation.Valid;

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
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion,
										  Model model) {
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		if (cancionActual == null) {
			return "redirect:/canciones";
		}
		model.addAttribute("cancion", cancionActual);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar/{idCancion}")
	public String formularioAgregarCancion(@PathVariable("idCancion") Long idCancion,
										   Model model) {
		Cancion cancionNueva;
		if(idCancion == 0) {
			cancionNueva = new Cancion();
		}else {
			cancionNueva = servicioCanciones.obtenerCancionPorId(idCancion);
		}
		model.addAttribute("cancion", cancionNueva);
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancionNueva,
										BindingResult validacion) {
		if(validacion.hasErrors()) {
			return "agregarCancion.jsp";
		}
		this.servicioCanciones.agregarCancion(cancionNueva);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion,
										  Model model) {
		Cancion cancionActualizada = servicioCanciones.obtenerCancionPorId(idCancion);
	    if (cancionActualizada == null) {
	        return "redirect:/canciones";
	    }
	    model.addAttribute("cancion", cancionActualizada);
	    return "editarCancion.jsp";
	}

	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
									    BindingResult validacion,
									    @PathVariable("idCancion") Long idCancion) {
		if(validacion.hasErrors()) {
			return "editarCancion.jsp";
		}
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		cancion.setId(cancionActual.getId());
		this.servicioCanciones.actualizaCancion(cancion);
		return "redirect:/canciones";
	}
}
