package mediscreen_patient.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mediscreen_patient.Model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
