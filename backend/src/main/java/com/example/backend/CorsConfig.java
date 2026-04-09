// =============================================================================
// CONFIGURAZIONE CORS
// =============================================================================
// Permette al frontend (React su porta 5173) di chiamare il backend (porta 8080)
// Serve solo se NON usi il proxy di Vite (vite.config.ts)
// Se usi il proxy, questo file è comunque utile come backup
// =============================================================================

package com.example.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        // ========== CAMBIA le origini permesse se necessario ==========
                        .allowedOrigins("http://localhost:5173", "http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
