package it.greentech.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/sumbmissions")
@CrossOrigin(origins = "*")
@Slf4j
public class SubmissionController {

	@Autowired
	private SubmissionService subSer;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SubmissionData {
		private String projectName, school, contactPerson, email, province, className, description;
		private Level level;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SubmissionListData {
		private String projectName, school, description;
	}

	@Data
	@AllArgsConstructor
	public static class SubmissionResult {
		private long id;
		private String projectName;
		private Date submissionDate;
	}

	@PostMapping("/")
	public SubmissionResult submit(@RequestBody SubmissionData data) {
		log.info("ricevo la richiesta {}", data);

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

		return new SubmissionResult(123, data.getProjectName(), new Date());
	}

	@GetMapping("/")
	public List<SubmissionListData> getAll() {
		return List.of(new SubmissionListData("p1", "scuola1", "...."),
				new SubmissionListData("p2", "scuola2", "...."));
	}

}
