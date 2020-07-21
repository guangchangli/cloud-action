package com.aladdin.shiro.shiro.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

/**
 * @author lgc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class ShiroRedisCache<K, V> implements Cache<K, V> {
    private Long cacheLive;
    private RedisTemplate redisTemplate;
    private String cacheKeyPrefix;

    @Override
    public V get(K k) throws CacheException {
        String value = (String) redisTemplate.opsForValue().get(k.toString());
        return value == null ? null : (V) value;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        redisTemplate.opsForValue().set(k.toString(), v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
