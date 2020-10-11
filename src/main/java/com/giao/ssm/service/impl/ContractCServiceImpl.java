package com.giao.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.giao.ssm.mapper.ContractCMapper;
import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.vo.ContractCVO;
import com.giao.ssm.service.ContractCService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuchang
 * @date 2020/9/23 - 1:32
 */
@Service
public class ContractCServiceImpl implements ContractCService {

    @Autowired
    private ContractCMapper contractCMapper;

    @Override
    public List<ContractC> contractAndFind() {
        return contractCMapper.selectList(null);
    }

    @Override
    public ContractC contractAndDFindCid(String id) {
        return contractCMapper.selectById(id);
    }

    @Override
    public int contractInserrt(ContractC contractC) {
        return contractCMapper.insert(contractC);
    }

    @Override
    public int contractDelete(String[] id) {
        QueryWrapper<ContractC> query = Wrappers.query();
        query.in("CONTRACT_ID",id);
//        contractCMapper.deleteBatchIds(Arrays.stream(id).collect(Collectors.toList()));
        contractCMapper.delete(query);
        return 0;
    }

    @Override
    public int contractUpdate(ContractC contractC) {
        return contractCMapper.updateById(contractC);
    }

    @Override
    public int contractUpdateAmount(Double amount, String id) {
        LambdaUpdateWrapper<ContractC> lambda = new UpdateWrapper().lambda();
        lambda.eq(ContractC::getContractId,id).set(ContractC::getTotalAmount,amount);
        contractCMapper.update(null,lambda);
        return 0;
    }
}
