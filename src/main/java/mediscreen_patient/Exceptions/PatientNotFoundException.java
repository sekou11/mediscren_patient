package mediscreen_patient.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class PatientNotFoundException extends RuntimeException {
	private final String resourceName;
	private final String fieldName;
	private final long fieldValue;
	
	 public PatientNotFoundException(String resourceName, String fieldName, long fieldValue) {
	        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); 
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        this.fieldValue = fieldValue;
	    }

}
