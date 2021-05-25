package com.estudandoemcasa.curso.recursos.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudandoemcasa.curso.servicos.exceptions.RecursoNaoEncontradoException;

@ControllerAdvice
public class GerenciadorDeExceptions {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> recursosNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
		String erro =  "Recurso não ecnontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
