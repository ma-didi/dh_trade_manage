package com.giao.ssm.controller.publics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuchang
 * @date 2020/9/23 - 13:26
 */
@Controller
@RequestMapping("common")
public class PublicControllers {


    @RequestMapping("contractAndAdd")
    public String contractAndAdd(){
        return "cargo/contract/jContractCreate";
    }
}
