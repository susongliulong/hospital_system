package com.sun;


import com.sun.entity.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.sun"})
@MapperScan("com.sun.mapper")
@EnableTransactionManagement
@Slf4j
public class HospitalApplication {

    private static final Logger logger = LoggerFactory.getLogger(HospitalApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);

        Doctor doctor = new Doctor();


        logger.info("系统启动成功");
    }

}
