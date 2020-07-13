package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
/*	//Create User - in28Minutes/dummy
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("in28Minutes").password("{noop}dummy")
                .roles("USER", "ADMIN");
    }
    */
	
/*	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
              .antMatchers("/", "/*todo* /**")"
              /*  		+ ".access("hasRole('USER')").and()     */
     //           .formLogin();
        
     /*   http.csrf().disable();
        http.headers().frameOptions().disable();
    }
   */
   private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* http.authorizeRequests().antMatchers("/delete-todo","/list-todos").hasRole(ADMIN)
			.antMatchers("/update-todo","/error").hasAnyRole(ADMIN,USER)
			.antMatchers("/add-todo","/home").hasAnyRole(ADMIN,USER)
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();  */
		
		http.authorizeRequests().antMatchers("/").hasAnyRole("USER", "ADMIN")
		.antMatchers("/welcome","/registerpatient","/register-patient","/patient-diagnosis","/patientDiagnosisDetails","/register-physician","/registerphysician").hasAnyRole("USER", "ADMIN")
		.antMatchers("/list-todos","/findPatientToAddDiagnosis","/diagnosis","/searchphysicians","/search-physician","/add-bill","/billingDetails").hasAnyRole("USER", "ADMIN")
		.antMatchers("/update-todo","/delete-todo","/add-todo")
		.hasAnyRole("ADMIN","USER")
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
		
		
		http.csrf().disable();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
