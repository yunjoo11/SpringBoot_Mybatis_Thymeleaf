package com.joo.s1.error;

import java.sql.SQLDataException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	@ExceptionHandler(NullPointerException.class)
	public String getNull(Model model) {
		model.addAttribute("message", "Null 발생");
		return "error/500";
	}
	@ExceptionHandler(SQLDataException.class)
	public String getSql(Model model) {
		model.addAttribute("message", "DB 발생");
		return "error/500";
	}
	@ExceptionHandler(Exception.class)
	public String getException(Model model) {
		model.addAttribute("message", "Exception  발생");
		return "error/500";
	}
	
	@ExceptionHandler
	public String getMyException(Model model, Exception exception) {
		model.addAttribute("message", exception.getMessage());
		return "error/500";
	}
	
	@ExceptionHandler(Throwable.class)
	public String getAll(Model model) {
		model.addAttribute("message", "관리자에게 질문");
		return "error/500";
	}
	
	
}
