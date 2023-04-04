package com.casos.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.casos.web.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfigWeb extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsersService usersService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	//OBTENER - MOSTRAR DATOS DE USUARIO // MOSTRAR SI SON DATOS O NO
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(usersService);
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return authenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests().antMatchers(
				
				"/registroUsuarios**",
				"/",
				"/home",
				"/js/**",
				"/css/**",
				"/Images/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/loginUsuarios")
				.successHandler(new CustomAuthenticationSuccessHandler())
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/loginUsuarios?logout")
				.permitAll()
				.and()
			    .headers().cacheControl().disable(); // Deshabilitar el caché de la página
	}
}
