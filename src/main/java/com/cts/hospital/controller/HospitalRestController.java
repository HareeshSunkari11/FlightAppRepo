package com.cts.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hospital.dao.HospitalDao;
import com.cts.hospital.dao.SpecialistDao;
import com.cts.hospital.exception.MyCustomExceptionHandleHospitalDetails;
import com.cts.hospital.exception.MyCustomExceptionHandleSpeialistDetails;
import com.cts.hospital.model.Appointment;
import com.cts.hospital.model.Hospital;
import com.cts.hospital.model.Patient;
import com.cts.hospital.model.Specialist;

/**
 * HospitalRestController
 * @author 602041
 *
 */
@RestController
@RequestMapping("/api")
public class HospitalRestController {

	@Autowired
	private SpecialistDao specialistDao;

	@Autowired
	private HospitalDao hospitalDao;

	/**
	 * Fetch the  of specialists available in Hospital
	 * @return List<Specialist>
	 */
	@RequestMapping(value = "/specialists", method = RequestMethod.GET, 
			produces = { "application/json","application/xml"})
	public List<Specialist> list() {
		return specialistDao.listOfSpecialist();
	}

	/**
	 * Fetch the available specialist detail  
	 * @param type
	 * @param hospitalId
	 * @return List<Specialist> based on Hospital Id,Specialist Type
	 * @throws MyCustomExceptionHandleHospitalDetails
	 */
	@RequestMapping(value = "/specialists/{type}/{hospitalId}", 
			produces = { "application/json","application/xml"})
	public List<Specialist> getByTypeAndHospital(@PathVariable("type") String type, @PathVariable("hospitalId") int hospitalId)
			throws MyCustomExceptionHandleHospitalDetails {

		return specialistDao.getBySpeicalistNameAndHospitalId(type, hospitalId);
	}

	
	@PostMapping(value="/bookAppointment/{patientName}")
	public Appointment bookAppointment(@RequestBody Specialist specialist, @PathVariable("patientName") String patientName)
			throws MyCustomExceptionHandleSpeialistDetails {

		return specialistDao.bookAppointment(specialist, patientName);
	}

	/**
	 * Fetch the numberOfBeds available in the Hospital
	 * @param hospitalName
	 * @return int numberOfAvailableBeds
	 */
	@RequestMapping(value="/hospitals/{hospitalName}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public String numberOfAvailableBeds(@PathVariable("hospitalName") String hospitalName) {

		return hospitalDao.numberOfAvailableBeds(hospitalName);

	}

}
