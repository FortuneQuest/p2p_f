package cn.oc.filter;

import cn.oc.util.EncryptUtil;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : AuthFilter
 * @Author: oc
 * @Date: 2023/03/19/16:31
 * @Description:
 **/
@Component
public class AuthFilter extends ZuulFilter {



    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取Spring Security OAuth2的认证信息对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof OAuth2Authentication)) {
            return null;
        }
        // 将当前登录的用户以及接入客户端的信息放入Map中
        OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;
        Map<String, String> jsonToken = new HashMap<>(oauth2Authentication.getOAuth2Request().getRequestParameters());
        if (jsonToken.get("mobile") != null) {
            currentContext.addZuulRequestHeader("jsonToken", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        }
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
