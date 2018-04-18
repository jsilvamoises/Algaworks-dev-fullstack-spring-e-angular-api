package com.jsm.api.error;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@Autowired
	private MessageSource source;

	@ExceptionHandler(value = { ObjectNotFoundException.class })
	public ResponseEntity<List<DefaultError>> ObjectNotFoundExceptionHandler(ObjectNotFoundException ex,
			HttpServletRequest request) {
		
		DefaultError erro = new DefaultError().setError(getMessage("msg.error.nao_encontrado"))
				.setMessage(ex.getMessage()).setPath(request.getRequestURI())
				.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value()).setTimestamp(System.currentTimeMillis());
		
		List<DefaultError> erros = new ArrayList<>();
		erros.add(erro);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erros);

	}

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public ResponseEntity<List<DefaultError>> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex,
			HttpServletRequest request) {
		
		DefaultError erro = new DefaultError().setError(getMessage("msg.error.campos_invalidados"))
				.setMessage(ex.getMessage()).setPath(request.getRequestURI())
				.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value()).setTimestamp(System.currentTimeMillis());
		
		List<DefaultError> erros = new ArrayList<>();
		erros.add(erro);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erros);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<List<DefaultError>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		List<DefaultError> errors = null;

		ErrorField field = new ErrorField();
		field.setError("Campos inválidos")
		.setMessage("Verifique os campos")
		.setPath(request.getRequestURI())
		.setStatus(HttpStatus.BAD_REQUEST.value())
				.setTimestamp(System.currentTimeMillis());

		errors = buildErrorFieldList(field, ex.getBindingResult());

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errors);
	}

	public List<DefaultError> buildErrorFieldList(ErrorField ferror, BindingResult result) {
		List<DefaultError> erros = new ArrayList<>();
		for (FieldError fe : result.getFieldErrors()) {
			ferror.getFields().add(new ObjectField(fe.getField(),fe.getField()+" "+ fe.getDefaultMessage()));
		}

		erros.add(ferror);

		return erros;

	}

	private String getMessage(String key) {
		String msg = source.getMessage(key, null, LocaleContextHolder.getLocale());
		return msg;
	}
}
