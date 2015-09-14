package com.bx.unit;

import java.util.HashMap;
import java.util.Map;



import redis.clients.jedis.Jedis;

public class Tredis {
	static Jedis jedis = new Jedis("localhost", 6379);
	public static void main(String[] args) {
		jedis.set("age", "10");
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("name", "zhangsan");
		hash.put("age", "10");
		jedis.hmset("stu:001", hash);
	}
}
