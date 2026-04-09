package it.greentech.persistence.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
	public static enum Level{FIRST,SECOND}
	private Long id;
	private String title, description, contactPerson, contactEmail, school, province, className;
	private int level;
	private Date submissionDate;
}
