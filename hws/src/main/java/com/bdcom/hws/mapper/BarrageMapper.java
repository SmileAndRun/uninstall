package com.bdcom.hws.mapper;

import java.sql.Date;
import java.util.List;

import com.bdcom.hws.model.Barrage;

public interface BarrageMapper {
	/**
	 * 获取所有弹幕
	 * @return
	 */
	public List<Barrage> getAllBar();
	/**
	 * 通过时间模糊获取部分弹幕
	 * @param time
	 * @return
	 */
	public List<Barrage> getListBarByTime(Date time);
	/**
	 * 通过id获取弹幕
	 */
	public Barrage getBarById(String id);
	/**
	 * 模糊查询（待定）
	 */
	public List<Barrage> getListBarByLike(String content);
}
