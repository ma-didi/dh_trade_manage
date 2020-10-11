package com.giao.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.giao.ssm.mapper.ContractProductCMapper;
import com.giao.ssm.pojo.ContractProductC;
import com.giao.ssm.pojo.ExtCproductC;
import com.giao.ssm.service.ContractProductCService;
import com.giao.ssm.service.ExtCproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuchang
 * @date 2020/9/23 - 22:27
 */
@Service("contractProductCService")
public class ContractProductCServiceImpl extends ServiceImpl<ContractProductCMapper, ContractProductC> implements ContractProductCService {

    @Autowired
    private ContractProductCMapper cMapper;

    @Resource
    private ExtCproductService extCproductService;


    /**
     * 根据id查询多个
     * @param id
     * @return
     */
    @Override
    public List<ContractProductC> ContractProductCAndFind(String id) {
        QueryWrapper<ContractProductC> query = Wrappers.query();
        Map<String, String> map = new HashMap<>();
        map.put("CONTRACT_ID", id);
        query.allEq(map);
        return cMapper.selectList(query);
    }

    @Override
    public int ContractProductCAndInsert(ContractProductC productC) {
        return cMapper.insert(productC);
    }

    @Override
    public int ContractProductCAnddelete(String[] id) {
        if (id != null && id.length > 0) {
            String[] strings = extCproductService.extCproductAndFindAndIdNumber(id);
            if (strings != null && strings.length > 0) {
                extCproductService.extCproductAndDelete(strings);
            }
            QueryWrapper<ContractProductC> query = Wrappers.query();
            query.in("CONTRACT_PRODUCT_ID", id);
            cMapper.delete(query);
        }
        return 0;
    }

    @Override
    public int ContractProductCAndupdate(ContractProductC productC) {
        return cMapper.updateById(productC);
    }

    @Override
    public ContractProductC ContractProductCAndFindAndPid(String id) {
        return cMapper.selectById(id);
    }

    @Override
    public String[] contractProductCAdnFindAndPidNumber(String[] id) {
        QueryWrapper<ContractProductC> query = Wrappers.query();
        query.in("CONTRACT_ID", id).select(ContractProductC.class, info -> info.getColumn().equals("CONTRACT_PRODUCT_ID"));
        List<ContractProductC> contractProductCS = cMapper.selectList(query);
        String[] num = new String[contractProductCS.size()];
        int i = 0;
        for (ContractProductC a :
                contractProductCS) {
            num[i] = a.getContratProductId();
            i++;
        }

        return num;
    }

    /**
     * 货物数
     *
     * @param id
     * @return
     */
    @Override
    public Integer contractGetCount(String id) {
        Integer i = 0;
        if (id != null && id != "") {
            QueryWrapper<ContractProductC> query = Wrappers.query();
            query.eq("CONTRACT_ID", id);
            i = cMapper.selectCount(query);
        }
        return i;
    }

    /**
     * 附件数
     *
     * @param id
     * @return
     */
    @Override
    public Integer extcproductGetCount(String id) {
        Integer i = 0;
        if (id != null && id != "") {
            String[] strings = contractProductCAdnFindAndPidNumber(new String[]{id});
            if (strings != null && strings.length > 0) {
                i = extCproductService.extCproductGetCount(strings);
            }
        }
        return i;
    }

    @Override
    public Double contractGettotalAmount(String id) {
        Double num = 0D;
        QueryWrapper<ContractProductC> query = Wrappers.query();
        query.in("CONTRACT_ID", id).select(ContractProductC.class, info -> info.getColumn().equals("AMOUNT"));
        List<ContractProductC> contractProductCS = cMapper.selectList(query);
        if (contractProductCS != null && contractProductCS.size() > 0) {
            for (ContractProductC c :
                    contractProductCS) {
                num += c.getAmount();
            }
        }
        num = Math.round(num * 1000) * 0.001d;
        System.out.println("num" + num);
        Double num01 = exttractGettotalAmout(id);
        System.out.println("num01" + num01);
        num = num + num01;
        return num;
    }

    @Override
    public Double exttractGettotalAmout(String id) {
        Double num = 0D;
        String[] andPidNumber = contractProductCAdnFindAndPidNumber(new String[]{id});
        if (andPidNumber != null && andPidNumber.length > 0) {
            num = extCproductService.extCproducttotalAmount(andPidNumber);
        }
        return num;
    }

    @Override
    public List<ContractProductC> proAndExtFind(String id) {
        List<ContractProductC> contractProductCS = ContractProductCAndFind(id);
        for (ContractProductC c:
             contractProductCS) {
            List<ExtCproductC> extCproductCS = extCproductService.extCproductAndFind(c.getContratProductId());
            c.setExtCproductCList(extCproductCS);
        }
        return contractProductCS;
    }


}
