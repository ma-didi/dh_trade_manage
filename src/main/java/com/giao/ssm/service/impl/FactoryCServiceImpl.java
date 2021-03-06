package com.giao.ssm.service.impl;


import com.giao.ssm.mapper.FactoryCMapper;
import com.giao.ssm.pojo.FactoryC;
import com.giao.ssm.service.FactoryCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryCServiceImpl implements FactoryCService {

    @Autowired
    FactoryCMapper factoryCMapper;

    @Override
    public List<FactoryC> findFactAll() {
        return factoryCMapper.findFactAll();
    }

    @Override
    public int addFact(FactoryC factoryC) {
        return factoryCMapper.addFact(factoryC);
    }

    @Override
    public int deleteByid(String factoryId) {
        return factoryCMapper.deleteByid(factoryId);
    }

    @Override
    public int stop(String factoryId) {
        return factoryCMapper.stop(factoryId);
    }

    @Override
    public int start(String factoryId) {
        return factoryCMapper.start(factoryId);
    }

    @Override
    public FactoryC findFactOne(String factoryId) {
        return factoryCMapper.findFactOne(factoryId);
    }

    @Override
    public int updateFac(FactoryC factoryC) {
        return factoryCMapper.updateFac(factoryC);
    }
}
