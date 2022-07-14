package mediscreen_patient.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient", uniqueConstraints = @UniqueConstraint(name = "UniqueFirstNameAndLastNameAndBirthDate", columnNames = {
		"first_name", "last_name", "birthdate" }))
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotBlank(message = "FirstName should not be blank")
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "LastName should not be blank")
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "birthdate should not be blank")
	@Column(name = "birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;

	@NotNull(message = "Sex should not be blank")
	@Column(name = "sex", length = 1)
	private String sex;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

}
