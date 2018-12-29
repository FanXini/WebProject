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
      * redis �ַ���string
      * 
      * ���ò�������Ӽ�ֵ�� ����ȡ����Ӧ��ֵ��ɾ������������Ӽ�ֵ�ԡ��������͵�ֵ+1����-1
      */
    
      @Test
      public void testString() {
          //-----�������----------  
          String key = "name";
          jedis.set(key,"mengdee");
          System.out.println(jedis.get(key));

          jedis.append(key, " is good"); 
          System.out.println(jedis.get(key)); 

          jedis.del(key);  
          System.out.println(jedis.get(key));

          // ������Ӽ�ֵ�ԣ�ע��ֵ�����ַ������ͣ�ע��������һ�������������ֵ�ԣ����ǵĹ�ϵ�ǲ��й�ϵ����ʹ������ֵ�Զ�����һ����ֵ�Ե�ֵ������ֵ��
          jedis.mset("name","mengdee","age","23","nickname","mengday");
          jedis.incr("age"); //���м�1����
          System.out.println(jedis.get(key) + "-" + jedis.get("age") + "-" + jedis.get("nickname"));
      }

      /**
       * redis map
       * map ���������ֵ�ԣ�ͨ���洢Java�еĶ���ʹ��map�������ʹ洢
       */
      @Test
      public void testMap() {
          //-----�������----------  
          Map<String, String> userMap = new HashMap<String, String>();
          userMap.put("id", "1");
          userMap.put("username", "mengdee");
          userMap.put("age", "20");

          String key = "user:1";
          jedis.hmset(key, userMap);


          // һ�λ�ȡ����ֶε�ֵ
          List<String> values = jedis.hmget(key, "id", "username", "age");
          System.out.println(values);  

          // ͨ��ʹ��hgetAll��ȡ����Mapת����Java�еĶ���
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
       * jedis list(һ��洢��Java�е��������List��������������)
       */  
      @Test  
      public void testList(){  
          //��ʼǰ�����Ƴ����е�����  
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
      * ע��set�����������
      */  
     @Test  
     public void testSet(){  
         //���  
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


