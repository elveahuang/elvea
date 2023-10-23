package cn.elvea.platform.commons.core.autoconfigure.extensions.captcha;

import cn.elvea.platform.commons.core.autoconfigure.extensions.captcha.properties.CaptchaProperties;
import cn.elvea.platform.commons.core.cache.service.CacheService;
import cn.elvea.platform.commons.core.extensions.captcha.provider.*;
import cn.elvea.platform.commons.core.extensions.captcha.service.CaptchaService;
import cn.elvea.platform.commons.core.extensions.captcha.service.DefaultCaptchaService;
import cn.elvea.platform.commons.core.extensions.captcha.store.CaptchaStore;
import cn.elvea.platform.commons.core.extensions.captcha.store.DefaultCaptchaStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author elvea
 * @since 0.0.1
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = CaptchaProperties.PREFIX, name = "enabled", havingValue = "true")
@EnableConfigurationProperties({CaptchaProperties.class})
public class CaptchaAutoConfiguration {

    public CaptchaAutoConfiguration() {
        log.info("CaptchaAutoConfiguration is enabled.");
    }

    @Bean
    @ConditionalOnMissingBean()
    public MailCaptchaProvider mailCaptchaProvider() {
        return new DefaultMailCaptchaProvider();
    }

    @Bean
    @ConditionalOnMissingBean()
    public SmsCaptchaProvider smsCaptchaProvider() {
        return new DefaultSmsCaptchaProvider();
    }

    @Bean
    @ConditionalOnMissingBean()
    public CodeCaptchaProvider codeCaptchaProvider() {
        return new DefaultCodeCaptchaProvider();
    }

    @Bean("captchaStore")
    @ConditionalOnMissingBean(CaptchaStore.class)
    public CaptchaStore captchaStore(CacheService cacheService, CaptchaProperties properties) {
        return new DefaultCaptchaStore(cacheService, properties.getCacheKeyPrefix());
    }

    @Bean
    @ConditionalOnMissingBean
    public CaptchaService captchaService(CaptchaStore captchaStore,
                                         MailCaptchaProvider mailCaptchaProvider,
                                         SmsCaptchaProvider smsCaptchaProvider,
                                         CodeCaptchaProvider codeCaptchaProvider) {
        DefaultCaptchaService captchaService = new DefaultCaptchaService();
        captchaService.setCaptchaStore(captchaStore);
        captchaService.setCodeCaptchaProvider(codeCaptchaProvider);
        captchaService.setMailCaptchaProvider(mailCaptchaProvider);
        captchaService.setSmsCaptchaProvider(smsCaptchaProvider);
        return captchaService;
    }

}
