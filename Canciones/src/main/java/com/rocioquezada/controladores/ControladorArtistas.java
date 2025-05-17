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

import com.rocioquezada.modelos.Artista;
import com.rocioquezada.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {

	@Autowired
	private final ServicioArtistas servicioArtistas;
	
	public ControladorArtistas(ServicioArtistas servicioArtistas) {
		this.servicioArtistas = servicioArtistas;
	}
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model model) {
		List<Artista> listaArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
		model.addAttribute("listaArtistas", listaArtistas);
		return "artistas.jsp";
	}
	
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model model) {
		Artista artistaActual = this.servicioArtistas.obtenerArtistaPorId(idArtista);
		if(artistaActual == null) {
			return "redirect:/artistas";
		}
		model.addAttribute("artista", artistaActual);
		model.addAttribute("listaCanciones", artistaActual.getCanciones());
		return "detalleArtista.jsp";
	}
	
	@GetMapping("/artistas/formulario/agregar/{idArtista}")
	public String formularioAgregarArtista(@PathVariable("idArtista") Long idArtista, Model model) {
		Artista artistaNuevo;
		if(idArtista == 0) {
			artistaNuevo = new Artista();
		}else {
			artistaNuevo = servicioArtistas.obtenerArtistaPorId(idArtista);
		}
		model.addAttribute("artista", artistaNuevo);
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/artistas/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artistaNuevo, BindingResult validacion) {
		if(validacion.hasErrors()) {
			return "agregarArtista.jsp";
		}
		this.servicioArtistas.agregarArtista(artistaNuevo);
		return "redirect:/artistas";
	}
}
