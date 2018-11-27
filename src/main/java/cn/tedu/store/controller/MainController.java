package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	//显示首页
		@RequestMapping("/showIndex.do")
		public String showIndex(ModelMap map) {
			List<List<GoodsCategory>> list3 =
					new ArrayList<List<GoodsCategory>>();
			List<GoodsCategory> list2 = goodsCategoryService.getByParentId(161, 0, 3);
			for(GoodsCategory g:list2) {
				List<GoodsCategory> list = goodsCategoryService.getByParentId(g.getId(), null,null);
				list3.add(list);
			}
			//获取热卖的商品集合
			List<Goods> goodsList = goodsService.getByCategoryId(163, 0, 3);
			
			map.addAttribute("list2", list2);
			map.addAttribute("list3", list3);
			
			//把热卖商品的集合添加到map中
			map.addAttribute("goodsList", goodsList);
			return "index";
		}
}
