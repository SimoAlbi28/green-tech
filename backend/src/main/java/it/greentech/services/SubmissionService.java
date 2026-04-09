package it.greentech.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.greentech.persistence.entities.Submission;
import it.greentech.persistence.repositories.SubmissionRepository;

// questa classe contiene la logica per salvare e leggere le proposte
// prima i metodi restituivano null, io li ho completati per usare il repository
@Service
public class SubmissionService {

	// Spring inietta automaticamente il repository che ho creato
	@Autowired
	private SubmissionRepository repository;

	// questo metodo crea una nuova submission e la salva nel database
	public Submission submit(String title, String desc, String contact, String contactEmail, String school, String prov,
			String className, int level) {
		// creo un nuovo oggetto Submission e gli metto i dati
		Submission sub = new Submission();
		sub.setTitle(title);
		sub.setDescription(desc);
		sub.setContactPerson(contact);
		sub.setContactEmail(contactEmail);
		sub.setSchool(school);
		sub.setProvince(prov);
		sub.setClassName(className);
		sub.setLevel(level);
		sub.setSubmissionDate(new Date()); // metto la data di oggi
		// salvo nel database e ritorno l'oggetto salvato con l'id generato
		return repository.save(sub);
	}

	// questo metodo ritorna tutte le proposte salvate nel database
	public List<Submission> getAll(){
		return repository.findAll();
	}

}
