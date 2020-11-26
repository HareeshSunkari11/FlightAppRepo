package com.cts.hospital.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cts.hospital.model.Hospital;
import com.cts.hospital.model.Patient;

public class Test {

	public static void main(String[] args) {
		Test test= new Test();
		test.numberOfAvailableBeds();
	}
	private static List<Patient> apploPatients = new ArrayList<>();
	private static int idIndex = 5;
	
	static {
		apploPatients.add(new Patient(1, "Raj", "Male", "Admitted"));
		apploPatients.add(new Patient(2, "Kiran", "Male", "Discharged"));
		apploPatients.add(new Patient(3, "Keerthi", "female", "Discharged"));
		apploPatients.add(new Patient(4, "Krinhna", "Male", "Admitted"));
		
	}
	private static List<Patient> nimsPatients = new ArrayList<>();
	static {
		nimsPatients.add(new Patient(1, "Raj", "Male", "Admitted"));
		nimsPatients.add(new Patient(2, "Kiran", "Male", "Discharged"));
		nimsPatients.add(new Patient(3, "Keerthi", "female", "Discharged"));
		nimsPatients.add(new Patient(4, "Krinhna", "Male", "Admitted"));
		
	}
	
	private static List<Hospital> hospList = new ArrayList<>();
	static {
		hospList.add(new Hospital(1, "Appolo", 10, apploPatients));
		hospList.add(new Hospital(2, "NIMS", 12, nimsPatients));
	}
	
	public int numberOfAvailableBeds() {
		Hospital hospital = new Hospital();
		Patient patient = new Patient();
		List<Hospital> hospList = new ArrayList<Hospital>();

		for (Hospital hospitals : hospList) {
			hospList.add(hospitals);
		}
		
		List<Hospital> filterHospitalList = hospList.stream().
				filter(h->h.getHospitalName().equals(hospital.getHospitalName())).collect(Collectors.toList());
		List<Hospital> pp=   (List<Hospital>) filterHospitalList.stream()
				.filter(p->p.getPatients().equals(patient.getStatus().equals("Discharged")));
		int availableBeds=pp.size();
		
		return availableBeds;
		
	}

}
