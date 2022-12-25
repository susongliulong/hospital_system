package com.sun.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.sun.common.Systems;

import com.sun.service.impl.SystemsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 生成验证码
 */
@Slf4j
@Component
public class CodeUtil {

    private final static Random random = new Random();


    public static String getCode(int length){

        char [] digits={'1','2','3','4','5','6','7','8','9','0'};
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(digits[random.nextInt(digits.length)]);
        }
        return stringBuilder.toString();
    }

    public static void sendCode(String telephone,String message,Systems systems){

        //相关配置重服务器读取
        DefaultProfile profile = DefaultProfile.getProfile(
                systems.getRegionId(),
                systems.getAccessKeyId(),
                systems.getSecret()
        );
        IAcsClient client = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setSignName("阿里云短信测试");
        request.setTemplateCode(systems.getTemplateCode());
        request.setPhoneNumbers(telephone);
        request.setTemplateParam("{code:"+message+"}");

        try {
            SendSmsResponse response = client.getAcsResponse(request);
            log.info("返回的信息为"+new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            log.error("发送给{}的验证码出现问题：{}",request.getPhoneNumbers(),e.getErrMsg());
        }

    }
}
