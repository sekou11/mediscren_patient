package mediscreen_patient.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mediscreen_patient.Model.Patient;
import mediscreen_patient.Service.PatientService;
@RestController

@RequestMapping("/patient")
public class PatientController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	 @GetMapping("/")
	    public ResponseEntity<String> home() {
	        return new ResponseEntity<> ("Welcome to Patient Informations..........",HttpStatus.OK);
	    }
	 
	 @GetMapping(path = "/list")
	 public ResponseEntity<List<Patient>> allPatients(){
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("responded", "PatientController");
		 List<Patient>patients= patientService.getAllPatients();
		 return ResponseEntity.accepted().headers(headers).body(patients);
	 }
	 
	 @GetMapping(path = "/{id}")
	 public ResponseEntity<Patient> PatientgetPatientById(@PathVariable(name = "id") Long id){
		 Patient patientById = patientService.getPatientById(id);
		 return ResponseEntity.ok().body(patientById);
	 }
	 
	 @PostMapping(path = "/save")
	 public ResponseEntity<Patient> PatientSave(@Valid @RequestBody Patient patient){
		 Patient savePatient = patientService.savePatient(patient);
		 return new ResponseEntity<Patient>(savePatient, HttpStatus.CREATED);
	 }
	 
	 @PutMapping(path = "/update/{id}")
	 public ResponseEntity<Patient> UpdatePatient(@PathVariable("id") Long id ,@RequestBody Patient patient){
		 Patient patientResponse = patientService.updatePatient(id, patient);
		 return ResponseEntity.ok(patientResponse);
	 }
	 
	 @GetMapping(path = "/delete/{id}")
	 public void deletePatient(@PathVariable("id") Long id ){
		  patientService.deletePatient(id);
	 }

}
