package com.testMP;

import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.mapper.ExportCMapper;
import com.giao.ssm.service.IExportCService;
import com.giao.ssm.service.IExtEproductCService;
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
    private IExportCService exportCService;

    @Autowired
    private IExtEproductCService extEproductCService;


    @Test
    public void exprtCAndFindTest(){
        List<ExportcVO> andExport = exportCService.findAndExport();
        andExport.forEach(System.out::println);
    }


    @Test
    public void extEproAndInsert(){
        String[] i={"c2aa03e4db3a45bbaf9866a536ac59da","992724fbeb3c451ab7d8b9d69f6d68b1"};
        extEproductCService.exportAndInsert(i);
    }

}
