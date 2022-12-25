package com.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.R;
import com.sun.common.Systems;
import com.sun.entity.Patient;
import com.sun.entity.People;
import com.sun.service.SystemsService;
import com.sun.service.PatientService;
import com.sun.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private SystemsService systemsService;

    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 专门处理发送验证码逻辑
     * @return
     */
    @GetMapping("/code")
    public R sendCode(HttpServletRequest httpHttpServletRequest){

        String code = CodeUtil.getCode(6);
        HttpSession session = httpHttpServletRequest.getSession();
        People people =(People) session.getAttribute("patient");
        Systems systems = systemsService.getById(1L);
        CodeUtil.sendCode(people.getTelephone(),code,systems);
        //        session.setAttribute("code",code);
        redisTemplate.opsForValue().set("code",code,60, TimeUnit.SECONDS);
        return R.success(null,"验证码发送成功");
    }

    /**
     * 当用户输入完手机号以后，验证用户输入的手机号是否正确
     * @param telephone
     * @param httpServletRequest
     * @return
     */
    @GetMapping("/get")
    public R getTelephone(String telephone, HttpServletRequest httpServletRequest){

        LambdaQueryWrapper<Patient> patientLambdaQueryWrapper = new LambdaQueryWrapper<>();
        patientLambdaQueryWrapper.eq(Patient::getTelephone,telephone);

        Patient patient = patientService.getOne(patientLambdaQueryWrapper);

        if(patient ==null){
            //用户手机号输入有误
            return R.error(telephone,"手机号有误");
        }
        //存入session当中
        httpServletRequest.getSession().setAttribute("patient", patient);
        return R.success(patient);
    }
}
