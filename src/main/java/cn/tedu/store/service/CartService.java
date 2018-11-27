package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;
@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
	}
	
	public List<CartVo> getByUid(Integer uid) {
		return cartMapper.selectByUid(uid);
	}

	public void removeByIds(Integer[] ids) {
		cartMapper.deleteByIds(ids);
	}

	public void removeById(Integer id) {
		cartMapper.deleteById(id);
	}

	public void updateById(Integer pid, Integer num) {
		cartMapper.updateNum(pid, num);
		
	}

}
