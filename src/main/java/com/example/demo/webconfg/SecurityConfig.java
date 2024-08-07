package com.example.demo.webconfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/", "/home").permitAll() // Permit access to home
                        .requestMatchers("/list/**").permitAll()
                        .requestMatchers("/blist/**").permitAll() // Permit access to list and its subpaths// Permit access to buy
                        .requestMatchers("/saveMsg").permitAll() // Permit access to saveMsg
                        .requestMatchers("/Assets/**").permitAll()
                        .requestMatchers("login").permitAll()// Permit access to assets
                        .anyRequest().authenticated()) // Require authentication for other requests

                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true")
                        .permitAll())
                         .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .permitAll());
             // Use default HTTP Basic authentication

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails Admin = User.withDefaultPasswordEncoder().
                username("admin").
                password("admin").
                roles("ADMIN","USER").
                build();
        UserDetails user = User.withDefaultPasswordEncoder().
                username("user").
                password("user").
                roles("USER").build();

        return new InMemoryUserDetailsManager(Admin, user);
    }
}
