// =============================================================================
// ENTITY - Modello dati che rappresenta una riga nella tabella del database
// =============================================================================
// PERSONALIZZA:
// 1. Cambia il nome della classe (es: Registrazione -> Iscrizione, Proposta, ecc.)
// 2. Cambia il nome della tabella nella annotation @Table
// 3. Aggiungi/rimuovi campi in base a quelli richiesti dalla traccia
// 4. I campi qui DEVONO corrispondere ai campi del form nel frontend (siteConfig.ts)
// =============================================================================

package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registrazioni")  // ========== CAMBIA il nome della tabella ==========
public class Registrazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ========== CAMPI DEL FORM ==========
    // CAMBIA: aggiungi/rimuovi campi in base alla traccia dell'esame
    // Ogni campo qui corrisponde a una colonna nel database

    @Column(nullable = false)
    private String nomeScuola;

    @Column(nullable = false)
    private String gradoScuola;        // es: "Primo Grado", "Secondo Grado"

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String classe;

    @Column(nullable = false)
    private String nomeDocente;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nomeProgetto;

    @Column(nullable = false, length = 5000)  // CAMBIA length se serve più spazio
    private String descrizione;

    // ========== AGGIUNGI QUI ALTRI CAMPI SE LA TRACCIA LO RICHIEDE ==========
    // Esempio:
    // @Column(nullable = false)
    // private String telefono;

    // ========== COSTRUTTORI ==========
    public Registrazione() {}

    // ========== GETTER E SETTER ==========
    // Servono a Spring per leggere/scrivere i campi dal JSON

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeScuola() { return nomeScuola; }
    public void setNomeScuola(String nomeScuola) { this.nomeScuola = nomeScuola; }

    public String getGradoScuola() { return gradoScuola; }
    public void setGradoScuola(String gradoScuola) { this.gradoScuola = gradoScuola; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public String getNomeDocente() { return nomeDocente; }
    public void setNomeDocente(String nomeDocente) { this.nomeDocente = nomeDocente; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNomeProgetto() { return nomeProgetto; }
    public void setNomeProgetto(String nomeProgetto) { this.nomeProgetto = nomeProgetto; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    // ========== AGGIUNGI GETTER/SETTER PER OGNI NUOVO CAMPO ==========
}
