package com.sun.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.common.R;
import com.sun.common.Systems;
import com.sun.entity.LoginLocation;
import com.sun.entity.Patient;
import com.sun.entity.People;
import com.sun.service.LoginLocationService;
import com.sun.service.SystemsService;
import com.sun.service.PatientService;
import com.sun.util.CodeUtil;
import com.sun.util.SHACoder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


@RequestMapping("/patient")
@Controller
@Slf4j
@ResponseBody
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private LoginLocationService loginLocationService;


    @Autowired
    private SystemsService systemsService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @PostMapping("/register")
    public R register(@RequestBody Patient patient){
        try{
            patientService.savePatient(patient);
        }catch (Exception e){
            e.printStackTrace();
            return R.error(null,"操作失败");
        }
        return R.success("账号修改注册成功");
    }

    @RequestMapping("/login")
    public R login(Patient patient, HttpServletRequest httpServletRequest){

        //根据user里面封存的信息查找用户
        People targetPatient = patientService.findByPatient(patient);

        if(targetPatient ==null){
            return R.error(null,"该用户尚未注册，请先注册");
        }
        String password=SHACoder.encodeSHAHex(patient.getPassword());
        if(!password.equals(targetPatient.getPassword())){
            return R.error(null,"用户名或者密码错误");
        }
        //判断用户是否在新的设备登录
        String remoteHost = httpServletRequest.getRemoteHost();

        //查询用户是否在上述设备登录
        LambdaQueryWrapper<LoginLocation> loginLocationLambdaQueryWrapper = new LambdaQueryWrapper<>();
        loginLocationLambdaQueryWrapper.eq(LoginLocation::getLocation,remoteHost);
        loginLocationLambdaQueryWrapper.eq(LoginLocation::getUserId, targetPatient.getId());
        LoginLocation location = loginLocationService.getOne(loginLocationLambdaQueryWrapper);

        if(location==null){
            //在该设备上第一次登录，需要发送验证码
            //生成验证码
            String code = CodeUtil.getCode(6);


            httpServletRequest.getSession().setAttribute("patient", targetPatient);
            logger.info("验证码为{}",code);
            //后期发送验证码
            Systems systems = systemsService.getById(1L);//系统配置文件
            CodeUtil.sendCode(targetPatient.getTelephone(),code,systems);

            //将验证码存入缓存
            //            httpServletRequest.getSession().setAttribute("code",code);
            stringRedisTemplate.opsForValue().set("code",code,60, TimeUnit.SECONDS);

            //将主机信息存入数据库
            loginLocationService.save(new LoginLocation(targetPatient.getId(),remoteHost));
            //返回结果
            return R.warning(patient,"用户第一次在该设备登录，需要进行登录验证");
        }

        //登录成功
        return R.success(targetPatient);
    }

    /**
     * 二次进行验证码登录验证
     * @param code
     * @param httpHttpServletRequest
     * @return
     */
    @GetMapping("/login/code")
    public R login( String code,HttpServletRequest httpHttpServletRequest){
        HttpSession session = httpHttpServletRequest.getSession();
        String c = stringRedisTemplate.opsForValue().get("code");
        if(!code.equals(c)){

            return R.error(null,"验证码不正确，请重新登录");
        }

        return R.success(session.getAttribute("patient"));
    }

    @GetMapping("/test")
    public R test(){
        People people = new People();
        people.setName("zhangsan");
        people.setPassword("123456");
        people.setTelephone("13188889999");

        return R.success(people);
    }
}
