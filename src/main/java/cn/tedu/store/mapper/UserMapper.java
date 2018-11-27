package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/**
	 * 插入一条用户信息
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 * 根据用户名查询
	 * @param username
	 * @return 如果查到了，把记录封装成user对象返回
	 * 				  如果没查到，返回null
	 */
	User selectByUsername(String username);
	/**
	 * 通过邮箱来查询
	 * @param email
	 * @return 如果邮箱存在，那么返回行数；
	 * 				  如果不存在，返回0；
	 */
	Integer selectByEmail(String email);
	/**
	 * 通过电话来查询
	 * @param phone
	 * @return 如果邮箱存在，那么返回行数；
	 * 				  如果不存在，返回0；
	 */
	Integer selectByPhone(String phone);
	
	/**
	 *  修改用户
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	User selectUserById(Integer id);
	/**
	 * 修改头像
	 * @param id
	 * @param image
	 */
	void updateImage(@Param("id") Integer id,@Param("image")String image);
}
