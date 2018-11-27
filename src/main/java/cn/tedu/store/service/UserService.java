package cn.tedu.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;
	@Value("#{config.salt}")
	private String salt;
	public void addUser(User user) {
		//1.调用持久层的方法selectByUsername(user.getUsername);
		//返回user1对象
		User user1 = userMapper.selectByUsername(user.getUsername());
		//2.如果user1==null,调insertUser(user)方法；
		//3.如果user1!=null,抛出异常UsernameAlreadyExitException
		if(user1==null) {
			//获取页面的密码
			String pwd = user.getPassword();
			//生成的密码密文
			String md5Pwd =
					DigestUtils.md5Hex(pwd+salt);
			//把密码设置为user的password属性值
			user.setPassword(md5Pwd);
			
			userMapper.insertUser(user);
		}else {
			throw new UsernameAlreadyExistException("用户名已存在");
		}		
	}
	
	public boolean checkEmail(String email) {
		//1.调用持久层的方法：selectByEmail(email);返回Integer的值，用n接收。
		Integer n = userMapper.selectByEmail(email);
		//2.如果n>0,那么返回true；否则返回false
		if(n>0) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean checkPhone(String phone) {
		//1.调用持久层的方法：selectByEmail(email);返回Integer的值，用n接收。
		Integer n = userMapper.selectByPhone(phone);
		//2.如果n>0,那么返回true；否则返回false
		if(n>0) {
			return true;
		}else {
			return false;
		}
	}

	public boolean checkUsername(String username) {
		return userMapper.selectByUsername(username)!=null;
	}

	public User login(String username, String password) {
		System.out.println("userService.login");
		//1.调用持久层的方法：selectByUsername(username);返回user 对象
		User user = userMapper.selectByUsername(username);
		if(user==null) {
		//2.抛出异常UserNotFoundException("帐号不存在");
			throw new UserNotFoundException("帐号不存在");
		}else {
		//3.从user对象中取出密码和参数的password比较
			String md5Pwd = 
					DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(md5Pwd)) {
				return user;
			}else {
				throw new PasswordNotMatchException("密码不匹配");
			}
		}
	}

	public void changePassword(Integer id, String oldPwd, String newPwd) {
		//1.调用持久层方法 返回user对象
		//2.user不为null，用户存在
		User user = userMapper.selectUserById(id);
		if(user!=null) {			
			
			String md5Pwd1 = 
					DigestUtils.md5Hex(oldPwd+salt);
			
			if(user.getPassword().equals(md5Pwd1)) {
				User user1 = new User();
				user1.setId(id);
				
				String md5Pwd2 = 
						DigestUtils.md5Hex(newPwd+salt);
				
				user1.setPassword(md5Pwd2);
				userMapper.updateUser(user1);
			}else {
				throw new PasswordNotMatchException("旧密码不匹配");
			}
		}else {
			throw new UserNotFoundException("用户不存在");
		}	
	}

	public void updateUser(Integer id, String username, Integer gender, String email, String phone) {
		//1.调用持久层的selectUserById(id),
		//返回user1对象;用来检查用户是否存在
		User user1 = 
			userMapper.selectUserById(id);
		//user1不为null，表示用户存在
		if(user1!=null){
			//检查用户名是否重复
			//调用持久层的方法selectUserByUsername(username)
			User user2 = 
				userMapper.selectByUsername(username);
			//如果user2不为null，说明数据库中存在该用户名
			//如果用户名和登录用户的名称相同，可以实现修改
			if(user2!=null&&!username.equals(
					user1.getUsername())){
				throw new UsernameAlreadyExistException(
						"用户名已存在");
			}else{
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPhone(phone);
				user.setEmail(email);
				user.setGender(gender);
				userMapper.updateUser(user);
			}
			
		}else{
			//表示用户不存在，抛出异常
			throw new UserNotFoundException(
					"用户不存在");
		}
		
		
	}

	public User getUserById(Integer id) {
		
		return userMapper.selectUserById(id);
	}

	public void updImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}
}
