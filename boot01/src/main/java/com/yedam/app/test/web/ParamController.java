package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@CrossOrigin(origins = "*")
@Controller
public class ParamController {
	// QueryString(질의 문자열) : key=value&key=value...
	// Content-type : application/x-www-form-rulencode
	// Method : 상관없음

	// QueryStirng => 커맨드 객체 (어노테이션X 객체)
	@RequestMapping(path = "comobj", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String commandObjectString(EmpVO empVO) {
		String result = "";
		result += "Path : /comobj \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}

	// QueryStirng => @RequestParam : 기본타입, 단일값
	
	@RequestMapping(path = "reqparm", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String requestParam(
			@RequestParam Integer employeeId, 
			              String lastName,//lastname은 param이 없어서 생량 가능
			@RequestParam (name = "message", 
			               defaultValue =	 "No message", 
			               required = true) String msg) {//변수가 가지고 있는 msg는 사용하지 않음.
		String result = "";
		result += "Path : /reqparm \n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " +lastName;
		result += "\t message : " + msg;
		return result;
	}
	
	//@PathVariable : 경로에 값을 포함하는 방식, 단일값
	// Method,Content -type는 상관없음
	@RequestMapping("path/{id}")//path/Hong,path/1234
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result = "";
		result += "path : /path/{id} \n";
		result += "\t id : " +id;
		return result;
	}
	
	//@RequestBody : Json 포맷, or 객체
	//Method : post,put
	//Content-type : application/json
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = "path : /resbody \n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		return result;
	}
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList
		(@RequestBody List<EmpVO> list) {
		String result = "path :/resbodyList \n";
		for(EmpVO empVO : list) {
			result += "\t employee_id : " + empVO.getEmployeeId();
			result += "\t last_name : " + empVO.getLastName();
			result += "\n";
		}
		return result;
	}
}
