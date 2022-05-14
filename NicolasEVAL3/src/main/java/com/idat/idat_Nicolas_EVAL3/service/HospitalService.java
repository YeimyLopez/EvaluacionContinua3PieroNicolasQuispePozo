package com.idat.idat_Nicolas_EVAL3.service;

import com.idat.idat_Nicolas_EVAL3.dto.HospitalRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.HospitalResponseDTO;
import java.util.List;

public interface HospitalService {
	public void guardarHospital(HospitalRequestDTO h);
	public void eliminarHospital(Integer h);
	public void editarHospital(HospitalRequestDTO h);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO hospitalById(Integer id);

}
