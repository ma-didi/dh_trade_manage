package com.liutest;

import com.giao.ssm.pojo.FactoryC;
import com.giao.ssm.service.FactoryCService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestApp {

    @Autowired
    FactoryCService factoryCService;

    @Test
    public void  find(){
        List<FactoryC> pro=factoryCService.findFactAll();
        pro.forEach(System.out::println);

    }

    @Test
    public void add(){
        FactoryC factoryC = new FactoryC();
        factoryC.setFactoryId(uuid());
        factoryC.setFactoryName("dassd");
        factoryC.setFullName("e4q23eas");
        factoryC.setContactor("2131");
        factoryC.setPhone("4312423423");
        factoryC.setMobile("13123sdasdsa");
        factoryC.setFax("afd3rasd32wrasd3");
        factoryC.setCnote("发生无法");
        factoryC.setCtype(1);
        factoryC.setState("1");
        factoryC.setOrderNo(12);
        factoryC.setCreateBy("2313asdas");
        factoryC.setCreateDept("dadsa232");
        factoryC.setCreateTime(null);
        factoryC.setInspector("789");
        System.out.println(factoryC.toString());
        factoryCService.addFact(factoryC);
    }
    public String uuid() {
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        return s;

    }
}
