package cn.oc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : JWTConfig
 * @Author: oc
 * @Date: 2023/03/19/19:09
 * @Description:
 **/
@Configuration
public class JWTConfig {

    private String SIGNING_KEY = "p2p123";

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 对称秘钥, 资源服务器使用该秘钥来解密
        converter.setSigningKey(SIGNING_KEY);
        converter.setAccessTokenConverter(new ClientDefaultAccessTokenConverter());
        return converter;
    }
}
