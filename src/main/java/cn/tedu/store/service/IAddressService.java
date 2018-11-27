package cn.tedu.store.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
//@Transactional表示接口的所有实现都实现事务
@Transactional
public interface IAddressService {
	/**
	 * 添加收货地址
	 * @param address
	 */
	 void addAddress(Address address);
	 /**
	  * 通过uid查询收货地址
	  * @param uid
	  * @return
	  */
	 List<Address> getByUid(Integer uid);
	 /**
	  * 设置默认地址
	  * @param uid
	  * @param id
	  */
	 void setDefault(Integer uid,Integer id);
	 /**
	  * 通过id获取地址信息
	  * @param id
	  * @return
	  */
	 Address getById(Integer id);
	 
	 void updateAddress(Address address);
	 
	 void removeAddress(Integer id);
}
