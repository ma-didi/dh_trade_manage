package com.testMP;

import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.mapper.ExportCMapper;
import com.giao.ssm.service.IExportCService;
import com.giao.ssm.service.IExtEproductCService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
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
    public void exprtCAndFindTest() {
        List<ExportcVO> andExport = exportCService.findAndExport();
        andExport.forEach(System.out::println);
    }


    public PageInfo findPage(int page,int pageSize){
        PageHelper.startPage(1,1);
        List<ExportcVO> andExport = exportCService.findAndExport();
        PageInfo exportcVOPageInfo = new PageInfo(andExport);
        return exportcVOPageInfo;
    }


    @Test
    public void findAndTestPage(){
        PageInfo page = findPage(1, 2);
        List list = page.getList();
        System.out.println(page);
        list.forEach(System.out::println);
    }

    @Test
    public void extEproAndInsert() {
        String[] i = {"c2aa03e4db3a45bbaf9866a536ac59da", "992724fbeb3c451ab7d8b9d69f6d68b1"};
        extEproductCService.exportAndInsert(i);
    }

    @Test
    public void exproAndFindId() {
        ExportcVO andExport = exportCService.findAndExportId("a36af32402aa46519879b1a1b52dc06d");
        System.out.println(andExport.toString());
    }

    @Test
    public void test(){
        Double a;

    }



}
