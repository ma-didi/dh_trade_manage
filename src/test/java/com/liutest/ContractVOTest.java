package com.liutest;

import com.giao.ssm.mapper.ContractProductVOMapperPO;
import com.giao.ssm.pojo.vo.ContractCVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/10/10 - 16:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ContractVOTest {


    @Autowired
    private ContractProductVOMapperPO contractProductVOMapperPO;


    @Test
    public void conTest01(){
        String id="992724fbeb3c451ab7d8b9d69f6d68b1";
        ContractCVO contractCVOS = contractProductVOMapperPO.viewAndCon(id);
        System.out.println(contractCVOS.toString());
    }

}
