package cn.elvea.platform.security.authentication;

import cn.elvea.platform.commons.core.security.CustomAuthorizationGrantType;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author elvea
 * @since 0.0.1
 */
@Getter
public class SmsAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

    private final Set<String> scopes;

    public SmsAuthenticationToken(Authentication clientPrincipal, @Nullable Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
        super(CustomAuthorizationGrantType.PASSWORD, clientPrincipal, additionalParameters);
        Assert.notNull(clientPrincipal, "clientPrincipal cannot be null");
        this.scopes = Collections.unmodifiableSet(CollectionUtils.isNotEmpty(scopes) ? new HashSet<>(scopes) : Collections.emptySet());
    }

}
