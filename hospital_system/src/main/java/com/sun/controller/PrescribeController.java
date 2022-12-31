package com.sun.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.common.LocalIdThread;
import com.sun.common.R;
import com.sun.entity.Make;
import com.sun.entity.Medicine;
import com.sun.entity.Prescribe;
import com.sun.service.MakeService;
import com.sun.service.MappingService;
import com.sun.service.MedicineService;
import com.sun.service.PrescribeService;
import com.sun.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prescribe")
public class PrescribeController {
    @Autowired
    private MakeService makeService;
    @Autowired
    private MappingService mappingService;
    @Autowired
    private PrescribeService prescribeService;
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private LocalIdThread<Integer> localIdThread;

    @PostMapping("/addPrescribe")
    @Transactional
    public R addPrescribe(String doctorId,
                          String patientId,
                          String description,
                          String date,
                          Integer isInPatient,@RequestBody String medicines) throws Exception{

        //生成处方信息
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = simpleDateFormat.parse(date);
        prescribeService.save(new Prescribe(isInPatient,parseDate,description));
        Integer prescribeId = localIdThread.get();

        //插入数据到mapping表中
        JSONObject jsonObject = JSONObject.parseObject(medicines);
        Object jsonString = jsonObject.get("medicines");
        List<Medicine> list = JSONArray.parseArray((String)jsonString, Medicine.class);

        for (Medicine medicine : list) {
            mappingService.save(BeanUtil.copyPrescribe(medicine,prescribeId));
        }

        //处理make表信息
        Make make = new Make();
        make.setDocId(doctorId);
        make.setPatientId(patientId);
        make.setPriId(prescribeId);
        makeService.save(make);

        medicineService.updateMedicine(list);

        return R.success(null,"处方信息处理成功");
    }

    @PostMapping("/test")
    public void test( @RequestBody Medicine []medicines){
        System.out.println(Arrays.toString(medicines));
    }
}
