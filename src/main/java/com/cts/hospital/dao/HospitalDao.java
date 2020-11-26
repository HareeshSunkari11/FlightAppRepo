package com.cts.hospital.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.cts.hospital.model.Hospital;
import com.cts.hospital.model.Patient;

@Component
public class HospitalDao {

	private static List<Patient> apploPatients = new ArrayList<>();
	private static int idIndex = 5;

	static {
		apploPatients.add(new Patient(1, "Raj", "Male", "Admitted"));
		apploPatients.add(new Patient(2, "Kiran", "Male", "DISCHARGE"));
		apploPatients.add(new Patient(3, "Keerthi", "female", "DISCHARGE"));
		apploPatients.add(new Patient(4, "Krinhna", "Male", "Admitted"));
		apploPatients.add(new Patient(5, "Test", "Female", "Admitted"));

	}
	private static List<Patient> nimsPatients = new ArrayList<>();
	static {
		nimsPatients.add(new Patient(1, "Raj", "Male", "Admitted"));
		nimsPatients.add(new Patient(2, "Kiran", "Male", "DISCHARGE"));
		nimsPatients.add(new Patient(3, "Keerthi", "female", "DISCHARGE"));
		nimsPatients.add(new Patient(4, "Krinhna", "Male", "Admitted"));
		nimsPatients.add(new Patient(5, "Raju Kumar", "Male", "Admitted"));

	}

	private static List<Hospital> hospList = new ArrayList<>();
	static {
		hospList.add(new Hospital(1, "Appolo", 10, apploPatients));
		hospList.add(new Hospital(2, "NIMS", 12, nimsPatients));
	}

	
	public static List<Hospital> listOfHospitals() {
		List<Hospital>  splist1= new ArrayList<Hospital>();
		
		for(Hospital hospital:hospList) {
			splist1.add(hospital);
		}
		return hospList;
	}

	public String numberOfAvailableBeds( String hospitalName) {
		List<Hospital> filterHospitalList = hospList.stream()
				.filter(h -> h.getHospitalName().equals(hospitalName)).collect(Collectors.toList());
		
		List<Patient> pList=filterHospitalList.stream().flatMap(p->p.getPatients().stream()
				.filter(c->c.getStatus().equals("DISCHARGE"))).collect(Collectors.toList());
		int discharged = pList.size();
		List<Patient> appointed=filterHospitalList.stream().flatMap(p->p.getPatients().stream()
				.filter(c->c.getStatus().equals("Admitted"))).collect(Collectors.toList());
		int admittedCount = appointed.size();
		
		Hospital hosp= filterHospitalList.stream().filter(p1->p1.getNumberOfBeds()>= 0 ).findAny().get();
		int availBeds=hosp.getNumberOfBeds();
		
		int numberavaible= (availBeds-admittedCount)+discharged;
		
		String availablebeds="Number of Beds Available "+numberavaible;
		return availablebeds;

	}
}
