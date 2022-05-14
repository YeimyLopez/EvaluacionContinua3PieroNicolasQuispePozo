package com.idat.idat_Nicolas_EVAL3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.idat_Nicolas_EVAL3.dto.UsuarioClienteRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.UsuarioClienteResponseDTO;
import com.idat.idat_Nicolas_EVAL3.service.UsuarioClienteService;

@RestController
@RequestMapping("/usuario/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService service;
	
	@RequestMapping(method= RequestMethod.GET, path="/listar")
	public ResponseEntity<List<UsuarioClienteResponseDTO>> listar(){
		return new ResponseEntity<List<UsuarioClienteResponseDTO>>(service.listarUsuarioCliente(),HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST, path="/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteRequestDTO usuario){
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/listar/{id}")
	public @ResponseBody ResponseEntity<UsuarioClienteResponseDTO> productById(@PathVariable Integer id){
		UsuarioClienteResponseDTO usuario = service.usuarioClienteById(id);
		
		if(usuario != null) {
			return new ResponseEntity<UsuarioClienteResponseDTO>(usuario,HttpStatus.OK);
		}
		return new ResponseEntity<UsuarioClienteResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, path="/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		UsuarioClienteResponseDTO usuario = service.usuarioClienteById(id);
		if(usuario != null) {
			service.eliminarUsuarioCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method= RequestMethod.PUT, path="/editar")
	public ResponseEntity<Void> editar(@RequestBody UsuarioClienteRequestDTO usuario){
		UsuarioClienteResponseDTO usuari = service.usuarioClienteById(usuario.getIdRequest());
		if(usuari != null) {
			service.editarUsuarioCliente(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	

}
