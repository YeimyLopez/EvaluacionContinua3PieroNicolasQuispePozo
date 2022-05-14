package com.idat.idat_Nicolas_EVAL3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idat_Nicolas_EVAL3.dto.HospitalRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.HospitalResponseDTO;
import com.idat.idat_Nicolas_EVAL3.model.Hospital;
import com.idat.idat_Nicolas_EVAL3.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	  @Autowired
	  private HospitalRepository repository;

	  @Override
	  public void guardarHospital(HospitalRequestDTO c) {
	    Hospital Hospital = new Hospital();
	    Hospital.setIdHospital(c.getIdRequest());
	    Hospital.setNombre(c.getNombreRequest());
	    Hospital.setDescripcion(c.getDescripcionRequest());
	    Hospital.setDistrito(c.getDistritoRequest());
	    repository.save(Hospital);
	    
	  }

	  @Override
	  public void eliminarHospital(Integer id) {
	    repository.deleteById(id);
	    
	  }

	  @Override
	  public void editarHospital(HospitalRequestDTO c) {
	    Hospital hospital = new Hospital();
	    hospital.setIdHospital(c.getIdRequest());
	    hospital.setNombre(c.getNombreRequest());
	    hospital.setDescripcion(c.getDescripcionRequest());
	    hospital.setDistrito(c.getDistritoRequest());
	    repository.saveAndFlush(hospital);
	    
	  }

	  @Override
	  public List<HospitalResponseDTO> listarHospital() {
	    List<Hospital> hospital = repository.findAll();
	    List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
	    HospitalResponseDTO hospitalDTO = null;
	    
	    for(Hospital hospitals : hospital) {
	      hospitalDTO = new HospitalResponseDTO();
	      hospitalDTO.setIdResponse(hospitals.getIdHospital());
	      hospitalDTO.setNombreResponse(hospitals.getNombre());
	      hospitalDTO.setDescripcionResponse(hospitals.getDescripcion());
	      hospitalDTO.setDistritoResponse(hospitals.getDistrito());
	      dto.add(hospitalDTO);
	    }
	    return dto;
	  }

	  @Override
	  public HospitalResponseDTO hospitalById(Integer id) {
	    Hospital hospital = repository.findById(id).orElse(null);
	    HospitalResponseDTO hospitalDTO = new HospitalResponseDTO();
	    hospitalDTO = new HospitalResponseDTO();
	    hospitalDTO.setIdResponse(hospital.getIdHospital());
	    hospitalDTO.setNombreResponse(hospital.getNombre());
	    hospitalDTO.setDescripcionResponse(hospital.getDescripcion());
	    hospitalDTO.setDistritoResponse(hospital.getDistrito());
	    return hospitalDTO;
	  }

}
