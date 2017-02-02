package netflix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(servicioAutenticacion).passwordEncoder(encoder());
		 auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		 auth.inMemoryAuthentication().withUser("kily").password("123").roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/peliculas/**").hasRole("USER")
				.anyRequest().permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("USER")
		.anyRequest().denyAll()
		.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/admin")
				.failureUrl("/login?sinacceso=true")
				.usernameParameter("username")
				.passwordParameter("password")
				
			.and()
				.logout()
					.logoutUrl("/salir")
					.logoutSuccessUrl("/login?salir=true");
		
		http
		.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll()
	.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/autenticar")
			.defaultSuccessUrl("/admin")
			.failureUrl("/login?sinacceso=true")
			.usernameParameter("username")
			.passwordParameter("password")
			
		.and()
			.logout()
				.logoutUrl("/salir")
				.logoutSuccessUrl("/login?salir=true");

	}
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	

}
