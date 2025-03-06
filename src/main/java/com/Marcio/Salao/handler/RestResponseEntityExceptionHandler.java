package com.Marcio.Salao.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException1(APIException ex){
		return ex.buildErrorResponseEntity();
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception ex){
		log.error("Exception: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body (ErrorApiResponse.builder().description("INTERNALSERVER ERROR!")
						.message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA!").build());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorApiResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
		log.error("DataIntegrityViolationException: ", ex);
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(ErrorApiResponse.builder()
						.message("Dados duplicados.")
						.description("Já existe um salão com este nome, endereço ou telefone.")
						.build());
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorApiResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
		log.error("MethodArgumentTypeMismatchException: ", ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorApiResponse.builder()
						.message("ID inválido.")
						.description("O ID fornecido não está no formato correto (UUID).")
						.build());
	}
}
