package netflix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import netflix.modelo.servicio.ServicioAutenticacion;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private ServicioAutenticacion servicioAutenticacion;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(servicioAutenticacion).passwordEncoder(encoder());
		// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PIZZARIA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/peliculas/**", "/generos/**", "/personas/**").hasRole("ADMIN")
				.anyRequest().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/pizzas").failureUrl("/login?errorlogin=true").usernameParameter("usuario")
				.passwordParameter("password")

				.and().logout().logoutUrl("/salir").logoutSuccessUrl("/login?salir=true");
	}

}
