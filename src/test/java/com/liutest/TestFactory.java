package com.liutest;

import com.giao.ssm.mapper.FactoryCMapper;
import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.FactoryC;
import com.giao.ssm.pojo.vo.ContractCVO;
import com.giao.ssm.service.ContractCService;
import com.giao.ssm.service.FactoryCService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/21 - 23:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestFactory {


    @Autowired
    private FactoryCMapper factoryCMapper;

    @Autowired
    private ContractCService contractCService;

    @Autowired
    private FactoryCService factoryCService;

    @Test
    public void tetsPlus(){
        List<FactoryC> factoryCS = factoryCMapper.selectList(null);
        factoryCS.forEach(System.out::println);
    }

    @Test
    public void findAndContra(){
        List<FactoryC> contractCVOS = factoryCService.findFactAll();
        contractCVOS.forEach(System.out::println);
    }

    @Test
    public void deleteAndcontra(){
        String[] id=new String[2];
        id[0] = "dasdasdwe2";
        id[1]="dadsadadsa";
        contractCService.contractDelete(id);
    }

    @Test
    public void a01(){
        contractCService.contractUpdateAmount( 23.5D,"222");
    }

}
