import { useState } from 'react'
import './App.css'

// componente principale
function App() {

  // stati per il form
  const [nomeScuola, setNomeScuola] = useState('')
  const [grado, setGrado] = useState('')
  const [provincia, setProvincia] = useState('')
  const [classe, setClasse] = useState('')
  const [nomeDocente, setNomeDocente] = useState('')
  const [email, setEmail] = useState('')
  const [nomeProgetto, setNomeProgetto] = useState('')
  const [descrizione, setDescrizione] = useState('')

  // funzione per mandare i dati al backend
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()

    // controllo campi
    if (!nomeScuola || !grado || !provincia || !classe || !nomeDocente || !email || !nomeProgetto || !descrizione) {
      alert('Compila tutti i campi!')
      return
    }

    // mando i dati
    fetch('/api/registrazioni', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        nomeScuola,
        gradoScuola: grado,
        provincia,
        classe,
        nomeDocente,
        email,
        nomeProgetto,
        descrizione
      })
    })
      .then(res => {
        if (res.ok) {
          alert('Registrazione inviata!')
        } else {
          alert('Errore nell\'invio')
        }
      })
      .catch(() => alert('Errore di connessione al server'))
  }

  // proposte di esempio
  const proposte = [
    { titolo: "Orto scolastico smart", descrizione: "Un orto gestito con sensori IoT.", scuola: "Liceo Volta - Milano" },
    { titolo: "Raccolta differenziata digitale", descrizione: "App per differenziare i rifiuti.", scuola: "ITIS Galilei - Roma" },
    { titolo: "Pannelli solari a scuola", descrizione: "Installare pannelli solari sul tetto.", scuola: "IC Manzoni - Torino" }
  ]

  return (
    <div>

      {/* HERO */}
      <div className="hero">
        <h1>GreenTech</h1>
        <p>Proponi la tua idea green per un futuro sostenibile!</p>
        <a href="#registrazione" className="bottone">Partecipa</a>
      </div>

      {/* MISSIONE */}
      <div className="sezione">
        <h2>Missione e Visione</h2>
        <p>GreenTech vuole sensibilizzare gli studenti sulla sostenibilità ambientale raccogliendo idee innovative dalle scuole italiane.</p>
      </div>

      {/* TECNOLOGIE VERDI */}
      <div className="sezione sfondo">
        <h2>Tecnologie Verdi</h2>
        <p>Energia solare, riciclo intelligente e agricoltura urbana sono le tecnologie che promuoviamo nelle scuole.</p>
      </div>

      {/* TESTIMONIANZE */}
      <div className="sezione">
        <h2>Testimonianze</h2>
        <p><i>"Grazie a GreenTech abbiamo installato pannelli solari nella nostra scuola."</i> - Prof. Bianchi</p>
        <p><i>"Il progetto dell'orto ha coinvolto tutti gli studenti."</i> - Prof.ssa Rossi</p>
      </div>

      {/* PREMI */}
      <div className="sezione sfondo">
        <h2>Premi</h2>
        <p>1° premio: borsa di studio da 5000€ | 2° premio: 3000€ | 3° premio: 1500€</p>
      </div>

      {/* FORM REGISTRAZIONE */}
      <div className="sezione" id="registrazione">
        <h2>Registrati</h2>
        <form onSubmit={handleSubmit} className="form">
          <input placeholder="Nome Scuola" value={nomeScuola} onChange={e => setNomeScuola(e.target.value)} />
          <select value={grado} onChange={e => setGrado(e.target.value)}>
            <option value="">Grado scuola...</option>
            <option value="primo">Primo Grado</option>
            <option value="secondo">Secondo Grado</option>
          </select>
          <input placeholder="Provincia" value={provincia} onChange={e => setProvincia(e.target.value)} />
          <input placeholder="Classe (es. 3A)" value={classe} onChange={e => setClasse(e.target.value)} />
          <input placeholder="Nome Docente" value={nomeDocente} onChange={e => setNomeDocente(e.target.value)} />
          <input placeholder="Email" type="email" value={email} onChange={e => setEmail(e.target.value)} />
          <input placeholder="Nome Progetto" value={nomeProgetto} onChange={e => setNomeProgetto(e.target.value)} />
          <textarea placeholder="Descrizione progetto..." rows={4} value={descrizione} onChange={e => setDescrizione(e.target.value)} />
          <button type="submit">Invia</button>
        </form>
      </div>

      {/* PROPOSTE */}
      <div className="sezione sfondo">
        <h2>Proposte</h2>
        {proposte.map((p, i) => (
          <div key={i} className="proposta">
            <b>{p.titolo}</b> - {p.descrizione} <i>({p.scuola})</i>
          </div>
        ))}
      </div>

      {/* FOOTER */}
      <div className="footer">
        <p>© 2024 GreenTech</p>
      </div>

    </div>
  )
}

export default App
