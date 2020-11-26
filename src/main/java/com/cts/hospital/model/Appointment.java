package com.cts.hospital.model;

public class Appointment {

	private String appointmentDay;
	private String appointmentTime;
	private String specialistName;
	private String patientName;
	
	
	public Appointment() {
		super();
	}
	
	public Appointment(String appointmentDay, String appointmentTime, String specialistName, String patientName) {
		super();
		this.appointmentDay = appointmentDay;
		this.appointmentTime = appointmentTime;
		this.specialistName = specialistName;
		this.patientName = patientName;
	}


	public String getAppointmentDay() {
		return appointmentDay;
	}
	public void setAppointmentDay(String appointmentDay) {
		this.appointmentDay = appointmentDay;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getSpecialistName() {
		return specialistName;
	}
	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentDay=" + appointmentDay + ", appointmentTime=" + appointmentTime
				+ ", specialistName=" + specialistName + ", patientName=" + patientName + "]";
	}
	
	
	
}
