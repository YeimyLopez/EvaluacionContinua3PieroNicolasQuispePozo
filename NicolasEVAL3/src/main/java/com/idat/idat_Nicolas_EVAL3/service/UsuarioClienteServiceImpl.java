package com.idat.idat_Nicolas_EVAL3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idat_Nicolas_EVAL3.dto.UsuarioClienteRequestDTO;
import com.idat.idat_Nicolas_EVAL3.dto.UsuarioClienteResponseDTO;
import com.idat.idat_Nicolas_EVAL3.model.UsuarioCliente;
import com.idat.idat_Nicolas_EVAL3.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {


	  @Autowired
	  private UsuarioClienteRepository repository;

	  @Override
	  public void guardarUsuario(UsuarioClienteRequestDTO p) {
	    UsuarioCliente usuario = new UsuarioCliente();
	    usuario.setUsuario(p.getUsuarioRequest());
	    usuario.setUsuario(p.getUsuarioRequest());
	    usuario.setPassword(p.getPasswordRequest());
	    usuario.setRol(p.getRolRequest());
	    repository.save(usuario);

	  }

	  @Override
	  public void eliminarUsuarioCliente(Integer id) {
	    repository.deleteById(id);

	  }

	  @Override
	  public void editarUsuarioCliente(UsuarioClienteRequestDTO u) {
	    UsuarioCliente usuario = new UsuarioCliente();
	    usuario.setIdUsuario(u.getIdRequest());
	    usuario.setUsuario(u.getUsuarioRequest());
	    usuario.setPassword(u.getPasswordRequest());
	    usuario.setRol(u.getRolRequest());
	    repository.saveAndFlush(usuario);

	  }

	  @Override
	  public List<UsuarioClienteResponseDTO> listarUsuarioCliente() {
	    List<UsuarioCliente> usuario = repository.findAll();
	    List<UsuarioClienteResponseDTO> dto = new ArrayList<UsuarioClienteResponseDTO>();
	    UsuarioClienteResponseDTO usuarioDTO = null;

	    for (UsuarioCliente usuarios : usuario) {
	      usuarioDTO = new UsuarioClienteResponseDTO();
	      usuarioDTO.setIdResponse(usuarios.getIdUsuario());
	      usuarioDTO.setUsuarioResponse(usuarios.getUsuario());
	      usuarioDTO.setPasswordResponse(usuarios.getPassword());
	      usuarioDTO.setRolResponse(usuarios.getRol());
	      dto.add(usuarioDTO);
	    }
	    return null;
	  }

	  @Override
	  public UsuarioClienteResponseDTO usuarioClienteById(Integer id) {
	    UsuarioCliente usuario = repository.findById(id).orElse(null);
	    UsuarioClienteResponseDTO usuarioDTO = new UsuarioClienteResponseDTO();
	    usuarioDTO = new UsuarioClienteResponseDTO();
	    usuarioDTO.setIdResponse(usuario.getIdUsuario());
	    usuarioDTO.setUsuarioResponse(usuario.getUsuario());
	    usuarioDTO.setPasswordResponse(usuario.getPassword());
	    usuarioDTO.setRolResponse(usuario.getRol());
	    return null;
	  }

}
