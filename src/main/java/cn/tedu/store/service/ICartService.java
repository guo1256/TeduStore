package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {
	void addCart(Cart cart);
	
	List<CartVo> getByUid(Integer uid);
	/**
	 * 批量删除购物车中的商品
	 * @param ids
	 */
	void removeByIds(Integer[] ids);
	
	void removeById(Integer id);
	/**
	 * 修改购物车商品数量
	 * @param pid
	 * @param num
	 */
	void updateById(Integer pid,Integer num);
}
