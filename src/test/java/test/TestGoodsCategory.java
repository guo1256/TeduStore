package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategory {

	@Test
	public void testSelectByGoodsCategory() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("application-dao.xml");
		GoodsCategoryMapper gc = ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		List<GoodsCategory> list = gc.selectByParentId(161, 0, 3);
		for(GoodsCategory g:list) {
			System.out.println(g);
		}
		System.out.println(gc.selectByParentId(162,null,null));
		ac.close();
	}
}
