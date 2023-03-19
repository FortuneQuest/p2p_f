package cn.oc.config;

import cn.oc.common.util.HttpUtil;
import cn.oc.domain.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : RestOAuth2AuthExceptionEntryPoint
 * @Author: oc
 * @Date: 2023/03/19/19:33
 * @Description:
 **/
public class RestOAuth2AuthExceptionEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        RestResponse restResponse = new RestResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        HttpUtil.writerError(restResponse, response);
    }
}
