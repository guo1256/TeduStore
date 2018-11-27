package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	/**
	 * 查询商品分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return 
	 * 1.mybatis如果参数多于一个，那么需要处理
	 *   2.解决方案有两种：
	 *   		第一种，把参数封装成类类型
	 *   		第二种，通过@Param注解分别给变量做映射
	 */
	List<GoodsCategory> selectByParentId(
			@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
}
