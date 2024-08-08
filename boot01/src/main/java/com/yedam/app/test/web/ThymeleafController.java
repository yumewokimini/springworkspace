package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ThymeleafController {
	private EmpService empService;
	
	@GetMapping("thymeleaf")
	public String thymeleafTest(Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empService.empInfo(empVO);
		
//		값을 페이지로 전달함
//		empInfo 화면단에 다루는 변수
		model.addAttribute("empInfo", findVO);
		return "test";
	}
}
