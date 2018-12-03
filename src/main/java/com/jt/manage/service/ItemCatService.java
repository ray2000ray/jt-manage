package com.jt.manage.service;

import java.util.List;

import com.jt.manage.vo.EasyUITree;

public interface ItemCatService {
	/**
	 * 1.要什么? List<EasyUITree>
	 * 2.业务是什么?查询商品分类列表信息List<ItemcCat>
	 * 3.怎么做?循环遍历
	 * @param parentId
	 * @return
	 */
	List<EasyUITree> findItemCatList(Long parentId);	
	
}
