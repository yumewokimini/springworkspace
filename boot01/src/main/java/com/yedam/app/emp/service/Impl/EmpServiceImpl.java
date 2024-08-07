package com.yedam.app.emp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service
//@AllArgsConstructor
public class EmpServiceImpl implements EmpService{
	
	private EmpMapper empMapper;
	
//	1. 롬복 사용시 안써두됨 , 2.빈이 하나일때도 안써두되지만 명시적을위해서 작성 
	@Autowired
	EmpServiceImpl(EmpMapper empMapper){
		this.empMapper = empMapper;
	}
	
	
	@Override
	public Map<String, Object> empDelete(int empId) {
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(empId);
		
		//출력
		if(result ==1 ) {
			map.put("employeeId", empId);
		}
		
		//{}
		//{"employeeId" : 104 }
		return map;
	}
	
	
	@Override
	public EmpVO empInfo(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}
	
	@Override
	public int empInsert(EmpVO empVO) {
		// TODO Auto-generated method stub
		int result = empMapper.insertEmpInfo(empVO);
		
		return result == 1? empVO.getEmployeeId() : -1 ;
	}
	
	@Override
	public List<EmpVO> empList() {
		// TODO Auto-generated method stub
		return empMapper.selectEmpAtllList();
	}
	
	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result
			= empMapper.updateEmpInfo(empVO.getEmployeeId(), empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", empVO);
		
		return map;
	}	
}
