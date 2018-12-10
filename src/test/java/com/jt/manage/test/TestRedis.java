package com.jt.manage.test;

import org.junit.Test;

import com.jt.manage.pojo.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestRedis {
	
	
	@Test
	public void testString() {
		Jedis jedis = new Jedis("192.168.150.134", 6379);
		jedis.set("1808", "什么都是好的!");
		System.out.println(jedis.get("1808"));
	}
	
	@Test
	public void testHash() throws Exception {
		User user = new User();
		
		user.setId(1000);
		user.setAge(20);
		user.setName("haah");
		user.setSex("male");
		
		Jedis jedis = new Jedis("192.168.150.134", 6379);
		
		jedis.lpush("list1", "1","2","3","4","5");
		System.out.println("list1: "+jedis.rpop("list1"));
		System.out.println("list1:"+jedis.lpop("list1"));
		
		
	}
	
	
	
	@Test
	public void testTx() throws Exception {
		Jedis jds = new Jedis("192.168.150.134", 6379);
		
		//open tx
		Transaction tx1 = jds.multi();
		
		// operation
		tx1.set("1808","tomcat");
		//
		tx1.exec();
		System.out.println(jds.get("1808"));
		
		
		
		
		
		
	}

}
