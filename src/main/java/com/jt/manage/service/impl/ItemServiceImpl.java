package com.jt.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemMapper itemMapper;

	@Override
	public EasyUIResult findItemByPage(Integer page, Integer rows) {
		//1.获取总商品数目
        int total = itemMapper.findItemCount();
		//2.获取商品列表信息
        /*select * from tb_item LIMIT 0,20 第一页
         * select * from tb_item LIMIT 20,20 第二页
         * select * from tb_item LIMIT 40,20 第三页
         * select * from tb_item LIMIT 60,20 第四页
         * ..
         * 
         * */
        int start =(page-1)*rows;
        List<Item> itemList = itemMapper.findItemByPage(start, rows);
        EasyUIResult result = new EasyUIResult();
        result.setRows(itemList);
        result.setTotal(total);
		return result;
	}

	@Override
	public String findItemCatNameById(Long itemId) {
		// TODO Auto-generated method stub
		String itemName = itemMapper.findItemCatNameById(itemId);
		return itemName; 
	}


	
	
	
}
