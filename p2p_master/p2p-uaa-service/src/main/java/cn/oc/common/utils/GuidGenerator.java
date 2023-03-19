package cn.oc.common.utils;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : GuidGenerator
 * @Author: oc
 * @Date: 2023/03/19/21:32
 * @Description:
 **/
public abstract class GuidGenerator {
    private static RandomValueStringGenerator defaultClientSecretGenerator = new RandomValueStringGenerator(32);

    /**
     * private constructor
     */
    private GuidGenerator() {
    }

    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateClientSecret() {
        return defaultClientSecretGenerator.generate();
    }

}
