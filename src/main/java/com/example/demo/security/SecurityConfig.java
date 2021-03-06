package com.example.demo.security;

import org.springframework.context.annotation.Bean;
//end::securityConfigOuterClass[]
//tag::baseBonesImports[]
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web
                        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
                        .configuration.WebSecurityConfigurerAdapter;
//end::baseBonesImports[]

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation
             .authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web
             .builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//tag::customUserDetailsService[]
  @Autowired
  private UserDetailsService userDetailsService;

//end::customUserDetailsService[]

  //tag::configureHttpSecurity[]
  //tag::authorizeRequests[]
  //tag::customLoginPage[]
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/design", "/orders")
          .access("hasRole('ROLE_USER')")
        .antMatchers("/", "/**").access("permitAll")
        //end::authorizeRequests[]

      .and()
        .formLogin()
          .loginPage("/login")

        //end::customLoginPage[]

      // tag::enableLogout[]
      .and()
        .logout()
          .logoutSuccessUrl("/")
      .and().headers().frameOptions().sameOrigin();



  }
  @Bean
  public PasswordEncoder encoder() {
    return new StandardPasswordEncoder("dangvanchuc1998");
  }
  
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {

    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(encoder());
    
  }
}

