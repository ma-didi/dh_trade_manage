package com.liutest;

import com.giao.ssm.mapper.ExtCproductCMapper;
import com.giao.ssm.pojo.ContractProductC;
import com.giao.ssm.pojo.ExtCproductC;
import com.giao.ssm.service.ContractProductCService;
import com.giao.ssm.service.ExtCproductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuchang
 * @date 2020/9/24 - 0:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ContarctProductTest {

    @Autowired
    private ContractProductCService contractProductCService;

    @Autowired
    private ExtCproductService extCproductService;


    @Test
    public void test() {
        List<ContractProductC> contractProductCS = contractProductCService.ContractProductCAndFind("121aaqs");
        contractProductCS.forEach(System.out::println);
    }

    @Test
    public void extCproductTest() {
        String[] strings = extCproductService.extCproductAndFindAndIdNumber(new String[]{"5293953eabe14f0ca50ab840eac57fb2"});
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

    @Test
    public void conproAndDelteTest() {
        String[] strings = contractProductCService.contractProductCAdnFindAndPidNumber(new String[]{"641b30738c4c4a4e84911e3e2bd46372"});
        System.out.println(strings!=null);
        int i = contractProductCService.ContractProductCAnddelete(strings);
    }

    @Test
    public void conproAndTest(){

        ExtCproductC aaaa = extCproductService.getById("aaaa");
        System.out.println(aaaa);
    }

    @Autowired
    private ExtCproductCMapper extCproductCMapper;

    @Test
    public void jisuanzongjie(){
        Double aDouble = contractProductCService.contractGettotalAmount("222");
        System.out.println(aDouble);
    }


    @Test
    public void aaaa(){
        List<ContractProductC> contractProductCS = contractProductCService.proAndExtFind("992724fbeb3c451ab7d8b9d69f6d68b1");
         contractProductCS.forEach(System.out::println);
    }

}
