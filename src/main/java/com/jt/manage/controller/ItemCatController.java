package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.po.Item;
import com.jt.common.vo.SysResult;
import com.jt.manage.service.ItemCatService;
import com.jt.manage.vo.EasyUITree;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	//根据商品ID查询商品分类信息
	//@RequestParam(value="id", defaultValue="", required="")
	//value:传入的参数名
	//defaultValue:默认值
	//required:设置是否必须传入此参数
	@RequestMapping("list")
	@ResponseBody
	public List<EasyUITree> findItemCartListByParentId(@RequestParam(value="id", defaultValue="0") Long parentId){
		//1.实现查询一级商品分类的信息
			//Long parentId = 0L;
		System.out.println("findItemCatByParentId<<<<<parentId:"+parentId);
			return itemCatService.findCacheList(parentId);
	}
	
	
}
