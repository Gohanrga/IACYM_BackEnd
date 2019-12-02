package com.acym.resource;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.ErrorMessage;
import com.acym.resource.exceptions.UsuarioIdNoEncontrado;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({UsuarioIdNoEncontrado.class})
	@ResponseBody
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({CampoVacio.class})
	@ResponseBody
	public ErrorMessage badRequest(Exception exception) {
		return new ErrorMessage(exception, "");
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({AccessDeniedException.class})
	@ResponseBody
	public ErrorMessage forbiddenRequest(Exception exception) {
		return new ErrorMessage(exception, "");
	}
	
}
