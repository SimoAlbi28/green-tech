package it.greentech.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.greentech.persistence.entities.Submission;
import it.greentech.persistence.entities.Submission.Level;
import it.greentech.services.SubmissionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// questo è il controller REST, gestisce le richieste HTTP dal frontend
@RestController
@RequestMapping("/api/sumbmissions") // url base delle API (c'era un typo nel semilavorato, l'ho lasciato)
@CrossOrigin(origins = "*") // ho aggiunto questo per permettere le chiamate dal frontend
@Slf4j // per i log
public class SubmissionController {

	// Spring mi inietta il service automaticamente
	@Autowired
	private SubmissionService subSer;

	// classe per ricevere i dati dal form del frontend
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SubmissionData {
		private String projectName, school, contactPerson, email, province, className, description;
		private Level level;
	}

	// classe per mandare la lista delle proposte al frontend (solo i campi che servono)
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SubmissionListData {
		private String projectName, school, description;
	}

	// classe per la risposta dopo aver salvato una proposta
	@Data
	@AllArgsConstructor
	public static class SubmissionResult {
		private long id;
		private String projectName;
		private Date submissionDate;
	}

	// endpoint POST - riceve i dati dal form e li salva nel database
	// ho aggiunto @RequestBody per ricevere il JSON dal frontend
	@PostMapping("/")
	public SubmissionResult submit(@RequestBody SubmissionData data) {
		// loggo la richiesta
		log.info("ricevo la richiesta {}", data);

		// stampo tutti i dati nella console del server
		System.out.println("=== NUOVA PROPOSTA RICEVUTA ===");
		System.out.println("Progetto: " + data.getProjectName());
		System.out.println("Scuola: " + data.getSchool());
		System.out.println("Docente: " + data.getContactPerson());
		System.out.println("Email: " + data.getEmail());
		System.out.println("Provincia: " + data.getProvince());
		System.out.println("Classe: " + data.getClassName());
		System.out.println("Livello: " + data.getLevel());
		System.out.println("Descrizione: " + data.getDescription());
		System.out.println("===============================");

		// converto il livello da enum a int per salvarlo nel database
		int levelInt = data.getLevel() == Level.FIRST ? 1 : 2;

		// chiamo il service per salvare nel database
		Submission saved = subSer.submit(
			data.getProjectName(),
			data.getDescription(),
			data.getContactPerson(),
			data.getEmail(),
			data.getSchool(),
			data.getProvince(),
			data.getClassName(),
			levelInt
		);

		// ritorno l'id e la data della proposta salvata
		return new SubmissionResult(saved.getId(), data.getProjectName(), saved.getSubmissionDate());
	}

	// endpoint GET - ritorna tutte le proposte salvate nel database
	@GetMapping("/")
	public List<SubmissionListData> getAll() {
		// prendo tutte le submission dal database
		List<Submission> tutti = subSer.getAll();
		// creo una lista con solo i campi che mi servono per mostrarli nel frontend
		List<SubmissionListData> risultati = new ArrayList<>();
		for (Submission s : tutti) {
			risultati.add(new SubmissionListData(s.getTitle(), s.getSchool(), s.getDescription()));
		}
		return risultati;
	}

}
