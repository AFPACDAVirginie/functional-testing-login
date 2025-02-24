package fr.afpa.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuration de la sécurité de l'application.
 * 
 * Autorisation des routes pour l'utilisateur autorisé :
 * - /home
 * 
 * Autorisation des routes pour l'utilisateur NON autorisé :
 * - /login
 * - /register
 * - /js/** : permet d'accéder aux fichiers statics JS
 * - /css/** : permet d'accéder aux fichiers statics CSS
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(requests -> requests
						.requestMatchers("/home").hasRole("USER")

						.requestMatchers("/register","/js/**", "/css/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll())
				.logout(LogoutConfigurer::permitAll);

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// méthode "withDefaultPasswordEncoder" dépréciée et utilisée par commodité de développement
		// ne pas utiliser en production
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("ada_lovelace")
				.password("supersecured")
				.roles("USER")
				.build();
		UserDetails guest = User.withDefaultPasswordEncoder()
				.username("alan_turing")
				.password("guestpassword")
				.roles("GUEST") // Ce rôle n'a pas accès à /home
				.build();

		return new InMemoryUserDetailsManager(user, guest);
	}
}
