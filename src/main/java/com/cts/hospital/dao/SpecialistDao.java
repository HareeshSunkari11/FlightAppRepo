package com.cts.hospital.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component;

import com.cts.hospital.exception.MyCustomExceptionHandleHospitalDetails;
import com.cts.hospital.exception.MyCustomExceptionHandleSpeialistDetails;
import com.cts.hospital.model.Appointment;
import com.cts.hospital.model.Specialist;

@Component
public class SpecialistDao {

	@Autowired
	private ConfigurableEnvironment environment;

	public List<Specialist> listOfSpecialist() {

		ResourcePropertySource source = (ResourcePropertySource) environment.getPropertySources().get("specialist");

		List<String> nameList = new ArrayList<String>();
		for (String name : source.getPropertyNames()) {
			if (name.endsWith("_doctorId")) {
				System.out.println(name.substring(0, name.indexOf("_")));
				nameList.add(name.substring(0, name.indexOf("_")));
			}
		}
		Collections.sort(nameList);

		List<Specialist> list = new ArrayList<Specialist>();

		for (String name : nameList) {
			String doctorId = (String) source.getProperty(name + "_doctorId");
			String doctorName = (String) source.getProperty(name + "_name");
			String doctorType = (String) source.getProperty(name + "_type");
			String availableday = (String) source.getProperty(name + "_availableday");
			String availableTime = (String) source.getProperty(name + "_availableTime");
			String isAvailable = (String) source.getProperty(name + "_isAvailable");
			String hospitalId = (String) source.getProperty(name + "_hospitalId");

			Specialist specialist = new Specialist();
			specialist.setDoctorId(new Long(doctorId));
			specialist.setName(doctorName);
			specialist.setType(doctorType);
			specialist.setAvailableday(availableday);
			specialist.setAvailableTime(availableTime);
			specialist.setHospitalId(new Integer(hospitalId));
			specialist.setIsAvailable(isAvailable);

			list.add(specialist);
		}
		return list;

	}

	@Cacheable(value = "specialistList")
	public List<Specialist> getBySpeicalistNameAndHospitalId(String type, int hospitalId) throws MyCustomExceptionHandleHospitalDetails {
		try {
			Specialist specialist = new Specialist();
			List<Specialist> specialistList = listOfSpecialist();
			List<Specialist> splist = specialistList.stream()
					.filter(c -> c.getType().equals(type) && c.getHospitalId() == hospitalId)
					.collect(Collectors.toList());
            if(splist.size()<=0)
            {
            	throw  new MyCustomExceptionHandleHospitalDetails();
            }
			return splist;
		} catch (Exception e) {
			throw new MyCustomExceptionHandleHospitalDetails();
		}

	}

	public Appointment bookAppointment(Specialist specialist, String patientName) throws MyCustomExceptionHandleSpeialistDetails {
		Appointment appointment = new Appointment();
		List<Appointment> appList = new ArrayList<>();
		List<Specialist> specialistList = listOfSpecialist();
		List<Specialist> splist = specialistList.stream()
				.filter(c -> c.getName().equals(specialist.getName())
						&& c.getAvailableday().equals(specialist.getAvailableday())
						&& c.getAvailableTime().equals(specialist.getAvailableTime()))
				.collect(Collectors.toList());
		if (splist.size()>0) {
			appointment.setSpecialistName(specialist.getName());
			appointment.setAppointmentDay(specialist.getAvailableday());
			appointment.setAppointmentTime(specialist.getAvailableTime());
			appointment.setPatientName(patientName);
			appList.add(appointment);

		}else {
			throw  new MyCustomExceptionHandleSpeialistDetails();
		}
		return appointment;

	}

}
