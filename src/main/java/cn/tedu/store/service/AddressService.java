package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	
	
	
	public void addAddress(Address address) {
		//给address对象的recvDistrict调用持久层的方法
		address.setRecvDistrict(this.getDistrict(address));
		Integer count = addressMapper.selectByUid(address.getUid()).size();
		if(count==0) {
			address.setIsDefault(1);
		}else {
			address.setIsDefault(0);
		}
			
		addressMapper.insertAddress(address);
	}
	
	
	public List<Address> getByUid(Integer uid) {
		
		return addressMapper.selectByUid(uid);
	}

	//ssm处理事务，默认RuntimeException自动回滚
	public void setDefault(Integer uid, Integer id) {
		Integer n1 = addressMapper.updateByUid(uid);
		if(n1==0) {
			throw new RuntimeException("uid修改错误");
		}
		Integer n2 = addressMapper.updateById(id);
		if(n2==0) {
			throw new RuntimeException("id修改错误");
		}
	
	}


	public Address getById(Integer id) {
		return addressMapper.selectById(id);
	}


	public void updateAddress(Address address) {
		//1.给address的recvDistrict属性赋值
		address.setRecvDistrict(this.getDistrict(address));
		//2.调用持久层的方法
		addressMapper.updateAddressById(address);
	}
	//获取省市区的名称
	private String getDistrict(Address address) {
		return dictMapper.selectByProvinceCode(address.getRecvProvince())+
					 dictMapper.selectByCityCode(address.getRecvCity())+
					 dictMapper.selectByAreaCode(address.getRecvArea());
	}


	public void removeAddress(Integer id) {
		addressMapper.deleteById(id);
	}  
}
