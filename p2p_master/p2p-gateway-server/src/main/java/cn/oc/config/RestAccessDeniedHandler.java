package cn.oc.config;

import cn.oc.common.util.HttpUtil;
import cn.oc.domain.RestResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : RestAccessDeniedHandler
 * @Author: oc
 * @Date: 2023/03/19/19:27
 * @Description:
 **/
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
        RestResponse restResponse = new RestResponse(HttpStatus.FORBIDDEN.value(), "没有权限");
        HttpUtil.writerError(restResponse, response);
    }
}
