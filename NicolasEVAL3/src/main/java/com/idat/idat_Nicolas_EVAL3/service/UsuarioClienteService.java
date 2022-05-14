package com.idat.idat_Nicolas_EVAL3.service;

import java.util.List;

import com.idat.idat_Nicolas_EVAL3.dto.UsuarioClienteRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.UsuarioClienteResponseDTO;

public interface UsuarioClienteService {
	  public void guardarUsuario(UsuarioClienteRequestDTO u);
	  public void eliminarUsuarioCliente(Integer id);
	  public void editarUsuarioCliente(UsuarioClienteRequestDTO u);
	  public List<UsuarioClienteResponseDTO> listarUsuarioCliente();
	  public UsuarioClienteResponseDTO usuarioClienteById(Integer id);
}