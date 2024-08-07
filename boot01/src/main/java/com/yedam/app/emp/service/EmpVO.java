package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode

public class EmpVO {
	// employee_id => employeeId 그렇기 때문에 못 읽음 
	// (application.properties 의 mybatis.configuration.map-underscore-to-camel-case=true)
	// null 값 관련 Integer
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//핸들러에서 받아서 넘길때 사용 ,중복사용불가
	
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	
}
