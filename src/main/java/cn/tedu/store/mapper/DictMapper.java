package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	/**
	 * 查询所有省份信息
	 * @return
	 */
	List<Province> selectProvince();
	
	List<City> selectCity(String provinceCode);
	/**
	 *  查询所有区县
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	/**
	 * 通过省的编号查询省的名称
	 * @param provinceCode
	 * @return
	 */
	String selectByProvinceCode(String provinceCode);
	/**
	 * 通过城市的编号查询城市的名称
	 * @param cityCode
	 * @return
	 */
	String selectByCityCode(String cityCode);
	/**
	 * 通过区县的编号查询区县的名称
	 * @param areaCode
	 * @return
	 */
	String selectByAreaCode(String areaCode);
}
