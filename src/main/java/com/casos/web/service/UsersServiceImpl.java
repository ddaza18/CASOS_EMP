package com.casos.web.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.casos.web.dto.UsersRegisterDTO;
import com.casos.web.model.RolUsersModel;
import com.casos.web.model.Usuario;
import com.casos.web.repository.UsuarioRepositorio;

@Service
public class UsersServiceImpl implements UsersService{
	public static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	private UsuarioRepositorio usersRepository;
	
	
	public UsersServiceImpl(UsuarioRepositorio usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}


	@Override
	public Usuario save(UsersRegisterDTO registerDto) {
		Usuario usuario = new Usuario(registerDto.getName_user(), registerDto.getApp_user(), registerDto.getEmail(),
				bCryptPasswordEncoder.encode(registerDto.getPassword_user()), Arrays.asList(new RolUsersModel("ROLE_USER")));
		try {
		logger.info("Se registro el usuario: "+ registerDto.getEmail() +" Con exito.");
		return usersRepository.save(usuario);
		}catch(DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error: El correo que intenta ingresar a la Base de datos ya existe, por favor intente con otro.");
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usersRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos, Intentar nuevamente");
		}
		return new User(usuario.getEmail(),usuario.getPassword_user(), mapearAutoridadesRoles(usuario.getRoles_user()));
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RolUsersModel> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre_rol())).collect(Collectors.toList());
	}

}
