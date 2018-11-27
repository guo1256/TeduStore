package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	List<Goods> getByCategoryId(
			Integer categoryId,Integer offset,Integer count);
	
	Integer getCount(Integer categoryId);
	
	Goods getById(String id);
}
