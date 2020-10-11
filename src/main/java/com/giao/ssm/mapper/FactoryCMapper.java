package com.giao.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.giao.ssm.pojo.FactoryC;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactoryCMapper extends BaseMapper<FactoryC> {
    List<FactoryC> findFactAll();
    int addFact(FactoryC factoryC);
    int deleteByid(String factoryId);
    int stop(String factoryId);
    int start(String factoryId);
    FactoryC findFactOne(String factoryId);
    int updateFac(FactoryC factoryC);

}
