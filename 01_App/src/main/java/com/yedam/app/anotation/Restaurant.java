package com.yedam.app.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	private Chef chef;

	// 목적은 같음
	// 생성자는 한번 부르기 때문에 정확히 주입하고 종료 됨(기본적인 추천)
	// 세터는 내부가 계속 바뀔수 있음
	
	//생성자 인젝션 호출 
	@Autowired
	Restaurant(Chef chef) {
		this.chef = chef;
		System.out.println("생성자 인젝션");
	}
	
	//세터 인젝션
	Restaurant() {//기본생성자가 반듯이 필요해서 선언함.
		System.out.println("세터 인젝션");
	}
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	
	

	public void run() {
		chef.cooking();
	}
}
