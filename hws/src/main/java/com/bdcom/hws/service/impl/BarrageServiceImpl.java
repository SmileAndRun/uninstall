package com.bdcom.hws.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdcom.hws.mapper.BarrageMapper;
import com.bdcom.hws.model.Barrage;
import com.bdcom.hws.service.BarrageService;

@Service
public class BarrageServiceImpl implements BarrageService{

	@Autowired
	private BarrageMapper barrMapper;
	
	@Override
	public List<Barrage> getAllBar() {
		
		return barrMapper.getAllBar();
	}

	@Override
	public List<Barrage> getListBarByTime(Date time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Barrage getBarById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Barrage> getListBarByLike(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
