package Redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import entity.User;
import util.RedisUtil;


public class RedisTemplateTest extends BaseConfig{

   @Autowired
   private RedisTemplate template;
   
   @Autowired
   private RedisUtil redisUtil;
    
   @Test
   public void testSpringRedis2(){
       String  str = "string";//1.�ַ���
       List<String> list = new ArrayList<String>();//list
       list.add("0");
       list.add("�й�");
       list.add("2");
       Set<String> set = new HashSet<String>();//set
       set.add("0");
       set.add("�й�");
       set.add("2");
       Map<String, Object> map = new HashMap();//map
       map.put("key1", "str1");
       map.put("key2", "�й�");
       map.put("key3", "str3");
       
       
       
       redisUtil.del("myStr","str");//ɾ������
       
       
       //1.�ַ�������
       redisUtil.set("str", str);
       redisUtil.expire("str", 10);//ָ��ʧЧʱ��Ϊ2����
       String str1 = (String) redisUtil.get("str");
       System.out.println(str1);
       
       //2.list����
       redisUtil.lSet("list", list);
       redisUtil.expire("list", 10);//ָ��ʧЧʱ��Ϊ2����
       List<Object> list1 = redisUtil.lGet("list", 0, -1);
       System.out.println(list1);
           
       //3.set����
       redisUtil.sSet("set", set);
       redisUtil.expire("set", 10);//ָ��ʧЧʱ��Ϊ2����
       Set<Object> set1 = redisUtil.sGet("set");
       System.out.println(set1);
       
       
       //3.map����
       redisUtil.hmset("map", map);
       redisUtil.expire("map", 10);//ָ��ʧЧʱ��Ϊ2����
        Map<Object, Object> map1 = redisUtil.hmget("map");
       System.out.println(map1);
       
       User user=new User(1l, "fanxin", 20);
       redisUtil.set("user", user);
       
       
   }
}

