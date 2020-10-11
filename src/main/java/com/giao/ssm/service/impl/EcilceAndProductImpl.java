package com.giao.ssm.service.impl;

import com.giao.ssm.mapper.OutProductMapper;
import com.giao.ssm.pojo.vo.OutProductVO;
import com.giao.ssm.service.EcilceAndProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/10/9 - 11:57
 */
@Service
public class EcilceAndProductImpl implements EcilceAndProductService {

    @Autowired
    OutProductMapper outProductMapper;


    @Override
    public List<OutProductVO>  excileAndProduct(String inputDateTime) {
        return outProductMapper.excileAndProduct(inputDateTime);
    }
}
