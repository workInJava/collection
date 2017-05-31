package com.collection.project.auth.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.collection.common.redis.wrapper.JedisManager;

public class RedisCacheManager implements CacheManager {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

	// fast lookup by name map
	private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

	private JedisManager redisManager;
	
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		logger.info("==================��ȡ����Ϊ: " + name + " ��RedisCacheʵ��===========");
		Cache c = caches.get(name);
		if (c == null) {
			logger.info("==================����RedisCache===========");
			c = new RedisCache<K, V>(name,redisManager);
			caches.put(name, c);
		}
		return c;
	}

	public JedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(JedisManager redisManager) {
		this.redisManager = redisManager;
	}
	
}