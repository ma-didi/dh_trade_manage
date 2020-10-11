package com.testMP;

import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.mapper.ExportCMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/10/11 - 16:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExportCTest {

    @Autowired
    private ExportCMapper exportCMapper;


    @Test
    public void exprtCAndFindTest(){
        List<ExportcVO> andExport = exportCMapper.findAndExport(null);
        andExport.forEach(System.out::println);
    }



}
