package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface IDictService {
	/**
	 * 获取省份
	 * @return
	 */
	List<Province> getProvince();
	/**
	 * 获取城市
	 * @param provinceCode
	 * @return
	 */
	List<City> getCity(String provinceCode);
	
	List<Area> getArea(String cityCode);
}
