package dev.dimini.easynhower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Enables fine-grained annotations like @PreAuthorize
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Turn off for stateless APIs
                .authorizeHttpRequests(auth -> auth

                        // 1. FREE PASS (Public - anyone can visit)
                        // No login or authorization needed for these paths
                        .requestMatchers("/api/**").permitAll()

                        // 2. VIP ONLY (Role-Based - must have a specific job/role)
                        // Only users who are logged in AND have the "ADMIN" role can go here
//                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")

                        // 3. SPECIAL PERMISSION (Authority-Based - fine-grained control)
                        // Users must have the exact specific permission "write:products"
//                        .requestMatchers("/api/v1/products/create").hasAuthority("write:products")

                        // 4. THE CATCH-ALL (Secure by Default)
                        // Any URL not mentioned above requires the user to be logged in
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
