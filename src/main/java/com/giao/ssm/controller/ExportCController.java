package com.giao.ssm.controller;


import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.ExportProductC;
import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.service.IExportCService;
import com.giao.ssm.service.IExportProductCService;
import com.giao.ssm.service.IExtEproductCService;
import com.giao.ssm.utill.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
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

    @Autowired
    private IExportProductCService exportProductCService;


    @RequestMapping("find")
    public String find(Model model) {
        List<ExportcVO> andExport = exportCService.findAndExport();
        model.addAttribute("dataList", andExport);
        return "cargo/contract/jExportList";
    }


    @RequestMapping("aad")
    public String insert(String[] id) {
        if (id.length > 0 && id != null) {
            extEproductCService.exportAndInsert(id);
        }
        return "redirect:/ssm/export-c/find";
    }


    @RequestMapping("updateAndId")
    public String updateAndId(@RequestParam("id") String id, Model model) {
        ExportcVO andExport = exportCService.findAndExportId(id);
        model.addAttribute("obj",  andExport);
        model.addAttribute("mRecordData", getMrecordData(andExport.getExportProductCS()));
        return "cargo/contract/jExportUpdate";
    }


    @RequestMapping("update")
    public String update(ExportcVO exportcVO, String[] mr_id,
                         Integer[] mr_orderNo,
                         Integer[] mr_cnumber,
                         Double[] mr_grossWeight,
                         Double[] mr_netWeight,
                         Double[] mr_sizeLength,
                         Double[] mr_sizeWidth,
                         Double[] mr_sizeHeight,
                         Double[] mr_exPrice,
                         Double[] mr_tax,
                         Integer[] mr_changed
    ) {
        exportcVO.setExportId(exportcVO.getId());
        System.out.println(exportcVO);
        exportCService.updateById(exportcVO);
        for (int i = 0; i < mr_id.length; i++) {
            //修改标识，只有用户修改的行才进行更新
            ExportProductC ep = new ExportProductC();
            ep.setExportProductId(mr_id[i]);
            ep.setOrderNo(new BigDecimal(mr_orderNo[i]));
            ep.setCnumber(new BigDecimal(mr_cnumber[i]));
            if(mr_grossWeight[i]!=null){
                ep.setGrossWeight(new BigDecimal(mr_grossWeight[i]));
            }
            if (mr_netWeight[i]!=null){
                ep.setNetWeight(new BigDecimal(mr_netWeight[i]));
            }
            if (mr_sizeLength[i]!=null){
                ep.setSizeLenght(new BigDecimal(mr_sizeLength[i]));
            }
            if (mr_sizeWidth[i]!=null){
                ep.setSizeWidth(new BigDecimal(mr_sizeWidth[i]));
            }
            if (mr_sizeHeight[i]!=null){
                ep.setSizeHeight(new BigDecimal(mr_sizeHeight[i]));
            }
            if (mr_exPrice[i]!= null){
                ep.setExPrice(new BigDecimal(mr_exPrice[i]));
            }
            if(mr_tax[i] != null){
                ep.setTax(new BigDecimal(mr_tax[i]));
            }
            exportProductCService.updateById(ep);
        }
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
