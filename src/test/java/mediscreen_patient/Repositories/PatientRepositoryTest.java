package mediscreen_patient.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mediscreen_patient.Model.Patient;

@SpringBootTest
class PatientRepositoryTest {
	@Autowired
	PatientRepository patientRepository;
	
	  @BeforeEach
      void testwitdeleteAllPatients() {
    	  patientRepository.deleteAll();
      }
	  
	@Test
	public void PatientTest(){
		
		Patient patient = new Patient(1L, "dia", "sekou", LocalDate.now(), "M", "10 rue de paris", "0601383045");
		
		//save
		patient = patientRepository.save(patient);
		Assertions.assertNotNull(patient.getId());
		Assertions.assertEquals(patient.getFirstName(), "dia");
		Assertions.assertEquals(patient.getLastName(), "sekou"); 
		
		//Update
		patient.setFirstName("dioubate");
		patient.setLastName("momo");
		patient = patientRepository.save(patient);
		Assertions.assertEquals(patient.getFirstName(), "dioubate");
		Assertions.assertEquals(patient.getLastName(), "momo"); 
		
		// Find
		List<Patient> listPatient = patientRepository.findAll();
		Assertions.assertTrue(listPatient.size() > 0);
		
		// Delete
//	Long id = patient.getId();
//		patientRepository.delete(patient);
//	Optional<Patient> patientId = patientRepository.findById(id);
//	Assertions.assertFalse(patientId.isPresent());

		

	


	}
}
