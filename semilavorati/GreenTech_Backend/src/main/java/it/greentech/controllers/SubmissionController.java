package it.greentech.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public SubmissionResult submit(SubmissionData data) {
		log.info("ricevo la richiesta {}", data);
		// TODO: inserire i dati a DB e restituire l'id corretto
		return new SubmissionResult(123, data.getProjectName(), new Date());
	}

	@GetMapping("/")
	public List<SubmissionListData> getAll() {
		// TODO: estrarre i dati da DB
		return List.of(new SubmissionListData("p1", "scuola1", "...."),
				new SubmissionListData("p2", "scuola2", "...."));
	}

}
