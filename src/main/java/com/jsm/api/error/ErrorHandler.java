package com.jsm.api.error;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value= {ObjectNotFoundException.class})
	public ResponseEntity<List<DefaultError>> ObjectNotFoundExceptionHandler(ObjectNotFoundException ex,HttpServletRequest request) {
		DefaultError erro = new DefaultError()
				.setError("Não Encontrado!").setMessage(ex.getMessage()).
				setPath(request.getRequestURI()).setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value()).setTimestamp(System.currentTimeMillis());
		List<DefaultError> erros = new ArrayList<>();
		erros.add(erro);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erros);
				
	}
}
