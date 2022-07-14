package mediscreen_patient.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mediscreen_patient.Exceptions.PatientNotFoundException;
import mediscreen_patient.Model.Patient;
import mediscreen_patient.Repositories.PatientRepository;
@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {
	@InjectMocks
	PatientServiceImpl patientService;

	@Mock
	PatientRepository patientRepository;

	@Test
	void testGetAllPatients() {
		List<Patient> listPatient = new ArrayList<Patient>();
		Patient p1 = new Patient(1L, "dia", "sekou", LocalDate.now(), "M", "10 rue de paris", "0609383041");
		Patient p2 = new Patient(2L, "dia", "aziz", LocalDate.now(), "M", "11 rue de paris", "0609383042");
		Patient p3 = new Patient(3L, "dia", "djen", LocalDate.now(), "F", "12 rue de paris", "0609383043");

		listPatient.add(p1);
		listPatient.add(p2);
		listPatient.add(p3);

		when(patientRepository.findAll()).thenReturn(listPatient);

		List<Patient> ptList = patientService.getAllPatients();

		assertEquals(3, ptList.size());
		verify(patientRepository, times(1)).findAll();

	}

	@Test
	void testGetPatientById() {
		Patient patient = new Patient(1L, "sekou", "dia", LocalDate.now(), "M", "10 rue paris", "0609383041");
		Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

		assertTrue(patientService.getPatientById(1L).toString().equalsIgnoreCase(patient.toString()));
	}

	@Test
	void testSavePatient() {
		Patient patient = new Patient(1L, "test1", "test1", LocalDate.now(), "M", "1 rue toto", "0600000000");
        patientService.savePatient(patient);
        verify(patientRepository, times(1)).save(patient);

	}

	@Test
	void testUpdatePatientWhenPatientExists() {
		 Patient patient = new Patient(1L, "test1", "test1", LocalDate.now(), "M", "1 rue toto", "0600000000");
	        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
	        when(patientRepository.save(patient)).thenReturn(patient);
	        patientService.updatePatient(1L,patient);

	        verify(patientRepository, times(1)).save(patient);
	}
	

	@Test
	void testDeletePatient() {
		when(patientRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(PatientNotFoundException.class, ()
                -> patientService.deletePatient(1L));

        assertThat(exception.getMessage()).isEqualTo("Patient not found with id : '1'");
        verify(patientRepository, times(1)).findById(1L);
	}

}
