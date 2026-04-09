package it.greentech.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.greentech.persistence.entities.Submission;

// ho creato questa interfaccia per poter salvare e leggere i dati dal database
// estendendo JpaRepository ho già i metodi save(), findAll(), findById() ecc. senza scriverli
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
