package com.yedam.app.common.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class webControllerAdvice {

	//보조작업 
	//이클립스 내부에 발생하는 컨트롤러에 예외없이(예외처리) 모든 컨트롤러를 지원
		
	
	//전역변수를 선언 하는 느낌 
	@ModelAttribute("contextPath")
	public String contextPath
			(final HttpServletRequest request) { 
		return request.getContextPath();
	}
}
