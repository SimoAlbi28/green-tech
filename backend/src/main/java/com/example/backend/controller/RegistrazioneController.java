// =============================================================================
// CONTROLLER - Endpoint REST API
// =============================================================================
// Definisce le API che il frontend chiama.
// PERSONALIZZA:
// 1. Cambia il path "/api/registrazioni" se serve un URL diverso
//    (deve corrispondere a siteConfig.ts -> api.submitRegistration e api.getProposals)
// 2. Cambia "Registrazione" con il nome della tua Entity
// 3. Aggiungi/rimuovi endpoint se necessario
// =============================================================================

package com.example.backend.controller;

import com.example.backend.model.Registrazione;
import com.example.backend.service.RegistrazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrazioni")  // ========== CAMBIA il path base ==========
@CrossOrigin(origins = "*")            // Permette chiamate dal frontend (CORS)
public class RegistrazioneController {

    @Autowired
    private RegistrazioneService service;

    // ========== POST - CREA NUOVA REGISTRAZIONE ==========
    // Chiamato dal form del frontend quando l'utente invia i dati
    // URL: POST http://localhost:8080/api/registrazioni
    @PostMapping
    public ResponseEntity<Registrazione> crea(@RequestBody Registrazione registrazione) {
        Registrazione salvata = service.salva(registrazione);
        return ResponseEntity.ok(salvata);
    }

    // ========== GET - OTTIENI TUTTE LE REGISTRAZIONI ==========
    // Chiamato dalla sezione "Proposte" del frontend per mostrare la lista
    // URL: GET http://localhost:8080/api/registrazioni
    @GetMapping
    public ResponseEntity<List<Registrazione>> trovaTutte() {
        return ResponseEntity.ok(service.trovaTutte());
    }

    // ========== GET BY ID - OTTIENI UNA REGISTRAZIONE ==========
    // URL: GET http://localhost:8080/api/registrazioni/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Registrazione> trovaPerId(@PathVariable Long id) {
        Registrazione trovata = service.trovaPerId(id);
        if (trovata == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trovata);
    }

    // ========== DELETE - CANCELLA UNA REGISTRAZIONE ==========
    // URL: DELETE http://localhost:8080/api/registrazioni/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancella(@PathVariable Long id) {
        service.cancella(id);
        return ResponseEntity.ok().build();
    }

    // ========== AGGIUNGI QUI ALTRI ENDPOINT SE NECESSARIO ==========
    // Esempio: PUT per aggiornare
    // @PutMapping("/{id}")
    // public ResponseEntity<Registrazione> aggiorna(@PathVariable Long id, @RequestBody Registrazione dati) {
    //     Registrazione esistente = service.trovaPerId(id);
    //     if (esistente == null) return ResponseEntity.notFound().build();
    //     dati.setId(id);
    //     return ResponseEntity.ok(service.salva(dati));
    // }
}
