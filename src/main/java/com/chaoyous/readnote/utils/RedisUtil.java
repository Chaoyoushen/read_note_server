package com.chaoyous.readnote.utils;

import com.chaoyous.readnote.exception.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/11
 */
@Component
public class RedisUtil {

    private static RedisTemplate<String, Object> redisTemplate;

    @Resource(name="redisTemplate")
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    /**
     * 设置键值过期时间
     */
    public static boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            throw new RedisException();
        }
    }

    /**
     * 获取key过期时间
     */
    public static long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断缓存中是否有值
     */
    public static boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            throw new RedisException();
        }
    }

    /**
     * 删除key
     */
    public static void del(String key) {
        if (!StringUtils.isEmpty(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 获取key对应value
     */
    public static Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置key-value对
     * */
    public static boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            throw new RedisException();
        }
    }

    /**
     * 设置key-value对并设置过期时间
     * */
    public static boolean set(String key,Object value,long time){
        try {
            if(time>0) {
                redisTemplate.opsForValue().set(key, value, time);
            }else {
                set(key,value);
            }
            return true;
        }catch (Exception e){
            throw new RedisException();
        }
    }

}
