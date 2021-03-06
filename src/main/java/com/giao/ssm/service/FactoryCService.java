package com.giao.ssm.service;

import com.giao.ssm.pojo.FactoryC;

import java.util.List;

public interface FactoryCService {
    List<FactoryC> findFactAll();
    int addFact(FactoryC factoryC);
    int deleteByid(String factoryId);

    int stop(String factoryId);
    int start(String factoryId);
    FactoryC findFactOne(String factoryId);
    int updateFac(FactoryC factoryC);
}
