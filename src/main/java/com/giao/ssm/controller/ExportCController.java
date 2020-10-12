package com.giao.ssm.controller;


import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.ExportProductC;
import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.service.IExportCService;
import com.giao.ssm.service.IExtEproductCService;
import com.giao.ssm.utill.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
@Controller
@RequestMapping("/ssm/export-c")
public class ExportCController {

    @Autowired
    private IExportCService exportCService;

    @Autowired
    private IExtEproductCService extEproductCService;


    @RequestMapping("find")
    public String find(Model model){
        List<ExportcVO> andExport = exportCService.findAndExport();
        model.addAttribute("dataList",andExport);
        return "cargo/contract/jExportList";
    }


    @RequestMapping("aad")
    public String insert(String[] id){
        if(id.length>0 && id != null ){
            extEproductCService.exportAndInsert(id);
        }
        return "redirect:/ssm/export-c/find";
    }


    @RequestMapping("updateAndId")
    public String updateAndId(@RequestParam("id") String id, Model model){
        System.out.println(id);
        ExportcVO andExport = exportCService.findAndExportId(id);
        model.addAttribute("obj",(ExportC)andExport);
        System.out.println(getMrecordData(andExport.getExportProductCS()));
        model.addAttribute("mRecordData",getMrecordData(andExport.getExportProductCS()));
        return "cargo/contract/jExportUpdate";
    }


    @RequestMapping("update")
    public String update(){

        return "redirect:/ssm/export-c/find";
    }


    //拼接JS串
    // function addTRRecord(objId, id, productNo, cnumber, grossWeight,
    // netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
    public String getMrecordData(List<ExportProductC> exportProductCList) {

        StringBuffer sBuf = new StringBuffer();
        for (ExportProductC ep : exportProductCList) {
            sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getExportProductId()).append("\", \"")
                    .append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getSizeLenght())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"")
                    .append(UtilFuns.convertNull(ep.getTax())).append("\");");
        }


        return sBuf.toString();
    }

}
