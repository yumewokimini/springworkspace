package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yedam.app.emp.service.EmpVO;

@Aspect //aop 설정을 가지고 있지만 일반 빈이랑 똑같음 
@Component
public class CommonAspect {
	//포인트 컷 : 조인포인트 중에서 advice(횡단관심)이 적용될 메소드 필터
	@Pointcut("within(com.yedam.app.emp.service.Impl.*)")//검색조건  within(com.yedam.app.emp.service.Impl.*) 지정한 경로 아래의 모든 것
	public void empPointCut() {} //메핑되는 것, 메소드가 적용되는곳은 비어짐
	
	// weaving : 포인트 컷 + 타이밍 + Advice(횡단관심)
	
	
	@Before("empPointCut()") // 비지니스가 동작하기전에 동작함
	public void beforeAdvice(JoinPoint joinPoint) {//joinPoint 서비스 메소드
		String sinagerStr = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();//Args로넘어오는 값은 OBject로 받음
		System.err.println("###### 실행 : " + sinagerStr);
		for(Object arg : args) {
			System.err.println("매개변수");
			if(arg instanceof Integer) {
				System.err.println((Integer)arg);
			}else if(arg instanceof EmpVO) {
				System.err.println((EmpVO)arg);
			}
		}
	}
	
	@Around("empPointCut()")//@Before보다 먼저 실행됨
	public Object executeTime(ProceedingJoinPoint joinPoint) throws Throwable{ //aound만 사용 가능, ProceedingJoinPoint 실제로 실행하고 있는 메소드를 실행함
		String signaterStr = joinPoint.getSignature().toString();
		System.out.println("=== 시작: " + signaterStr);
		
		//공통기능
		System.out.println("=== 핵심 기능 전 실행 : " + System.currentTimeMillis());
		
		try {
			//비즈니스 메소드 실행
			Object obj = joinPoint.proceed();
			return obj;
		}finally {
			//공통기능
			System.out.println("=== 핵심 기능 후 실행 " + System.currentTimeMillis());
			System.out.println("=== 끝 : " + signaterStr);
		}
	}
	
}
