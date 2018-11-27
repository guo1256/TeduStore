package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Area;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class TestAddress {
	@Test
	public void testInsertAddress() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
		Address address = new Address();
		address.setId(null);
		address.setUid(1);
		address.setRecvName("张大力");
		address.setRecvProvince("130000");
		address.setRecvCity("130400");
		address.setRecvArea("130434");
		address.setRecvDistrict("东西大道");
		address.setRecvAddress("15号");
		address.setRecvPhone("15728044687");
		address.setRecvTel("85767342");
		address.setRecvZip("未知");
		address.setRecvTag("未知");
		address.setIsDefault(0);
		am.insertAddress(address);
		ac.close();
	}
	
	@Test
	public void testSelectByUid() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
		List<Address> adr = (List<Address>) am.selectByUid(1);
		for(Address a: adr) {
			System.out.println(a);
		}
		ac.close();
	}
	
	@Test
	public void testUpdateById() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(am.updateById(6));
	
		ac.close();
	}
	
	@Test
	public void testUpdateByUid() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(am.updateByUid(6));
	
		ac.close();
	}
	
	@Test
	public void testAddAddress() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IAddressService as = ac.getBean("addressService",IAddressService.class);
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("张大千");
		address.setRecvProvince("130000");
		address.setRecvCity("130400");
		address.setRecvArea("130434");
		address.setRecvAddress("15号");
		address.setRecvPhone("15728044687");
		address.setRecvTel("85767342");
		address.setRecvZip("未知");
		address.setRecvTag("未知");
		as.addAddress(address);
		ac.close();
	}
	
	@Test
	public void testsetDefault() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IAddressService as = ac.getBean("addressService",IAddressService.class);
		as.setDefault(3, 6);
		ac.close();
	}
	
	@Test
	public void testSelectById() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
		System.out.println(am.selectById(6));
		ac.close();
	}
	
	@Test
	public void testUpdateAddressById() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		AddressMapper am = ac.getBean("addressMapper",AddressMapper.class);
		Address address = new Address();
		address.setRecvName("1");
		address.setRecvProvince("2");
		address.setRecvCity("3");
		address.setRecvArea("4");
		address.setRecvDistrict("5");
		address.setRecvAddress("6");
		address.setRecvPhone("7");
		address.setRecvTel("8");
		address.setRecvZip("9");
		address.setRecvTag("10");
		address.setId(3);
		am.updateAddressById(address);
		ac.close();
	}
	
	@Test
	public void testUpdateAddress() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IAddressService as = ac.getBean("addressService",IAddressService.class);
		Address address = new Address();
		address.setRecvName("1");
		address.setRecvProvince("130000");
		address.setRecvCity("130400");
		address.setRecvArea("130434");
		address.setRecvAddress("6");
		address.setRecvPhone("7");
		address.setRecvTel("8");
		address.setRecvZip("9");
		address.setRecvTag("10");
		address.setId(3);
		as.updateAddress(address);
		ac.close();
	}
	
	@Test
	public void testDeleteById() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IAddressService as = ac.getBean("addressService",IAddressService.class);
		as.removeAddress(5);
		ac.close();
	}
}
