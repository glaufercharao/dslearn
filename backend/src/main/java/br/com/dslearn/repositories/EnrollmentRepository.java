package br.com.dslearn.repositories;

import br.com.dslearn.entities.Enrollment;
import br.com.dslearn.entities.pk.EnrollmentPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPk> {
}
