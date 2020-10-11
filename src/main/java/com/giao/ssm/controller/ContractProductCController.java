package com.giao.ssm.controller;

import com.giao.ssm.pojo.ContractProductC;
import com.giao.ssm.pojo.FactoryC;
import com.giao.ssm.service.ContractProductCService;
import com.giao.ssm.service.ExtCproductService;
import com.giao.ssm.service.FactoryCService;
import com.giao.ssm.utill.UtilUUID;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/23 - 21:43
 */
@RequestMapping("productc")
@Controller
public class ContractProductCController {

    @Autowired
    private UtilUUID utilUUID;

    @Autowired
    private FactoryCService factoryCService;

    @Autowired
    private ContractProductCService contractProductCService;

    @Autowired
    private ExtCproductService extCproductService;

    public Logger logger = Logger.getLogger(this.getClass());


    @RequestMapping("contractProductCAndAddOne/{id}")
    public String contractProductCAndAdd(@PathVariable("id") String id, HttpSession session, Model model) {
        List<FactoryC> factAll = factoryCService.findFactAll();
        session.setAttribute("contractId", id);
        session.setAttribute("factoryList", factAll);
        return "cargo/contract/jContractProductCreate";
    }

    @RequestMapping("contractProductCAndAddTwo")
    public String contractProductCAndAddTwo(ContractProductC contractProductC, Model model) {
        contractProductC.setContratProductId(utilUUID.uuid());
        contractProductC.setAmount(contractProductC.getPrice() * contractProductC.getCnumber());
        contractProductCService.ContractProductCAndInsert(contractProductC);
        contractAndPublicFind(contractProductC.getContractId(), model);
        return "cargo/contract/jContractProductCreate";
    }

    @RequestMapping("contractProductCAndDelete")
    public String contractProductCAndDelete(String contractProductId, String contractId, Model model) {
       String[] num={contractProductId};
        contractProductCService.ContractProductCAnddelete(num);
        contractAndPublicFind(contractId, model);
        return "cargo/contract/jContractProductCreate";
    }


    @RequestMapping("contractProductCAndUpdateOne")
    public String contractProductCAndUpdateOne(String contractProductId, Model model) {
        ContractProductC contractProductC = contractProductCService.ContractProductCAndFindAndPid(contractProductId);
        model.addAttribute("con",contractProductC);
        return "cargo/contract/jContractProductUpdate";
    }

    @RequestMapping("contractProductAndUpdateTwo")
    public String contractProductAndUpdateTwo(ContractProductC contractProductC,Model model){
        contractProductC.setAmount(contractProductC.getPrice() * contractProductC.getCnumber());
        contractProductCService.ContractProductCAndupdate(contractProductC);
        contractAndPublicFind(contractProductC.getContractId(),model);
        return "cargo/contract/jContractProductCreate";
    }

    private void contractAndPublicFind(String id, Model model) {
        List<ContractProductC> contractProductCS = contractProductCService.ContractProductCAndFind(id);
        model.addAttribute("dataList", contractProductCS);
    }
}
