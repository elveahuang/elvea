package cn.elvea.platform.commons.core.oapis.dingtalk.cache;

import cn.elvea.platform.commons.core.cache.service.CacheService;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author elvea
 * @since 0.0.1
 */
public record DefaultCache(CacheService cacheService, String keyPrefix) implements Cache {

    @Override
    public String get(String key) {
        return this.cacheService.get(key);
    }

    @Override
    public void set(String key, String value, long expire, TimeUnit timeUnit) {
        this.cacheService.set(key, value, Duration.ofSeconds(expire));
    }

}
