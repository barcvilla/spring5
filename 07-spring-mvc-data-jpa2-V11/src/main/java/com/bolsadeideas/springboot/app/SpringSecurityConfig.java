package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Implementamos un metodo para configurar el acceso a nuestras paginas y recursos
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//configuramos nuestras rutas publicas de acceso a todos
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
		.antMatchers("/ver/**").hasAnyRole("USER")
		.antMatchers("/uploads/**").hasAnyRole("USER")
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		.antMatchers("/factura/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
			.permitAll()
		.and()
			.logout(); //recursos privados
	}
	
	//Implementamos el metodo que nos permite crear usuarios en memoria
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//a traves del builder configuramos el repositorio donde guardamos los usuarios
		UserBuilder users =  User.builder().passwordEncoder(encoder::encode);
		
		// creacion de nuestros usuarios en un repositorio en memoria
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("andres").password("12345").roles("USER"));
	}	
}
