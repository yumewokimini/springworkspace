package com.yedam.app.anotation;

import org.springframework.stereotype.Component;

@Component //빈으로 등록하겠다는 선언
public class Chef {
	public void cooking() {
		System.out.println("spring 어노테이션 방식");
	}
}
