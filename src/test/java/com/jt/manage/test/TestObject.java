package com.jt.manage.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.pojo.User;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class TestObject {
//	
//	@Test
//	public void toJson() throws IOException {
//		User user = new User();
//		User user1 = new User();
//		user.setAge(18);
//		user.setId(200);
//		user.setName("har");
//		user.setSex("male");
//		
//		user1.setAge(22);
//		user1.setId(220);
//		user1.setName("wen");
//		user1.setSex("famale");
//		
//		List<User> userList = new ArrayList<>();
//		userList.add(user);
//		userList.add(user1);
//		
//		//将对象转换成json 依赖对象中的get方法
//		ObjectMapper objectMapper = new ObjectMapper();
//		String result=objectMapper.writeValueAsString(userList);
//		
//		System.out.println(result);
//		
//		//将json数据转化为对象  依赖对象中的set方法
//		List<User> uList = objectMapper.readValue(result, userList.getClass());
//		System.out.println("userObjects: " + uList);
//		
//		User[] users = objectMapper.readValue(result, User[].class);
//		List<User> uList1 = Arrays.asList(users);
//		System.out.println(uList1);
//	}
//
//	//通过程序连接redis分片(实际开发中一般有几十个redis线程)
//	@Test
//	public void testShard() {
//		
//		//定义链接池
//		JedisPoolConfig poolConfig = new JedisPoolConfig();
//		poolConfig.setMaxTotal(1000);
//		poolConfig.setMaxIdle(50);
//		poolConfig.setMinIdle(10);
//		
//		//定义多个redis
//		List<JedisShardInfo> shards = new ArrayList<>();
//		shards.add(new JedisShardInfo("192.168.150.134", 6379));
//		shards.add(new JedisShardInfo("192.168.150.134", 6380));
//		shards.add(new JedisShardInfo("192.168.150.134", 6381));
//		ShardedJedisPool pool = new ShardedJedisPool(poolConfig, shards);
//		
//		ShardedJedis sJedis = pool.getResource();
//		sJedis.set("shards", "redis分片技术");
//		System.out.println("shards: "+sJedis.get("shards"));
//		sJedis.close();
//	}
//	
//	
	
}
