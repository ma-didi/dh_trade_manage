package com.giao.ssm.controller;


import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.service.IExportCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("find")
    public String find(Model model){
        List<ExportcVO> andExport = exportCService.findAndExport();
        model.addAttribute("dataList",andExport);
        return "cargo/contract/jExportList";
    }

}
