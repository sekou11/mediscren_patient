package mediscreen_patient;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import mediscreen_patient.Model.Patient;
import mediscreen_patient.Repositories.PatientRepository;

@SpringBootApplication
@EnableSwagger2
public class MediscrenPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediscrenPatientApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(PatientRepository patientRepository) {
		return args -> {
            patientRepository.save(new Patient(1L, "dia", "sekou", LocalDate.now(),
            								"M", "10 rue de paris", "0601383041"));
            
            patientRepository.save(new Patient(2L, "dia", "aziz", LocalDate.now(),
					"M", "10 rue de paris", "0601383042"));
            
            patientRepository.save(new Patient(3L, "dia", "djen", LocalDate.now(),
					"F", "10 rue de paris", "0601383045"));
            
            patientRepository.findAll().forEach(p->{
    			System.out.println( "lastName : "+p.getLastName());
    		});
		};
		
		

	}

}
