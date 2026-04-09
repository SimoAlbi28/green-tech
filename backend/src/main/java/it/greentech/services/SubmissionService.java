package it.greentech.services;

import java.util.List;
import org.springframework.stereotype.Service;
import it.greentech.persistence.entities.Submission;

@Service
public class SubmissionService {

	public Submission submit(String title, String desc, String contact, String contactEmail, String school, String prov,
			String className, int level) {
		return null;
	}

	public List<Submission> getAll(){
		return null;
	}

}
