package com.collection.common.redis.wrapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;


public class JedisPoolManager {

	private static final Logger logger = LoggerFactory.getLogger(JedisPoolManager.class);

	private JedisPool jedisPool;

	/**
	 * redis��List���� ����key���list���Ԫ��
	 */
	public long rpush(String key, String string) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long ret = jedis.rpush(key, string);
			jedis.close();
			return ret;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��ȡkey���List���ӵڼ���Ԫ�ص��ڼ���Ԫ�� LRANGE key start
	 * stop�����б�key��ָ�������ڵ�Ԫ�أ�������ƫ����start��stopָ����
	 * �±�(index)����start��stop����0Ϊ�ף�Ҳ����˵����0��ʾ�б�ĵ�һ��Ԫ�أ���1��ʾ�б�ĵڶ���Ԫ�أ��Դ����ơ�
	 * Ҳ����ʹ�ø����±꣬��-1��ʾ�б�����һ��Ԫ�أ�-2��ʾ�б�ĵ����ڶ���Ԫ�أ��Դ����ơ�
	 */
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<String> ret = jedis.lrange(key, start, end);
			jedis.close();
			return ret;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ����ϣ��key�е���field��ֵ��Ϊvalue��
	 */
	public void hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hset(key, field, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��key��ֵ
	 */
	public void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��key��ֵ
	 */
	public void set(byte[] key, byte[] value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��ȡkey��ֵ
	 */
	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String value = jedis.get(key);
			jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��ȡkey��ֵ
	 */
	public byte[] get(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] value = jedis.get(key);
			jedis.close();
			//jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
				//jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * �����field - value(��-ֵ)�����õ���ϣ��key�С�
	 */
	public void hmset(String key, Map<String, String> map) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(key, map);
			jedis.close();
		} catch (Exception e) {
			logger.error("hmset����", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��key��ֵ����������������Ϊseconds
	 */
	public void setex(String key, int seconds, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ��key��ֵ����������������Ϊseconds
	 */
	public byte[] setex(byte[] key, byte[] value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.setex(key, seconds, value);
			jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * Ϊ����key������������
	 */
	public void expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ���key�Ƿ����
	 */
	public boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			boolean bool = jedis.exists(key);
			jedis.close();
			return bool;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ���key�Ƿ����
	 */
	public boolean exists(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<byte[]> hashSet = jedis.keys(key);
			jedis.close();
			if (null != hashSet && hashSet.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ����keyֵ������ none(key������),string(�ַ���),list(�б�),set(����),zset(����),hash(��ϣ��)
	 */
	public String type(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String type = jedis.type(key);
			jedis.close();
			return type;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * �ӹ�ϣ��key�л�ȡfield��value
	 */
	public String hget(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String value = jedis.hget(key, field);
			jedis.close();
			return value;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ���ع�ϣ��key�У����е����ֵ
	 */
	public Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Map<String, String> map = jedis.hgetAll(key);
			jedis.close();
			return map;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * ���ع�ϣ��key�У����е����ֵ
	 */
	public Set<?> smembers(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<?> set = jedis.smembers(key);
			jedis.close();
			return set;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ����ƥ��� keys �б�
	 */
	public Set<byte[]> keys(String pattern) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<byte[]> keys = jedis.keys(pattern.getBytes());
			jedis.close();
			return keys;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * �Ƴ�set�����е�memberԪ��
	 */
	public void delSetObj(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.srem(key, field);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ɾ��Ԫ��
	 */
	public void del(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * �ж�memberԪ���Ƿ��Ǽ���key�ĳ�Ա���ǣ�true��������false��
	 */
	public boolean isNotField(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			boolean bool = jedis.sismember(key, field);
			jedis.close();
			return bool;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}

	/**
	 * ���key�Ѿ����ڲ�����һ���ַ�������value׷�ӵ�keyԭ����ֵ֮��
	 */
	public void append(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.append(key, value);
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}
	}
	
	
	/**
	 * ��յ�ǰ��redis ��
	 */
	public void flushDB() {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.flushDB();
			jedis.close();
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * ���ص�ǰredis�����洢���ݵĴ�С
	 */
	public Long dbSize() {

		Long dbSize = 0L;

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.dbSize();
			jedis.close();
			return dbSize;
		} catch (Exception e) {
			logger.error("", e);
			if (jedis != null) {
				jedis.close();
			}
			throw new JedisException(e);
		}

	}

	/**
	 * �ر� Redis
	 */
	public void destory() {
		jedisPool.destroy();
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
}