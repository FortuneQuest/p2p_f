package cn.oc.consumer.utils;

import cn.oc.common.domain.BusinessException;
import cn.oc.common.util.Base64Util;
import cn.oc.common.util.HttpUtil;
import cn.oc.consumer.common.ConsumerErrorCode;
import java.net.URLEncoder;

/**
 * @author yuelimin
 * @version 1.0.0
 * @since 1.8
 */
public class BaiDuOrcIdCardUtil {
    private static final String URL = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";

    public static String idCardBack(byte[] imgData) {
        try {
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "id_card_side=" + "back" + "&image=" + imgParam;
            String accessToken = BaiDuOrcAuthServiceUtil.getAuth();

            return HttpUtil.post(URL, accessToken, param);
        } catch (Exception e) {
            throw new BusinessException(ConsumerErrorCode.E_140162);
        }
    }

    public static String idCardFront(byte[] imgData) {
        try {
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "id_card_side=" + "front" + "&image=" + imgParam;
            String accessToken = BaiDuOrcAuthServiceUtil.getAuth();

            return HttpUtil.post(URL, accessToken, param);
        } catch (Exception e) {
            throw new BusinessException(ConsumerErrorCode.E_140162);
        }
    }
}
