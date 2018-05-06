package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void testSetValue(){
        BoundHashOperations<String, String, String> namehash = redisTemplate.<String,String>boundHashOps("namehash");
        namehash.put("a","唐僧");
        namehash.put("b","悟空");
        namehash.put("c","八戒");
        namehash.put("d","沙僧");
    }
    @Test
    public void testGetKeys() {
        Set<String> set = redisTemplate.<String,String>boundHashOps("namehash").keys();
        System.out.println(set);
    }
    @Test
    public void testGetValue(){
        List<String> list = redisTemplate.<String, String>boundHashOps("namehash").values();
        System.out.println(list);
    }
    @Test
    public void testGetValueByKey(){
        String s = redisTemplate.<String, String>boundHashOps("namehash").get("b");
        System.out.println(s);
    }
    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }
    @Test
    public void testRemoveAll(){
        redisTemplate.delete("namehash");
    }
}
