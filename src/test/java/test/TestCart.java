package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;

public class TestCart {
	@Test
	public void testInsertAddress() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = ac.getBean("cartMapper",CartMapper.class);
		Cart cart = new Cart();
		cart.setUid(6);
		cart.setGoodsId("10000000");
		cart.setNum(1);
		cart.setCreatedUser("lala");
		cart.setCreatedTime(new Date());
		cm.insertCart(cart);
		ac.close();
	}
	
	@Test
	public void testSelectByUid() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = ac.getBean("cartMapper",CartMapper.class);
		List<CartVo> cartv = cm.selectByUid(6);
		for(CartVo cv:cartv) {
			System.out.println(cv);
		}
		ac.close();
	}
	
	@Test
	public void testDeleteByIds() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = ac.getBean("cartMapper",CartMapper.class);
		Integer[] n = {5,6};
		cm.deleteByIds(n);
		ac.close();
	}
	
	@Test
	public void testDeleteById() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = ac.getBean("cartMapper",CartMapper.class);
		cm.deleteById(9);
		ac.close();
	}
	
	@Test
	public void testUpdateNum() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		CartMapper cm = ac.getBean("cartMapper",CartMapper.class);
		cm.updateNum(10, 2);
		ac.close();
	}
}
