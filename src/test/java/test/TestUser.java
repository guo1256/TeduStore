package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;

public class TestUser {
	@Test
	public void testLogin() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml"
						,"application-service.xml");
		//2.从容器中获取bean对象
		IUserService us =
				ac.getBean("userService",IUserService.class);
		//3.调用方法
		System.out.println(us.login("admin","123456"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testCheckUsername() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml"
						,"application-service.xml");
		//2.从容器中获取bean对象
		IUserService us =
				ac.getBean("userService",IUserService.class);
		//3.调用方法
		System.out.println(us.checkUsername("小弟弟12"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testCheckPhone() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml"
						,"application-service.xml");
		//2.从容器中获取bean对象
		IUserService us =
				ac.getBean("userService",IUserService.class);
		//3.调用方法
		System.out.println(us.checkPhone("1365465415"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testCheckEmail() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml"
						,"application-service.xml");
		//2.从容器中获取bean对象
		IUserService us =
				ac.getBean("userService",IUserService.class);
		//3.调用方法
		System.out.println(us.checkEmail("asd@126.com"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testSelectByPhone() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml");
		//2.从容器中获取bean对象
		UserMapper um =
				ac.getBean("userMapper",UserMapper.class);
		//3.调用方法
		System.out.println(um.selectByPhone("1365465415"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testSelectByEmail() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml");
		//2.从容器中获取bean对象
		UserMapper um =
				ac.getBean("userMapper",UserMapper.class);
		//3.调用方法
		System.out.println(um.selectByEmail("lsd@126.com"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testAddUser() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml"
						,"application-service.xml");
		//2.从容器中获取bean对象
		IUserService us =
				ac.getBean("userService",IUserService.class);
		//3.调用方法
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setEmail("sd@126.com");
		user.setPhone("12345651");
		us.addUser(user);
		//4.关闭容器
		ac.close();
	}
	//1.测试方法的返回类型为void类型
	//2.测试方法的访问修饰符为public
	//3.测试方法的参数列表为空
	@Test
	public void testSelectByUsername() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		//2.从容器中获取bean对象
		UserMapper um =
				ac.getBean("userMapper",UserMapper.class);
		//3.调用方法
		System.out.println(um.selectByUsername("小弟弟"));
		//4.关闭容器
		ac.close();
	}
	
	@Test
	public void testInsertUser() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user = new User();
		user.setId(null);
		user.setUsername("qweasd1");
		user.setPassword("666");
		user.setEmail("asd@126.com");
		user.setPhone("13654654151");
		user.setImage("myimage");
		user.setGender(1);
		user.setCreatedUser("");
		Date date = new Date();
		user.setCreatedTime(date);
		user.setModifiedUser("");
		user.setModifiedTime(date);
		userMapper.insertUser(user);
		ac.close();		
	}
	
	@Test
	public void testUpdateUser() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user = new User();
		user.setId(5);
		user.setUsername("qweasd3");
		user.setPassword("6667");
		user.setEmail("asd@126.com");
		user.setPhone("13654654151");
		user.setGender(1);
		user.setModifiedTime(new Date());
		user.setModifiedUser("lalala");
		userMapper.updateUser(user);
		ac.close();
	}
	
	@Test
	public void testSelectUserById() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		System.out.println(userMapper.selectUserById(5));
		ac.close();
	}
	
	@Test
	public void testChangePassword() {
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(
						"application-dao.xml",
						"application-service.xml");
		IUserService us = ac.getBean("userService",IUserService.class);
		us.changePassword(5,"6666","6667");
		ac.close();
	}
	
	@Test
	public void testUpdateUser2() {
		//1.获取Spring容器
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext(
						"application-dao.xml"
						,"application-service.xml");
		//2.从容器中获取bean对象
		IUserService us =
				ac.getBean("userService",IUserService.class);
		us.updateUser(6, "qweasd", 0, "qwew@126.com", "12345651");
		ac.close();
	}
	
	@Test
	public void testSelectProvince() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dictMapper.selectProvince());
		ac.close();
	}
	
	@Test
	public void testSelectCity() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		List<City> city = (List<City>) dictMapper.selectCity("130000");
		for(City c: city) {
			System.out.println(c);
		}
		ac.close();
	}
	
	@Test
	public void testSelectArea() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		List<Area> area = (List<Area>) dictMapper.selectArea("130400");
		for(Area a: area) {
			System.out.println(a);
		}
		ac.close();
	}
	
	@Test
	public void testUpdateImage() {
		AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		userMapper.updateImage(6, "lalala");
		ac.close();
	}

}
