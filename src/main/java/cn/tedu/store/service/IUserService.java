package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	void addUser(User user);
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return 如果存在，返回true；
	 * 				  如果不存在，返回false	
	 */
	boolean checkEmail(String email);
	/**
	 * 验证电话是否存在
	 * @param phone
	 * @return 如果存在，返回true；
	 * 				  如果不存在，返回false	
	 */
	boolean checkPhone(String phone);
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return 如果存在，返回true；
	 * 				  如果不存在，返回false	
	 */
	boolean checkUsername(String username);
	/**
	 * 实现用户名登录
	 * @param username
	 * @param password
	 * @return 如果登录，返回user对象；
	 * 				  如果登录不成功，抛出异常：帐号错误；密码不存在	
	 */
	User login(String username,String password);
	
	void changePassword(Integer id,String oldPwd,String newPwd);
	
	/**
	 * 
	 * @param id
	 * @param username
	 * @param gender
	 * @param email
	 * @param phone
	 */
	void updateUser(Integer id,String username,Integer gender,String email,String phone);
	/**
	 * 通过用户查询用户信息
	 * @param id
	 * @return 如果存在，返回user对象
	 * 					如果不存在，返回null
	 */
	User getUserById(Integer id);
	/**
	 * 修改头像
	 * @param id
	 * @param image
	 */
	void updImage(Integer id,String image);
}
