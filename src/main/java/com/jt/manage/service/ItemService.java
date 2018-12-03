package com.jt.manage.service;

import java.util.List;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;

public interface ItemService {

	public EasyUIResult findItemByPage(Integer page, Integer rows);

	public String findItemCatNameById(Long itemId);

	public void saveItem(Item item);

	public void updateItem(Item item);

	public void updateState(Long[] ids, int status);

	public void deleteItems(Long[] ids);


	
	
	
}
