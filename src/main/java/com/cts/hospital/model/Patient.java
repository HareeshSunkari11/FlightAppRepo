package com.cts.hospital.model;

public class Patient {
	
	private long patientId;
	private String name;
	private String gender;
	private String status;
	
	public Patient() {
		super();
	}
	
	public Patient(long patientId, String name, String gender, String status) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.gender = gender;
		this.status = status;
	}


	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", gender=" + gender + ", status=" + status + "]";
	}


}
