package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,Integer page,ModelMap map) {
		//三级分类的点击事件
		if(page==null) {
			page=1;
		}
		//获取每一页是商品的集合
		Integer offset = (page-1)*12;
		List<Goods> list = goodsService.getByCategoryId(categoryId, offset, 12);
		//获取商品数量
		Integer count = goodsService.getCount(categoryId);
		//共显示多少页
		int pageSize =
				count%12==0?count/12:count/12+1;
		map.addAttribute("list", list);	
		map.addAttribute("count",count);
		//把页数 添加到map
		map.addAttribute("pageSize",pageSize);
		//把categoryId添加到map
		map.addAttribute("categoryId",categoryId);
		//把当前页设置 添加到map
		map.addAttribute("curpage",page);
		return "search";
	}
	
	@RequestMapping("/showProductDetails.do")
	public String showProductDetails(String id,ModelMap map) {
		Goods goods = goodsService.getById(id);
		map.addAttribute("goods",goods);
		return "product_details";
	}
}
