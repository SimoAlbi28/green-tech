// =============================================================================
// CLASSE MAIN - Punto di ingresso dell'applicazione Spring Boot
// Esegui questa classe per avviare il backend
// =============================================================================

package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
