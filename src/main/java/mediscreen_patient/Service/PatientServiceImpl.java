package mediscreen_patient.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediscreen_patient.Exceptions.PatientNotFoundException;
import mediscreen_patient.Model.Patient;
import mediscreen_patient.Repositories.PatientRepository;
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {

		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Long id,Patient patientToUpdated) throws PatientNotFoundException {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient", "id", id));

		patient.setFirstName(patientToUpdated.getFirstName());
		patient.setLastName((patientToUpdated.getLastName()));
		patient.setBirthdate(patientToUpdated.getBirthdate());
		patient.setSex(patientToUpdated.getSex());
		patient.setAddress(patientToUpdated.getAddress());
		patient.setPhone(patientToUpdated.getPhone());

		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(Long id) throws PatientNotFoundException {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient", "id", id));
		

		patientRepository.delete(patient);

	}

	@Override
	public Patient getPatientById(Long id) throws PatientNotFoundException {
		return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient", "id", id));
	}


}
