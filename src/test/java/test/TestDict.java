package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.DictMapper;

public class TestDict {
	@Test
	public void selectByCode() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dictMapper.selectByProvinceCode("130000"));
		System.out.println(dictMapper.selectByCityCode("130400"));
		System.out.println(dictMapper.selectByAreaCode("130434"));
	}
}
