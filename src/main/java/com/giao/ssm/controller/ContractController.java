package com.giao.ssm.controller;

import com.giao.ssm.mapper.ContractProductVOMapperPO;
import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.ContractProductC;
import com.giao.ssm.pojo.vo.ContractCVO;
import com.giao.ssm.service.ContractCService;
import com.giao.ssm.service.ContractProductCService;
import com.giao.ssm.utill.ContractPrint;
import com.giao.ssm.utill.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/23 - 0:04
 */
@RequestMapping("contract")
@Controller
public class ContractController {


    @Autowired
    private ContractCService contractCService;

    @Autowired
    private UtilUUID utilUUID;

    @Autowired
    private ContractProductCService contractProductCService;

    @Autowired
    private ContractProductVOMapperPO contractProductVOMapperPO;

    @RequestMapping("contractAndFind")
    public String contractAndFind(Model model) {
        List<ContractC> contractCList = contractCService.contractAndFind();
        for (ContractC c :
                contractCList) {

            Double aDouble = contractProductCService.contractGettotalAmount(c.getContractId());
            aDouble = Math.round(aDouble * 1000) * 0.001d;
            contractCService.contractUpdateAmount(aDouble, c.getContractId());
            c.setTotalAmount(aDouble);
            c.setExtCproductCount(contractProductCService.extcproductGetCount(c.getContractId()));
            c.setContractProductCount(contractProductCService.contractGetCount(c.getContractId()));
        }
        model.addAttribute("dataList", contractCList);
        return "cargo/contract/jContractList";
    }

    @RequestMapping("exportTractAndFind")
    public String exportTractAndFind(Model model) {
        List<ContractC> contractCList = contractCService.contractAndFind();
        for (ContractC c :
                contractCList) {

            Double aDouble = contractProductCService.contractGettotalAmount(c.getContractId());
            aDouble = Math.round(aDouble * 1000) * 0.001d;
            contractCService.contractUpdateAmount(aDouble, c.getContractId());
            c.setTotalAmount(aDouble);
            c.setExtCproductCount(contractProductCService.extcproductGetCount(c.getContractId()));
            c.setContractProductCount(contractProductCService.contractGetCount(c.getContractId()));
        }
        model.addAttribute("dataList", contractCList);
        return "cargo/contract/jExportContractList";
    }


    @RequestMapping("contractAndInsert")
    public String contractAndInsert(ContractC contractC) {
        contractC.setContractId(utilUUID.uuid());
        contractCService.contractInserrt(contractC);
        return "redirect:/contract/contractAndFind";
    }

    @RequestMapping("contractAndDelete")
    public String contractAndDelete(String[] id) {
        String[] strings = contractProductCService.contractProductCAdnFindAndPidNumber(id);
        contractProductCService.ContractProductCAnddelete(strings);
        contractCService.contractDelete(id);
        return "redirect:/contract/contractAndFind";
    }

    @RequestMapping("contractAndSelectAndFindID")
    public String contractAndSelectAndFindID(String id, Model model) {
        ContractC contractC = contractCService.contractAndDFindCid(id);
        model.addAttribute("obj", contractC);
        return "cargo/contract/jContractUpdate";
    }

    @RequestMapping("contractAndUpdate")
    public String contractAndUpdate(ContractC c) {
        contractCService.contractUpdate(c);
        return "redirect:/contract/contractAndFind";
    }

    @RequestMapping("toview/{id}")
    public String toview(@PathVariable("id") String id, Model model){
        ContractC contractC = contractCService.contractAndDFindCid(id);
        List<ContractProductC> contractProductCS = contractProductCService.proAndExtFind(id);
        model.addAttribute("contractToviewId",contractC);
        model.addAttribute("proAndExtFind",contractProductCS);
        contractProductCS.forEach(System.out::println);
        return "cargo/contract/jContraToview";
    }

    @RequestMapping("contractPrint")
    public void contractPrints(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ContractCVO contractCVOS = contractProductVOMapperPO.viewAndCon(id);
        String path = request.getSession().getServletContext().getRealPath("/");
        ContractPrint contractPrint = new ContractPrint();
        contractPrint.print(contractCVOS,path,response);
    }

}
