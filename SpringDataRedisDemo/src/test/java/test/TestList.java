package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestList {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void testSetValue1(){
        redisTemplate.boundListOps("namelist1").rightPush("刘备");
        redisTemplate.boundListOps("namelist1").rightPush("关羽");
        redisTemplate.boundListOps("namelist1").rightPush("张飞");
    }
    @Test
    public void testGetValue1(){
        List<String> list = redisTemplate.boundListOps("namelist1").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void testSetValue2(){
        redisTemplate.boundListOps("namelist2").leftPush("刘备");
        redisTemplate.boundListOps("namelist2").leftPush("关羽");
        redisTemplate.boundListOps("namelist2").leftPush("张飞");
    }
    @Test
    public void testGetValue2(){
        List<String> list = redisTemplate.boundListOps("namelist2").range(0, 10);
        System.out.println(list);
    }
    @Test
    public void testSearchByIndex() {
        String s = redisTemplate.boundListOps("namelist1").index(1);
        System.out.println(s);
    }
    @Test
    public void testRemoveByIndex() {
        redisTemplate.boundListOps("namelist1").remove(1, "关羽");
    }
    @Test
    public void testRemoveAll(){
        redisTemplate.delete("namelist1");
        redisTemplate.delete("namelist2");
    }
}
