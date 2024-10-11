package com.example.ECOM.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.csrf(csrf -> csrf
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern("/public/**"))
                        .ignoringRequestMatchers(mvcMatcherBuilder.pattern("/api/**"))) // Allow POST requests to /saveMsg without CSRF

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(mvcMatcherBuilder.pattern("/"), mvcMatcherBuilder.pattern("/home")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/dashboard")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/displayMessages/**")).hasRole("ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/admin/additems")).hasRole("ADMIN") // Fixed double slash
                        .requestMatchers(mvcMatcherBuilder.pattern("/list/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/blist/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/saveMsg")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/api/**")).authenticated()
                        .requestMatchers(mvcMatcherBuilder.pattern("/Assets/**")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/messages")).permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/public/**")).permitAll()
                        .anyRequest().authenticated()) // Changed to authenticated for non-matched requests

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true")
                        .permitAll())

                .logout(logout -> logout
                        .logoutRequestMatcher(mvcMatcherBuilder.pattern("/logout"))
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
