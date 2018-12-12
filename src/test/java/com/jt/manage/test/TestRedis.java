package com.jt.manage.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Transaction;

public class TestRedis {
	
//	
//	@Test
//	public void testString() {
//		Jedis jedis = new Jedis("192.168.150.134", 6379);
//		jedis.set("1808", "什么都是好的!");
//		System.out.println(jedis.get("1808"));
//	}
//	
//	@Test
//	public void testHash() throws Exception {
//		User user = new User();
//		
//		user.setId(1000);
//		user.setAge(20);
//		user.setName("haah");
//		user.setSex("male");
//		
//		Jedis jedis = new Jedis("192.168.150.134", 6379);
//		
//		jedis.lpush("list1", "1","2","3","4","5");
//		System.out.println("list1: "+jedis.rpop("list1"));
//		System.out.println("list1:"+jedis.lpop("list1"));
//		
//		
//	}
//	
//	
//	
//	@Test
//	public void testTx() throws Exception {
//		Jedis jds = new Jedis("192.168.150.134", 6379);
//		
//		//open tx
//		Transaction tx1 = jds.multi();
//		
//		// operation
//		tx1.set("1808","tomcat");
//		//
//		tx1.exec();
//		System.out.println(jds.get("1808"));
//			
//	}
//	
//	@Test
//	public void testSentinel() throws Exception {
//		
//		//1.定义池
//		JedisPoolConfig poolConfig = new JedisPoolConfig();
//		poolConfig.setMaxTotal(1000);
//		
//		//转化IP和端口的工具类
//		//HostAndPort port = new  HostAndPort();
//		
//		
//		//将redis哨兵节点写入集合
//		Set<String> sentinels = new HashSet<>();
//		sentinels.add("192.168.150.134:26379");
//		sentinels.add("192.168.150.134:26380");
//		sentinels.add("192.168.150.134:26381");
//		JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels , poolConfig);
//		Jedis jedis = pool.getResource();
//		jedis.set("01", "1808班");
//		System.out.println("jedis: "+jedis.get("01"));
//		pool.returnResource(jedis);
//		
//	}
//	
//	@Test
//	public void testCluster() throws Exception {
//		Set<HostAndPort> nodes = new HashSet<>();
//		nodes.add(new HostAndPort("192.168.150.134", 7000));
//		nodes.add(new HostAndPort("192.168.150.134", 7001));
//		nodes.add(new HostAndPort("192.168.150.134", 7002));
//		nodes.add(new HostAndPort("192.168.150.134", 7003));
//		nodes.add(new HostAndPort("192.168.150.134", 7004));
//		nodes.add(new HostAndPort("192.168.150.134", 7005));
//		nodes.add(new HostAndPort("192.168.150.134", 7006));
//		nodes.add(new HostAndPort("192.168.150.134", 7007));
//		nodes.add(new HostAndPort("192.168.150.134", 7008));
//		JedisCluster cluster = new JedisCluster(nodes);
//		cluster.set("001", "CCCG");
//		System.out.println("data: "+cluster.get("001"));
//	}
}
