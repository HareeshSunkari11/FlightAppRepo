package com.cts.hospital.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MyCustomExceptionHandleHospitalDetails.class)
	protected ResponseEntity<Object> handleHospitalDetailsNotFound(MyCustomExceptionHandleHospitalDetails hospitalHandle) {
		//String bodyOfResponse = "This should be application specific";
		return new ResponseEntity<Object> (hospitalHandle.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MyCustomExceptionHandleSpeialistDetails.class)
	protected ResponseEntity<Object> handleSpecialistDetailsNotFound(MyCustomExceptionHandleSpeialistDetails specialistHandle) {
		//String bodyOfResponse = "This should be application specific";
		return new ResponseEntity<Object> (specialistHandle.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
