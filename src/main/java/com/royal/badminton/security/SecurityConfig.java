package com.royal.badminton.security;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// package com.royal.badminton.security;


// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter
// {
//     @Override
//     protected void configure(HttpSecurity http) throws Exception
//     {
//         http
//          .csrf().disable()
//          .authorizeRequests().anyRequest().authenticated()
//          .and()
//          .httpBasic();
//     }

//     @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth)
//             throws Exception
//     {
//         auth.inMemoryAuthentication()
//         	.withUser("admin")
//         	.password("{noop}password")
//         	.roles("ADMIN");
//     }
// }


@Configuration
public class SecurityConfig
{
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();

    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User
        .withUsername("admin")
        .password("{noop}password")
        .roles("ADMIN")
        .build();
    return new InMemoryUserDetailsManager(user);
  }
}

