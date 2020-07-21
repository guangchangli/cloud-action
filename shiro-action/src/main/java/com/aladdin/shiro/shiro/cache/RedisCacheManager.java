package com.aladdin.shiro.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;

/**
 * shiro 缓存管理
 *
 * @author lgc
 */
public class RedisCacheManager implements CacheManager {
    private Long cacheLive;
    private RedisTemplate redisTemplate;
    private String cacheKeyPrefix;
    private final ConcurrentHashMap<String,Cache> caches= new ConcurrentHashMap<>();

    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        Cache cache = this.caches.get(cacheName);
        if (cache==null){
            cache=new ShiroRedisCache<K,V>(cacheLive,redisTemplate,cacheKeyPrefix);
            caches.put(cacheName,cache);
        }
        return cache;
    }

    public void setTime(Long cacheLive) {
        this.cacheLive = cacheLive;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setCacheKeyPrefix(String cacheKeyPrefix) {
        this.cacheKeyPrefix = cacheKeyPrefix;
    }
}
