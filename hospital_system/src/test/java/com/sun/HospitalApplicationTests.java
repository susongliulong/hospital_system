package com.sun;

import com.sun.entity.Patient;
import com.sun.mapper.MedicineMapper;
import com.sun.service.*;
import com.sun.util.CodeUtil;
import com.sun.util.SHACoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class HospitalApplicationTests {

    @Autowired
    private SystemsService systemsService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CureService cureService;

    @Autowired
    private MedicineService medicineService;

    @Resource
    private MedicineMapper medicineMapper;


    @Test
    public void testSendCode() throws Exception {
        //经过测试可以发射成功
        CodeUtil.sendCode("19860205976", "123478", systemsService.getById(1L));
    }

    @Test
    public void testEncode() {

        //测试加密
        System.out.println(SHACoder.encodeSHAHex("123456"));
    }

    /**
     * 测试插入数据时的主键的生成
     */
    @Test
    public void testInsert() {
        Patient patient = new Patient();
        patient.setName("liulong");
        patient.setAge(20);
        patient.setSex("男");
        patient.setBirthday(new Date());
        patient.setIdNumber("311000" + "311000" + "311000");
        patient.setPassword("123456");
        patient.setAddress("北京朝阳区阳光大道123");
        patient.setTelephone("19860205976");
        patientService.save(patient);
    }

    /**
     * 测试MP or方法
     */
    @Test
    public void testMPOr(){
        doctorService.findByPassword("19860205976","123456");
        doctorService.findByPassword("2112340780","123456");
    }

    /**
     * 测试CureMapper中的FindByPatientId
     */
    @Test
    public void testFindByPatientId(){
        System.out.println(cureService.findByPatientId("3119825704"));
    }

    @Test
    public void testFindMedicinesByKeyword(){

    }
    @Test
    public void testUpdateMedicine(){

    }

}
