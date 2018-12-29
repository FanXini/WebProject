package Redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.RedisConfigByJavaBean;
import redis.SimpleRedisUtil;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RedisConfigByJavaBean.class)
public class MyTest {
	@Autowired
	private Jedis jedis;
	
	
	@Test
	
	public void testString() {
		String key="name";
		jedis.set(key, "fanxin4");
		System.out.println(jedis.get(key));
	}

}
