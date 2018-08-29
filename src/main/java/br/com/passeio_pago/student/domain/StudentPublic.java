package br.com.passeio_pago.student.domain;

import java.io.Serializable;

public interface StudentPublic extends Serializable {
	public String getRegistrationId();

	public String getSchoolId();

	public String getFirstName();

	public String getLastName();

	public String getSchoolGrade();

	public String getClassIdentifier();
}
