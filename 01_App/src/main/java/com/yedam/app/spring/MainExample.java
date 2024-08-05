package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv = (TV)ctx.getBean("tv");//리턴은 오브젝트
		tv.turnOn();
		
		TV subTv = (TV)ctx.getBean(TV.class);
		subTv.turnOn();
		
		if(tv == subTv) {// class 비교는 같은 인스턴스 인지 확인.(참조 위치 확인)
			System.out.println("같은 빈입니다.");
		}else {
			System.out.println("다른 빈입니다.");
		}
	}
}
