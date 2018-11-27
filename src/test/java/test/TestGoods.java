package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

public class TestGoods {
	@Test
	public void testSelectByCategoryId() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsMapper gc = ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(gc.selectByCategoryId(163, 0, 3));
		ac.close();
	}
	
	@Test
	public void testSelectCount() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsMapper gc = ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(gc.selectCount(163));
		ac.close();
	}
	
	@Test
	public void testSelectById() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IGoodsService gs = ac.getBean("goodsService",IGoodsService.class);
		System.out.println(gs.getById("10000000"));
		ac.close();
	}
}
