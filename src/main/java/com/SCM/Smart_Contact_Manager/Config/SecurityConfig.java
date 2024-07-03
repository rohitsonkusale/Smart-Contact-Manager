package com.SCM.Smart_Contact_Manager.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.SCM.Smart_Contact_Manager.Services.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {
	
	//	user create and login using java code with in memory service 
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user1 = User
//				.withDefaultPasswordEncoder()
//				.username("rohit")
//				.password("2001")
//				.roles("ADMIN", "USER")
//				.build();
//		
//		UserDetails user2 = User
//				.withUsername("zoro")
//				.password("2001")
//				.roles("ADMIN", "USER")
//				.build();
//		
//		var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
//		return inMemoryUserDetailsManager;
//	}
	
	@Autowired
	private SecurityCustomUserDetailService userDetailService;
	
	//configuration of authentication provider
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		// user detail service ka object
		daoAuthenticationProvider.setUserDetailsService(userDetailService);
		// password encoder ka object
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // configuration

        // urls configure kiay hai ki koun se public ranhenge aur koun se private
        // ranhenge
        httpSecurity.authorizeHttpRequests(authorize -> {
            // authorize.requestMatchers("/home", "/register", "/services").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });
		
		//form default login
		//agar hame kuch bhi change karna hua toh hum yaha ayenge: form login se related
		httpSecurity.formLogin(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}














