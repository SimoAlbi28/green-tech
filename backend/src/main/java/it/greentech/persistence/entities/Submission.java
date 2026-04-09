package it.greentech.persistence.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// questa classe rappresenta una riga nella tabella "submissions" del database
// ho aggiunto @Entity e @Table per dire a JPA che questa classe va salvata nel DB
@Data              // lombok mi genera automaticamente getter, setter e toString
@NoArgsConstructor // lombok mi genera il costruttore vuoto
@AllArgsConstructor // lombok mi genera il costruttore con tutti i parametri
@Entity            // dico a Spring che questa è un'entità del database
@Table(name = "submissions") // nome della tabella nel database
public class Submission {
	// enum per il grado della scuola
	public static enum Level{FIRST,SECOND}

	// id auto-generato dal database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// tutti i campi richiesti dalla traccia
	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 5000)
	private String description;

	@Column(nullable = false)
	private String contactPerson;

	@Column(nullable = false)
	private String contactEmail;

	@Column(nullable = false)
	private String school;

	@Column(nullable = false)
	private String province;

	@Column(nullable = false)
	private String className;

	@Column(nullable = false)
	private int level;

	// data di quando viene inviata la proposta
	@Column
	private Date submissionDate;
}
