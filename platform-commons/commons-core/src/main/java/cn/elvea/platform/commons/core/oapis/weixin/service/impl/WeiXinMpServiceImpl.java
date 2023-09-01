package cn.elvea.platform.commons.core.oapis.weixin.service.impl;

import cn.elvea.platform.commons.core.cache.service.CacheService;
import cn.elvea.platform.commons.core.oapis.weixin.config.AppMpConfig;
import cn.elvea.platform.commons.core.oapis.weixin.service.WeiXinMpService;
import cn.elvea.platform.commons.core.oapis.weixin.storage.WxMpCacheConfigStorage;
import lombok.Getter;
import lombok.Setter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;

/**
 * @author elvea
 * @since 0.0.1
 */
@Getter
@Setter
public class WeiXinMpServiceImpl implements WeiXinMpService {

    private CacheService cacheService;

    private final String cacheKeyPrefix;

    private AppMpConfig appConfig;

    public WeiXinMpServiceImpl(CacheService cacheService, String cacheKeyPrefix) {
        this.cacheService = cacheService;
        this.cacheKeyPrefix = cacheKeyPrefix;
    }

    /**
     * @see WeiXinMpService#getConfigStorage()
     */
    @Override
    public WxMpConfigStorage getConfigStorage() {
        return this.getConfigStorage(this.appConfig);
    }

    /**
     * @see WeiXinMpService#getConfigStorage(AppMpConfig)
     */
    @Override
    public WxMpConfigStorage getConfigStorage(AppMpConfig appMpConfig) {
        WxMpCacheConfigStorage config = new WxMpCacheConfigStorage(cacheService, cacheKeyPrefix);
        config.setAppId(appMpConfig.getAppId());
        config.setSecret(appMpConfig.getAppSecret());
        return config;
    }

    /**
     * @see WeiXinMpService#getService()
     */
    @Override
    public WxMpService getService() {
        return this.getService(this.appConfig);
    }

    /**
     * @see WeiXinMpService#getService(AppMpConfig)
     */
    @Override
    public WxMpService getService(AppMpConfig appMpConfig) {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(getConfigStorage(appMpConfig));
        return wxMpService;
    }

}
