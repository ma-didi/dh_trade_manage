package com.giao.ssm.service;

import com.giao.ssm.mapper.OutProductMapper;
import com.giao.ssm.pojo.vo.OutProductVO;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/10/9 - 11:56
 */
public interface EcilceAndProductService {

    List<OutProductVO>  excileAndProduct(String inputDateTime);

}
