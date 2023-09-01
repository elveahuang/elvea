package cn.elvea.platform.commons.core.cache;

import lombok.Builder;
import org.springframework.lang.NonNull;

/**
 * @author elvea
 * @since 0.0.1
 */
@Builder
public record SimpleCacheKeyGenerator(String prefix) implements CacheKeyGenerator {

    @NonNull
    @Override
    public String getPrefix() {
        return this.prefix;
    }

    public static SimpleCacheKeyGenerator byClassSimpleName(Class<?> o) {
        return new SimpleCacheKeyGenerator(o.getSimpleName().toLowerCase());
    }

}
