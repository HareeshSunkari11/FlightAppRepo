package com.cts.hospital.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Specialist {
	private Long doctorId;
	private String name;
	private String type;
	private String availableday;
	private String availableTime;
	private String isAvailable;
	private int hospitalId;

	public Specialist() {
		super();
	}

	public Specialist(Long doctorId, String name, String type, String availableday, String availableTime,
			String isAvailable, int hospitalId) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.type = type;
		this.availableday = availableday;
		this.availableTime = availableTime;
		this.isAvailable = isAvailable;
		this.hospitalId = hospitalId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAvailableday() {
		return availableday;
	}

	public void setAvailableday(String availableday) {
		this.availableday = availableday;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "Specialist [doctorId=" + doctorId + ", name=" + name + ", type=" + type + ", availableday="
				+ availableday + ", availableTime=" + availableTime + ", isAvailable=" + isAvailable + ", hospitalId="
				+ hospitalId + "]";
	}

}
