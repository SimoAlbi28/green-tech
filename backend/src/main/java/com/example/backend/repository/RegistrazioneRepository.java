// =============================================================================
// REPOSITORY - Interfaccia per accedere al database
// =============================================================================
// Non serve scrivere codice qui! Spring JPA genera automaticamente i metodi
// per salvare, cercare, cancellare ecc.
//
// PERSONALIZZA:
// 1. Cambia "Registrazione" con il nome della tua Entity
// 2. Cambia "Long" solo se il tipo dell'ID nella Entity è diverso
// =============================================================================

package com.example.backend.repository;

import com.example.backend.model.Registrazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrazioneRepository extends JpaRepository<Registrazione, Long> {
    // ========== METODI AUTOMATICI GIÀ DISPONIBILI ==========
    // findAll()              -> restituisce tutte le registrazioni
    // findById(Long id)      -> trova per ID
    // save(Registrazione r)  -> salva una nuova registrazione
    // deleteById(Long id)    -> cancella per ID
    // count()                -> conta il totale

    // ========== METODI CUSTOM (opzionali) ==========
    // Puoi aggiungere metodi personalizzati. Spring li implementa automaticamente
    // basandosi sul nome del metodo. Esempi:
    //
    // List<Registrazione> findByProvincia(String provincia);
    // List<Registrazione> findByGradoScuola(String gradoScuola);
    // List<Registrazione> findByNomeScuolaContaining(String keyword);
}
