package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	void insertAddress(Address address);
	/**
	 * 查询用户的收货地址
	 * @param uid
	 * @return
	 */
	List<Address> selectByUid(Integer uid);
	
	Integer updateByUid(Integer uid);
	
	Integer updateById(Integer id);
	
	Address selectById(Integer id);
	/**
	 * 通过id修改地址信息
	 * @param address
	 */
	void updateAddressById(Address address);
	
	void deleteById(Integer id);
}
