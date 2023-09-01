package cn.elvea.platform.system.security.service.impl;

import cn.elvea.platform.commons.core.cache.CacheKey;
import cn.elvea.platform.commons.core.data.domain.IdEntity;
import cn.elvea.platform.commons.core.data.jpa.service.BaseCachingEntityService;
import cn.elvea.platform.commons.core.utils.ObjectUtils;
import cn.elvea.platform.commons.core.utils.StringUtils;
import cn.elvea.platform.system.security.cache.AuthorizationCacheKeyGenerator;
import cn.elvea.platform.system.security.model.entity.AuthorizationEntity;
import cn.elvea.platform.system.security.model.entity.AuthorizationEntity_;
import cn.elvea.platform.system.security.repository.AuthorizationRepository;
import cn.elvea.platform.system.security.service.AuthorizationService;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.compress.utils.Lists;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author elvea
 * @see AuthorizationService
 * @since 0.0.1
 */
@Service
public class AuthorizationServiceImpl extends BaseCachingEntityService<AuthorizationEntity, Long, AuthorizationRepository> implements AuthorizationService {

    private final AuthorizationCacheKeyGenerator cacheKeyGenerator = new AuthorizationCacheKeyGenerator();

    @Override
    public AuthorizationCacheKeyGenerator getCacheKeyGenerator() {
        return this.cacheKeyGenerator;
    }

    @Override
    public AuthorizationEntity findByState(String state) {
        CacheKey cacheKey = getCacheKeyGenerator().keyByState(state);
        return getCacheService().get(cacheKey, k -> {
            Specification<AuthorizationEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(builder.equal(root.get(AuthorizationEntity_.state), state));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    @Override
    public AuthorizationEntity findByAuthorizationCodeValue(String authorizationCodeValue) {
        CacheKey cacheKey = getCacheKeyGenerator().keyByAuthorizationCodeValue(authorizationCodeValue);
        return getCacheService().get(cacheKey, k -> {
            Specification<AuthorizationEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(builder.equal(root.get(AuthorizationEntity_.authorizationCodeValue), authorizationCodeValue));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    @Override
    public AuthorizationEntity findByOidcIdTokenValue(String oidcIdTokenValue) {
        CacheKey cacheKey = getCacheKeyGenerator().keyByOidcIdTokenValue(oidcIdTokenValue);
        return getCacheService().get(cacheKey, k -> {
            Specification<AuthorizationEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(builder.equal(root.get(AuthorizationEntity_.oidcIdTokenValue), oidcIdTokenValue));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    @Override
    public AuthorizationEntity findByAccessTokenValue(String accessTokenValue) {
        CacheKey cacheKey = getCacheKeyGenerator().keyByAccessTokenValue(accessTokenValue);
        return getCacheService().get(cacheKey, k -> {
            Specification<AuthorizationEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(builder.equal(root.get(AuthorizationEntity_.accessTokenValue), accessTokenValue));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    @Override
    public AuthorizationEntity findByRefreshTokenValue(String refreshTokenValue) {
        CacheKey cacheKey = getCacheKeyGenerator().keyByAccessTokenValue(refreshTokenValue);
        return getCacheService().get(cacheKey, k -> {
            Specification<AuthorizationEntity> specification = (root, query, builder) -> {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(builder.equal(root.get(AuthorizationEntity_.refreshTokenValue), refreshTokenValue));
                return builder.and(predicates.toArray(new Predicate[0]));
            };
            return this.repository.findOne(specification).orElse(null);
        });
    }

    /**
     * @see BaseCachingEntityService#setCache(IdEntity)
     */
    @Override
    public void setCache(AuthorizationEntity model) {
        if (!ObjectUtils.isEmpty(model)) {
            if (!ObjectUtils.isEmpty(model.getId())) {
                getCacheService().set(getCacheKeyGenerator().keyById(model.getId()), model);
            }
            if (StringUtils.isNotEmpty(model.getState())) {
                getCacheService().set(getCacheKeyGenerator().keyByState(model.getState()), model);
            }
            if (StringUtils.isNotEmpty(model.getAuthorizationCodeValue())) {
                getCacheService().set(getCacheKeyGenerator().keyByAuthorizationCodeValue(model.getAccessTokenValue()), model);
            }
            if (StringUtils.isNotEmpty(model.getOidcIdTokenValue())) {
                getCacheService().set(getCacheKeyGenerator().keyByOidcIdTokenValue(model.getOidcIdTokenValue()), model);
            }
            if (StringUtils.isNotEmpty(model.getAccessTokenValue())) {
                getCacheService().set(getCacheKeyGenerator().keyByAccessTokenValue(model.getAccessTokenValue()), model);
            }
            if (StringUtils.isNotEmpty(model.getRefreshTokenValue())) {
                getCacheService().set(getCacheKeyGenerator().keyByRefreshTokenValue(model.getRefreshTokenValue()), model);
            }
        }
    }

    /**
     * @see BaseCachingEntityService#setCache(IdEntity)
     */
    @Override
    public void deleteCache(AuthorizationEntity model) {
        if (!ObjectUtils.isEmpty(model)) {
            if (!ObjectUtils.isEmpty(model.getId())) {
                getCacheService().delete(getCacheKeyGenerator().keyById(model.getId()));
            }
            if (StringUtils.isNotEmpty(model.getState())) {
                getCacheService().delete(getCacheKeyGenerator().keyByState(model.getState()));
            }
            if (StringUtils.isNotEmpty(model.getAuthorizationCodeValue())) {
                getCacheService().delete(getCacheKeyGenerator().keyByAuthorizationCodeValue(model.getAccessTokenValue()));
            }
            if (StringUtils.isNotEmpty(model.getOidcIdTokenValue())) {
                getCacheService().delete(getCacheKeyGenerator().keyByOidcIdTokenValue(model.getOidcIdTokenValue()));
            }
            if (StringUtils.isNotEmpty(model.getAccessTokenValue())) {
                getCacheService().delete(getCacheKeyGenerator().keyByAccessTokenValue(model.getAccessTokenValue()));
            }
            if (StringUtils.isNotEmpty(model.getRefreshTokenValue())) {
                getCacheService().delete(getCacheKeyGenerator().keyByRefreshTokenValue(model.getRefreshTokenValue()));
            }
        }
    }

}
