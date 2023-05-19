package cn.oc.account.service;

import cn.oc.account.common.AccountErrorCode;
import cn.oc.common.domain.BusinessException;
import cn.oc.common.domain.CommonErrorCode;
import cn.oc.common.domain.RestResponse;
import cn.oc.common.util.OkHttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : smsService
 * @Author: oc
 * @Date: 2023/04/08/16:19
 * @Description:
 **/
@Service
public class SmsService {

    @Value("${sms.url}")
    private  String smsURL;

    @Value("${sms.enable}")
    private  boolean smsEnable;

    public RestResponse getSmsCode(String mobile) {
        System.out.println(smsEnable);
        if (smsEnable) {
            System.out.println("进来");
            return OkHttpUtil.post(smsURL + "generate?effectiveTime=300&name=sms", "{\"mobile\":" + mobile + "}");
        }
        return RestResponse.success();
    }

    public void verifySmsCode(String key,String code){
        if (smsEnable) {
            StringBuilder params = new StringBuilder("/verify?name=sms");
            params.append("&verificationKey=").append(key).append("&verificationCode=").append(code);
            RestResponse smsResponse = OkHttpUtil.post(smsURL + params, "");
            if (smsResponse.getCode() != CommonErrorCode.SUCCESS.getCode() || smsResponse.getResult().toString().equalsIgnoreCase("false")) {
                throw new BusinessException(AccountErrorCode.E_140152);
            }
        }
    }

}
