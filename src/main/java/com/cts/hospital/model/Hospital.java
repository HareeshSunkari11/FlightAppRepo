package com.cts.hospital.model;

import java.util.List;

public class Hospital {

	private int hospitalId;
	private String hospitalName;
	private int numberOfBeds;
	
	private List<Patient> patients;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hospitalId, String hospitalName, int numberOfBeds, List<Patient> patients) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.numberOfBeds = numberOfBeds;
		this.patients = patients;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	
}
