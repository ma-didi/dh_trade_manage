package com.giao.ssm.controller;


import com.giao.ssm.pojo.FactoryC;
import com.giao.ssm.service.FactoryCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/fac")
public class FactoryCController {
    @Autowired
    FactoryCService factoryCService;






   @RequestMapping("/findFacAll")
    public String findFacAll(Map map) {
        List<FactoryC> fac = factoryCService.findFactAll();
        System.out.println(fac);
        System.out.println();
        map.put("dataList", fac);
        return "basicinfo/factory/jFactoryList";
    }

    @RequestMapping("/addFacTo")
    public String addFacTo() {

        return "basicinfo/factory/jFactoryCreate";
    }

    public String uuid() {
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        return s;
    }

    @RequestMapping("/addFac")
    public String addFac(FactoryC factoryC){
        System.out.println(factoryC+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        factoryC.setFactoryId(uuid());
        factoryCService.addFact(factoryC);
        return "redirect:/fac/findFacAll";
    }

    @RequestMapping("/deleteByid")
    public String deleteByid(String[] factoryId){
        for (int i=0; i<factoryId.length;i++){
        factoryCService.deleteByid(factoryId[i]);
        }
        return "redirect:/fac/findFacAll";

    }
    @RequestMapping("/stop")
    public String stop(String[] factoryId){
       for (int i=0;i<factoryId.length;i++){
        System.out.println("停用"+factoryId);
        factoryCService.stop(factoryId[i]);
        }
        return "redirect:/fac/findFacAll";

    }

    @RequestMapping("/start")
    public String start(String[] factoryId){
       for (int i=0;i<factoryId.length;i++){
        System.out.println("启用"+factoryId);
        factoryCService.start(factoryId[i]);
       }
        return "redirect:/fac/findFacAll";

    }

    @RequestMapping("/findFactOne")
    public String findFactOne(String factoryId,Map map){
        FactoryC factoryC1=factoryCService.findFactOne(factoryId);
        map.put("obj",factoryC1);
        return "basicinfo/factory/jFactoryView";
    }
    @RequestMapping("/updateto")
    public String updateto(String factoryId,Map map){
        System.out.println(factoryId);
        FactoryC factoryC1=factoryCService.findFactOne(factoryId);
        map.put("obj",factoryC1);
        return "basicinfo/factory/jFactoryUpdate";
    }
    @RequestMapping("/updateFac")
    public String updateFac(FactoryC factoryC){
        System.out.println(factoryC);
        System.out.println(factoryC.getFactoryId());

        factoryCService.updateFac(factoryC);
        return "redirect:/fac/findFacAll";
    }

}
