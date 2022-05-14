package com.idat.idat_Nicolas_EVAL3.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.idat.idat_Nicolas_EVAL3.model.UsuarioCliente;
import com.idat.idat_Nicolas_EVAL3.repository.UsuarioClienteRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioCliente usuario = repository.findByUsuarioCliente(username); 
		
		if(usuario != null) {
			List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
			granted.add(authority);
			return new User(usuario.getUsuario(),new BCryptPasswordEncoder().encode(usuario.getPassword()),granted);
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

}
