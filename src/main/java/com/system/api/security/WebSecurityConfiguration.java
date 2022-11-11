package com.system.api.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebSecurity
@Configuration
@ComponentScan("com.system.api.security")
@EnableSwagger2
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	private static final String[] AUTH_WHITELIST = { "/login", "/users/register", "/messages/*", "/configuration/ui",
			"/configuration/security", "/swagger-ui.html", "/webjars/**" };

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		System.out.println("------------- AuthenticationManagerBuilder Configuration is done -------------");
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	protected void configure(HttpSecurity httpSecurity) throws Exception {
		System.out.println("------------- HttpSecurity Configurtion is done -------------");
		httpSecurity.formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login_error").permitAll()
				.and().cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
				.and().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().antMatchers("/api/auth/**")
				.permitAll().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		System.out.println("------------- HttpSecurity Configurtion is done -------------");
//		httpSecurity.formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login_error").permitAll()
//				.and().cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//				.and().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
//				.antMatchers(HttpMethod.GET, "/api/v1/suppliers/listAllcountry").permitAll()
//				.antMatchers(HttpMethod.POST, "/api/v1/suppliers/login").permitAll()
//				.antMatchers(HttpMethod.POST, "/api/v1/suppliers/addCustomer/{country_id}").permitAll()
//				.antMatchers(HttpMethod.POST, "/api/v1/suppliers/addCountry").permitAll().and().authorizeRequests()
//				.antMatchers("/api/auth/**").permitAll().anyRequest().authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


}