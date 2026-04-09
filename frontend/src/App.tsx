// importo useState per gestire i campi del form e useEffect per caricare i dati all'avvio
import { useState } from 'react'

// questo è il componente principale della mia pagina
function App() {

  // qui creo una variabile di stato per ogni campo del form
  // useState mi serve per tenere traccia di cosa scrive l'utente negli input
  const [school, setSchool] = useState('')
  const [level, setLevel] = useState('')
  const [province, setProvince] = useState('')
  const [className, setClassName] = useState('')
  const [contactPerson, setContactPerson] = useState('')
  const [email, setEmail] = useState('')
  const [projectName, setProjectName] = useState('')
  const [description, setDescription] = useState('')

  // contatore delle proposte inviate con successo
  const [contatore, setContatore] = useState(0)

  // questa funzione viene chiamata quando l'utente clicca "Invia"
  const handleSubmit = (e: React.FormEvent) => {
    // preventDefault serve per evitare che la pagina si ricarichi quando invio il form
    e.preventDefault()

    // controllo che tutti i campi siano compilati
    if (!school || !level || !province || !className || !contactPerson || !email || !projectName || !description) {
      alert('Compila tutti i campi!')
      return
    }

    // creo l'oggetto con i dati da mandare
    const dati = {
      projectName,
      school,
      contactPerson,
      email,
      province,
      className,
      description,
      level: level === 'primo' ? 'FIRST' : 'SECOND'
    }

    // stampo i dati nella console del browser prima di inviarli
    console.log('=== DATI INVIATI AL BACKEND ===')
    console.log('Scuola:', school)
    console.log('Grado:', level)
    console.log('Provincia:', province)
    console.log('Classe:', className)
    console.log('Docente:', contactPerson)
    console.log('Email:', email)
    console.log('Progetto:', projectName)
    console.log('Descrizione:', description)
    console.log('===============================')

    // mando i dati al backend con una chiamata POST
    fetch('/api/sumbmissions/', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(dati)
    })
      .then(res => {
        if (res.ok) {
          // se è andato bene mostro un messaggio e pulisco il form
          alert('Registrazione inviata con successo!')
          setSchool(''); setLevel(''); setProvince(''); setClassName('')
          setContactPerson(''); setEmail(''); setProjectName(''); setDescription('')
          // aumento il contatore di 1
          setContatore(prev => prev + 1)
        } else {
          alert('Errore nell\'invio')
        }
      })
      .catch(() => alert('Errore di connessione al server'))
  }

  // qui ritorno l'HTML della pagina
  return (
    <div style={{backgroundColor: '#e8f5e9'}}>

      {/* SEZIONE HERO - è la parte verde in alto con il titolo e il bottone */}
      <div style={{backgroundImage: 'url(/sfondo2.png), url(/sfondo1.png), url(/sfondo3.jpg)', backgroundSize: '33% 100%, 34% 100%, 33% 100%', backgroundPosition: 'left center, center center, right center', backgroundRepeat: 'no-repeat, no-repeat, no-repeat', color: 'black', padding: '30px 20px 80px', textAlign: 'center'}}>
        <h1 style={{textShadow: '2px 2px 4px white, -1px -1px 3px white'}}>GreenTech</h1>
        <p style={{textShadow: '2px 2px 4px white, -1px -1px 3px white', fontWeight: 'bold'}}>Proponi la tua idea green per un futuro sostenibile!</p>
        {/* questo bottone porta l'utente alla sezione del form */}
        <a href="#registrazione" className="btn btn-warning mt-3" style={{fontSize: '1.2rem', padding: '10px 30px', boxShadow: '2px 2px 8px rgba(0,0,0,0.5)', fontWeight: 'bold'}}>Partecipa</a>
      </div>

      {/* container di bootstrap per centrare tutto */}
      <div className="container mt-4 text-center">

        {/* SEZIONE MISSIONE E VISIONE */}
        <h2>Missione e Visione</h2>
        <p>GreenTech vuole sensibilizzare gli studenti sulla sostenibilità ambientale raccogliendo idee innovative dalle scuole italiane.</p>
        <hr />

        {/* SEZIONE TECNOLOGIE VERDI */}
        <h2>Tecnologie Verdi</h2>
        <p>Energia solare, riciclo intelligente e agricoltura urbana sono le tecnologie che promuoviamo nelle scuole.</p>
        <hr />

        {/* SEZIONE TESTIMONIANZE */}
        <h2>Testimonianze</h2>
        <p><i>"Grazie a GreenTech abbiamo installato pannelli solari nella nostra scuola."</i> - Prof. Bianchi</p>
        <p><i>"Il progetto dell'orto ha coinvolto tutti gli studenti."</i> - Prof.ssa Rossi</p>
        <hr />

        {/* SEZIONE PREMI */}
        <h2>Premi</h2>
        <p>1° premio: borsa di studio da 5000€ | 2° premio: 3000€ | 3° premio: 1500€</p>
        <hr />

        {/* SEZIONE FORM DI REGISTRAZIONE */}
        <h2 id="registrazione">Registra la tua scuola</h2>
        {/* onSubmit chiama la funzione handleSubmit quando l'utente clicca invia */}
        <form onSubmit={handleSubmit} className="mb-4 mx-auto text-start" style={{maxWidth: '500px'}}>
          {/* ogni campo ha un value collegato allo stato e un onChange che aggiorna lo stato */}
          <div className="mb-2">
            <label className="form-label">Nome Scuola *</label>
            <input className="form-control" value={school} onChange={e => setSchool(e.target.value)} />
          </div>
          <div className="mb-2">
            <label className="form-label">Grado *</label>
            <select className="form-control" value={level} onChange={e => setLevel(e.target.value)}>
              <option value="">Seleziona...</option>
              <option value="primo">Primo Grado</option>
              <option value="secondo">Secondo Grado</option>
            </select>
          </div>
          <div className="mb-2">
            <label className="form-label">Provincia *</label>
            <input className="form-control" value={province} onChange={e => setProvince(e.target.value)} />
          </div>
          <div className="mb-2">
            <label className="form-label">Classe *</label>
            <input className="form-control" value={className} onChange={e => setClassName(e.target.value)} />
          </div>
          <div className="mb-2">
            <label className="form-label">Nome Docente *</label>
            <input className="form-control" value={contactPerson} onChange={e => setContactPerson(e.target.value)} />
          </div>
          <div className="mb-2">
            <label className="form-label">Email *</label>
            <input className="form-control" type="email" value={email} onChange={e => setEmail(e.target.value)} />
          </div>
          <div className="mb-2">
            <label className="form-label">Nome Progetto *</label>
            <input className="form-control" value={projectName} onChange={e => setProjectName(e.target.value)} />
          </div>
          <div className="mb-2">
            <label className="form-label">Descrizione *</label>
            <textarea className="form-control" rows={4} value={description} onChange={e => setDescription(e.target.value)}></textarea>
          </div>
          <button type="submit" className="btn btn-success">Invia</button>
        </form>
        <hr />

        {/* SEZIONE PROPOSTE - mostro solo il conteggio */}
        <h2>Proposte</h2>
        <p>Proposte inviate finora: <b>{contatore}</b></p>
      </div>

      {/* FOOTER */}
      <div style={{background: '#2d6a4f', color: 'white', textAlign: 'center', padding: '15px', marginTop: '30px'}}>
        <p className="mb-0">© 2024 GreenTech</p>
      </div>
    </div>
  )
}

// esporto il componente per usarlo in main.tsx
export default App
