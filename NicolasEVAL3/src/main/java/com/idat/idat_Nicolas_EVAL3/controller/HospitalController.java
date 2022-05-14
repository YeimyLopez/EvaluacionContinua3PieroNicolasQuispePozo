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

import com.idat.idat_Nicolas_EVAL3.dto.HospitalRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.HospitalResponseDTO;
import com.idat.idat_Nicolas_EVAL3.service.HospitalService;

@RestController
@RequestMapping("/hospital/v1")
public class HospitalController {
	@Autowired
	private HospitalService service;
	
	@RequestMapping(method = RequestMethod.GET, path="/listar")
	public ResponseEntity<List<HospitalResponseDTO>> listar(){
		return new ResponseEntity<List<HospitalResponseDTO>>(service.listarHospital(),HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, path ="/guardar")
	public ResponseEntity<Void> guardar(@RequestBody HospitalRequestDTO hospital){
		service.guardarHospital(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path="/listar/{id}")
	public @ResponseBody ResponseEntity<HospitalResponseDTO> hospitalById(@PathVariable Integer id){
		HospitalResponseDTO hospital= service.hospitalById(id);
		
		
		
		if(hospital != null) {
			return new ResponseEntity<HospitalResponseDTO>(hospital,HttpStatus.OK);
			
		}
		return new ResponseEntity<HospitalResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, path="/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		HospitalResponseDTO cliente= service.hospitalById(id);
		
		
		if (cliente != null) {
			service.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method= RequestMethod.PUT, path="/editar")
	public ResponseEntity<Void> editar(@RequestBody HospitalRequestDTO hospita){
		HospitalResponseDTO hospital = service.hospitalById(hospita.getIdRequest());
		
		
		if(hospital != null) {
			service.editarHospital(hospita);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
