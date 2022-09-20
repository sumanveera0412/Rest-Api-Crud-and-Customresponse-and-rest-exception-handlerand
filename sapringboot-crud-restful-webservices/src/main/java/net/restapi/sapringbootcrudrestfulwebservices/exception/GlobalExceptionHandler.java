package net.restapi.sapringbootcrudrestfulwebservices.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice()
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	
	//hhandling the specific exceptions
	public ResponseEntity<?> handleResourseNotFoundException
	(ResourceNotFoundException exception,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return  new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
@ExceptionHandler(APIException.class)
	
	//hhandling the API exceptions
	public ResponseEntity<?> handleAPIException
	(APIException exception,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return  new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	//global exception handling
@ExceptionHandler(Exception.class)
	
	public ResponseEntity<?> handleGlobalException
	(Exception exception,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return  new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	};
}
