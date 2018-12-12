package com.jt.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.service.ItemCatService;
import com.jt.manage.vo.EasyUITree;
import com.jt.manage.vo.ItemCat;

import redis.clients.jedis.JedisCluster;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	ItemCatMapper itemCatMapper;
	
	
	@Autowired
	//private Jedis jedis;
	//private ShardedJedis shardedJedis;
	//private RedisService redisService;
	private JedisCluster jedisCluster;
	
	
	//有线程安全问题吗? 操作基本类型时会有线程安全性问题, 但是调用对象时不会, 对象是单例的, 操作的时对象的方法.
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Override
	public List<EasyUITree> findItemCatList(Long parentId) {
		//1.根据parentId查询商品分类列表信息		
		
		ItemCat itemCatTemp = new ItemCat();
		itemCatTemp.setParentId(parentId);
		List<ItemCat> itemCatList = itemCatMapper.select(itemCatTemp);
		
		
		//2.返回数据
		List<EasyUITree> treeList = new ArrayList<>();
		for(ItemCat itemCat : itemCatList) {
			EasyUITree easyUITree = new EasyUITree();
			easyUITree.setId(itemCat.getId());
			easyUITree.setText(itemCat.getName());//商品名称
			//如果为父级则写closed 如果不是父级open
			String state = itemCat.getIsParent()?"closed":"open";
			easyUITree.setState(state);
			treeList.add(easyUITree);					
		}
		return treeList;
	}

	@Override
	public List<EasyUITree> findCacheList(Long parentId) {
		String key = "ITEM_CAT_" + parentId;
		
		//String resultJSON = jedis.get(key);
		String resultJSON = jedisCluster.get(key);
		List<EasyUITree> treeList =new ArrayList<>();
		try {
			if (StringUtils.isEmpty(resultJSON)) {
				//查询数据库获取数据
				treeList = findItemCatList(parentId);
				
				String jsonData = objectMapper.writeValueAsString(treeList);
				//redisService.set(key, jsonData, 20);
				jedisCluster.setex(key, 20, jsonData);
				System.out.println("First time searching ");
			}else {
				//缓存的数据不为空; 将json数据转化为对象
				treeList = 
				objectMapper.readValue(resultJSON, treeList.getClass());
				System.out.println("use cache data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return treeList;
	}
	
	/**
	 * 添加缓存机制:
	 * 1.用户首先查询缓存
	 * 没数据:则查询数据库, 将查询的结果转化为JSON串, 将数据保存到rendis中之后数据返回
	 * 有数据:
	 * 将json串转化为java对象之后,返回数据
	 * 
	 * 
	 */
	

}
