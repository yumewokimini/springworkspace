package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest //테스트 환경에서 IoC 컨테이너를 생성
class Boot01ApplicationTests {
	@Autowired //필드 주입 (기능구현시 사용금지 private는 외부 접근을 막지만 무시하고 작동시켜버림)
	EmpMapper empMapper;
	
	//전체조회
//	@Test
////	isEmpty 내부값이 비었는지 확인하는 메소드
//	void empList() { 
//		List<EmpVO> list = empMapper.selectEmpAtllList();
//		assertTrue(!list.isEmpty());
//	}
//	
	//단건조회
//	@Test
//	void empInfo() { 
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(100);
//		
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		assertEquals("King",findVO.getLastname());
//	}
//	
//	등록
//	@Test
//	void empInsert() {
//		EmpVO empVO = new EmpVO();
//		empVO.setLastName("Hond");
//		empVO.setEmail("KdHong@google.com");
//		empVO.setJobId("IT_PROG");
//		empVO.setSalary(1000);
//		
//		int result = empMapper.insertEmpInfo(empVO);
//		System.out.println(empVO.getEmployeeId());
//		
//		assertEquals(1,result);
//	}
	
//	업데이트
	@Test
	public void empUpdate() {
//	8	1) 대상 원래 데이터 조회 :단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(4321);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
//		2) 사용자가 수정하는 내용 입력
		findVO.setLastName("pang");
		
//		3) Update
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		assertEquals(1,result);
	}
	
	
	
//	삭제
//	@Test
//	public void empDelete() {
//		int result = empMapper.deleteEmpInfo(4322);
//		assertEquals(1,result);
//	}
	
	
}
