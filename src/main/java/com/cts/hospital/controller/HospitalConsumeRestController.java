package com.cts.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.hospital.exception.MyCustomExceptionHandleHospitalDetails;

@RestController
@RequestMapping("/template")
public class HospitalConsumeRestController{

	@Autowired
	RestTemplate restTemplate;

	@Value("${getSpecialisttUrl}")
	private String getSpecialisttUrl;

	/**
	 * Get the List of available specialist based on type, hospital id
	 * @param type
	 * @param hospitalId
	 * @return
	 * @throws MyCustomExceptionHandleHospitalDetails
	 */
	@RequestMapping(value = "specialists/{type}/{hospitalId}", 
			produces = { "application/json","application/xml"})
	public String getSpecialistList(@PathVariable("type") String type, @PathVariable("hospitalId") int hospitalId)
			throws MyCustomExceptionHandleHospitalDetails {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/xml");
		RestTemplate restTemplate = new RestTemplate();
		String spclialistUrl = getSpecialisttUrl + type + "/" + hospitalId;
		String response = restTemplate.getForObject(spclialistUrl, String.class);
		return response;
	}

}
