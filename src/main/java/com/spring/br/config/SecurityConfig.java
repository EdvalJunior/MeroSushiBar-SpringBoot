package com.spring.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.br.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImplementacao UserDetailsServiceImple;
	
	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/").permitAll()
		.antMatchers("/cliente/formCliente").permitAll()
		.antMatchers("/cliente/cadastrarCliente").permitAll()
		.antMatchers("/prato/listarPratos").permitAll()
		.antMatchers("/prato/formPrato").hasRole("ADM")
		.antMatchers("/prato/salvarPrato").hasRole("ADM")
		.antMatchers("/prato//excluir/{id}").hasRole("ADM")
		.antMatchers("/prato//alterar/{id}").hasRole("ADM")
		
		//QUando implementar a parte de pratos colocar
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/cliente/logar").defaultSuccessUrl("/").permitAll()
		.permitAll()
		
		.and()
		.logout()
		.logoutSuccessUrl("/cliente/logout")
		.permitAll();
		
		super.configure(http);
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailsServiceImple).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/img/**","/images/**");
		super.configure(web);
	}


	
}
