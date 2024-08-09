package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	private AaaMapper aaaMapper;
	
	@Autowired
	AaaServiceImpl(AaaMapper aaaMapper){
		this.aaaMapper = aaaMapper;
	}
	
	@Override
	@Transactional // 기본적으로 service 밑에 작동함 첫번째 할때는 주석 처리.. 
//	
	public void insert() {
		// TODO Auto-generated method stub
		aaaMapper.aaaInsert("101");
		aaaMapper.aaaInsert("a101");
	}
}
