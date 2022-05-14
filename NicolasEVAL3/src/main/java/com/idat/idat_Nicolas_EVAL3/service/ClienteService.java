package com.idat.idat_Nicolas_EVAL3.service;

import java.util.List;

import com.idat.idat_Nicolas_EVAL3.dto.ClienteRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.ClienteResponseDTO;

public interface ClienteService {
	public void guardarCliente(ClienteRequestDTO c);
	public void eliminarCliente(Integer c);
	public void editarCliente(ClienteRequestDTO c);
	public List<ClienteResponseDTO> listarCliente();
	public ClienteResponseDTO clienteById(Integer id);
}
