package cn.oc.common.util;

import cn.oc.domain.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : HttpUtil
 * @Author: oc
 * @Date: 2023/03/19/19:36
 * @Description:
 **/
public class HttpUtil {
    public static void writerError(RestResponse restResponse, HttpServletResponse response) throws IOException {
        response.setContentType("application/json,charset=utf-8");
        response.setStatus(restResponse.getCode());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), restResponse);
    }
}
