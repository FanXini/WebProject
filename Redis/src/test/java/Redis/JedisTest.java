package Redis;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import redis.SimpleRedisUtil;
import redis.clients.jedis.Jedis;

public class JedisTest{

    private Jedis jedis;

    @Before
    public void setup(){
        jedis = SimpleRedisUtil.getJedis();
    }



     /**
      * redis 字符串string
      * 
      * 常用操作：添加键值对 、获取键对应的值、删除键、批量添加键值对、对数字型的值+1或者-1
      */
    
      @Test
      public void testString() {
          //-----添加数据----------  
          String key = "name";
          jedis.set(key,"mengdee");
          System.out.println(jedis.get(key));

          jedis.append(key, " is good"); 
          System.out.println(jedis.get(key)); 

          jedis.del(key);  
          System.out.println(jedis.get(key));

          // 批量添加键值对，注意值都是字符串类型，注意这里是一次性添加三个键值对，他们的关系是并列关系（即使三个键值对而不是一个键值对的值是三个值）
          jedis.mset("name","mengdee","age","23","nickname","mengday");
          jedis.incr("age"); //进行加1操作
          System.out.println(jedis.get(key) + "-" + jedis.get("age") + "-" + jedis.get("nickname"));
      }

      /**
       * redis map
       * map 包含多个键值对，通常存储Java中的对象使用map数据类型存储
       */
      @Test
      public void testMap() {
          //-----添加数据----------  
          Map<String, String> userMap = new HashMap<String, String>();
          userMap.put("id", "1");
          userMap.put("username", "mengdee");
          userMap.put("age", "20");

          String key = "user:1";
          jedis.hmset(key, userMap);


          // 一次获取多个字段的值
          List<String> values = jedis.hmget(key, "id", "username", "age");
          System.out.println(values);  

          // 通常使用hgetAll获取到的Map转换成Java中的对象
          Map<String, String> userMap2 = jedis.hgetAll(key);
          Set<Entry<String, String>> entrySet = userMap2.entrySet();
          for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
          }

          System.out.println(jedis.hmget(key, "age")); 
          System.out.println(jedis.hlen(key)); 
          System.out.println(jedis.exists(key));  
          System.out.println(jedis.hkeys(key));
          System.out.println(jedis.hvals(key));

          jedis.hdel(key,"age");
      }

      /** 
       * jedis list(一般存储像Java中的数组或者List这样的数据类型)
       */  
      @Test  
      public void testList(){  
          //开始前，先移除所有的内容  
          String key = "java";
          jedis.del(key);  

          jedis.lpush(key, "gradle");  
          jedis.lpush(key, "springmvc");  
          jedis.lpush(key, "mybatis");  
          jedis.rpush(key, "spring boot");

          System.out.println(jedis.lrange(key, 0, -1));  

          jedis.del(key);
          jedis.rpush(key, "spring");  
          jedis.rpush(key, "struts");  
          jedis.rpush(key, "hibernate"); 
          System.out.println(jedis.lrange(key, 0, -1));
      }  

     /** 
      * jedis set
      * 
      * 注意set操作是无须的
      */  
     @Test  
     public void testSet(){  
         //添加  
         String key = "users";
         jedis.sadd(key,"zhangsan");  
         jedis.sadd(key,"lisi");  
         jedis.sadd(key,"mengdee");  
         jedis.sadd(key,"mengday");
         jedis.sadd(key,"X");  

         jedis.srem(key,"X");  

         System.out.println(jedis.smembers(key));
         System.out.println(jedis.sismember(key, "mengdee"));
         System.out.println(jedis.srandmember(key));  
         System.out.println(jedis.scard(key));
     }  
}


