package mediscreen_patient.Service;

import java.util.List;

import mediscreen_patient.Exceptions.PatientNotFoundException;
import mediscreen_patient.Model.Patient;

public interface PatientService {
	public List<Patient>getAllPatients();
	public Patient savePatient(Patient patient);
	public Patient updatePatient( Long id,Patient patient ) throws PatientNotFoundException;
	public void deletePatient(Long id) throws PatientNotFoundException;
	public Patient getPatientById(Long id) throws PatientNotFoundException;

}
