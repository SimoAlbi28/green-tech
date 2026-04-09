// =============================================================================
// SERVICE - Logica di business
// =============================================================================
// Contiene la logica tra il Controller e il Repository.
// PERSONALIZZA:
// 1. Cambia "Registrazione" con il nome della tua Entity
// 2. Aggiungi metodi se servono operazioni più complesse
// =============================================================================

package com.example.backend.service;

import com.example.backend.model.Registrazione;
import com.example.backend.repository.RegistrazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrazioneService {

    @Autowired
    private RegistrazioneRepository repository;

    // ========== SALVA UNA NUOVA REGISTRAZIONE ==========
    public Registrazione salva(Registrazione registrazione) {
        return repository.save(registrazione);
    }

    // ========== OTTIENI TUTTE LE REGISTRAZIONI ==========
    public List<Registrazione> trovaTutte() {
        return repository.findAll();
    }

    // ========== TROVA PER ID ==========
    public Registrazione trovaPerId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ========== CANCELLA PER ID ==========
    public void cancella(Long id) {
        repository.deleteById(id);
    }

    // ========== AGGIUNGI QUI ALTRI METODI SE NECESSARIO ==========
    // Esempio: filtrare per provincia
    // public List<Registrazione> trovaPerProvincia(String provincia) {
    //     return repository.findByProvincia(provincia);
    // }
}
