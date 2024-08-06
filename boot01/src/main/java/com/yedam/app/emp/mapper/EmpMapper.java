package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회 (리턴 vo)
	public List<EmpVO> selectEmpAtllList();
	//단건조회 (리턴 vo)
	public EmpVO selectEmpInfo(EmpVO empVO);
	//등록 (리턴 정수) 
	public int insertEmpInfo(EmpVO empVO);
	//수정 (리턴 정수)
	public int updateEmpInfo(@Param("id")int empId, @Param("emp")EmpVO empVO);
	//삭제 (리턴 정수)
	public int deleteEmpInfo(int empId);
	
}
