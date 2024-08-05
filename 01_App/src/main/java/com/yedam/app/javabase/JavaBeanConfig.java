package com.yedam.app.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//선언되어있는 메소드를 전부 실행함
@Configuration
public class JavaBeanConfig {
	
	//메소드 실행한 결과를 bean에 등록하겠음.
	@Bean
	public Chef cher() {
		return new Chef();
	}
	
	@Bean
	public Restaurant restaurant(Chef chef) {
		return new Restaurant(chef);
	}
	
}
