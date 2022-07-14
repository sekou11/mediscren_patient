package mediscreen_patient.Exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
	private final Date timestamp;
	private final String message;
	private final String details;

}
