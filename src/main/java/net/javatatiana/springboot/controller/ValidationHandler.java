package net.javatatiana.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{  //arroja los errores de la validacion lo va almacenar error
			
			String fieldName = ((FieldError) error).getField(); //clave
			String message = error.getDefaultMessage(); // mensaje de error  de la validacion y muestra el error que encontro
			errors.put(fieldName, message);// se le pasa al hash la clave y el mensaje
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST); //devuelve todos los posible mensajes de error
	}
	
	

}