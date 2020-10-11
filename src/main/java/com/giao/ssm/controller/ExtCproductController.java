package com.giao.ssm.controller;

import com.giao.ssm.pojo.ExtCproductC;
import com.giao.ssm.service.ExtCproductService;
import com.giao.ssm.service.FactoryCService;
import com.giao.ssm.utill.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/24 - 21:23
 */
@Controller
@RequestMapping("extCproduct")
public class ExtCproductController {

    @Autowired
    private UtilUUID uuid;

    @Autowired
    private ExtCproductService extCproductService;


    @RequestMapping("extCproductAndAddOne/{id}")
    public String extCproductAndAddOne(@PathVariable("id") String id,HttpSession session){
        session.setAttribute("extCproductId",id);
        return "cargo/contract/jExtCproductCreate";
    }

    @RequestMapping("extCproductAndAddTwo")
    public String extCproductAndAddTwo(ExtCproductC extCproductC,Model model){
        extCproductC.setExtCproductId(uuid.uuid());
        extCproductC.setAmount(extCproductC.getPrice()*extCproductC.getCnumber());
        extCproductService.extCproductAndInsert(extCproductC);
        extCproductAndFind(model,extCproductC.getContractProductId());
        return "cargo/contract/jExtCproductCreate";
    }

    @RequestMapping("extCproductDeleteId")
    public String extCproductDeleteId(String extCproductId,String contractProductId,Model model){
        String[] id={extCproductId};
        extCproductService.extCproductAndDelete(id);
        extCproductAndFind(model,contractProductId);
        return "cargo/contract/jExtCproductCreate";
    }

    @RequestMapping("extCproductUpdateOne")
    public String extCproductUpdateOne(String extCproductId,Model model){
        System.out.println(extCproductId);
        ExtCproductC extCproductC = extCproductService.extCproductAndFindAndFid(extCproductId);
        model.addAttribute("obj",extCproductC);
        return "cargo/contract/jExtCproductUpdate";
    }

    @RequestMapping("extCproductUpateTwo")
    public String extCproductUpateTwo(ExtCproductC extCproductC,Model model){
        extCproductC.setAmount(extCproductC.getPrice()*extCproductC.getCnumber());
        extCproductService.extCproductAndUpdate(extCproductC);
        extCproductAndFind(model,extCproductC.getContractProductId());
        return "cargo/contract/jExtCproductCreate";
    }

    public void extCproductAndFind(Model model,String id){
        List<ExtCproductC> extCproductCS = extCproductService.extCproductAndFind(id);
        model.addAttribute("dataList",extCproductCS);
    }




}
