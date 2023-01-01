package com.sun.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.entity.Mapping;
import com.sun.entity.vo.MappingVO;

import java.util.List;

public interface MappingService extends IService<Mapping> {

    List<MappingVO> findByPrescribeId(Integer prescribeId);
}
