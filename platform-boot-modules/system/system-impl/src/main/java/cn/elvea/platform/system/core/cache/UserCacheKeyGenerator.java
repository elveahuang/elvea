package cn.elvea.platform.system.core.cache;

import cn.elvea.platform.commons.core.cache.CacheKey;
import cn.elvea.platform.commons.core.cache.CacheKeyGenerator;
import cn.elvea.platform.system.commons.constants.SystemCacheConstants;
import org.jetbrains.annotations.NotNull;

/**
 * @author elvea
 * @since 0.0.1
 */
public class UserCacheKeyGenerator implements CacheKeyGenerator {

    @Override
    public @NotNull String getPrefix() {
        return SystemCacheConstants.USER;
    }

    public CacheKey keyByUsername(String username) {
        return this.key("username", username);
    }

    public CacheKey keyByEmail(String email) {
        return this.key("email", email);
    }

    public CacheKey keyByMobile(String mobileCountryCode, String mobileNumber) {
        return this.key("mobile", mobileCountryCode, mobileNumber);
    }

}
