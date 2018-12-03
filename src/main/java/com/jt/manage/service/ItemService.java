package com.jt.manage.service;

import java.util.List;

import com.jt.common.po.Item;
import com.jt.common.vo.EasyUIResult;

public interface ItemService {

	public EasyUIResult findItemByPage(Integer page, Integer rows);

	public String findItemCatNameById(Long itemId);

	
	
}
