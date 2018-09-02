package br.com.passeio_pago.student.domain.entity;

import java.io.Serializable;

public class StudentEntityPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1753516632915295476L;

	public String registrationId;
	public String schoolId;

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationId == null) ? 0 : registrationId.hashCode());
		result = prime * result + ((schoolId == null) ? 0 : schoolId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntityPK other = (StudentEntityPK) obj;
		if (registrationId == null) {
			if (other.registrationId != null)
				return false;
		} else if (!registrationId.equals(other.registrationId))
			return false;
		if (schoolId == null) {
			if (other.schoolId != null)
				return false;
		} else if (!schoolId.equals(other.schoolId))
			return false;
		return true;
	}

}
