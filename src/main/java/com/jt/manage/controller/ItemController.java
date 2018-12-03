package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.service.ItemService;

@RequestMapping("/item")
@Controller
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findItemByPage(Integer page, Integer rows) {
		System.out.println("page:"+page+" rows: "+rows);
		return itemService.findItemByPage(page, rows);
	}
	
	//通过itemcat的id 查询商品分类的名称
	/**
	 * 规则:当返回数据为对象时(VO), 则默认的字符集编码为"UTF-8" 源码位置:AbstractJackson2HttpMessageConverter
	 * 如果返回值为String类型时, 则默认对象的字符集为"ISO-8859-1"  源码位置: StringHttpMessageConverter
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value="/cat/queryItemName", produces="text/html;charset=utf-8")
	@ResponseBody
	public String findItemCatNameById(Long itemId) {
		//System.out.println("itemId: " +itemId);
		return itemService.findItemCatNameById(itemId);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item	) {
		System.out.println("saveItem()<<<");
		try {
		itemService.saveItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.oK();	
	}
	
	//实现商品下架
	@RequestMapping("/{moduleName}")
	@ResponseBody
	public SysResult instock(Long[] ids,@PathVariable String moduleName) {
		System.out.println("instock()<<<");
		try {
			if ("instock".equals(moduleName)) {
				int status = 2;	//表示下架
				itemService.updateState(ids, status);
				return SysResult.oK();
			} else if ("reshelf".equals(moduleName)) {
				int status = 1; //表示正常
				itemService.updateState(ids, status);
				return SysResult.oK();
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品状态更新失败!");
	}	
	
	
	//编辑商品
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item) {
		System.out.println("updateItem()<<<");
		try {
		itemService.updateItem(item);
		return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "修改失败");
	}
	@RequestMapping("/delete")
	@ResponseBody
	public SysResult deleteItems(Long[] ids) {
		System.out.println("deleteItem()<<<");
		try {
			itemService.deleteItems(ids);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "删除失败");
	}
	
}
