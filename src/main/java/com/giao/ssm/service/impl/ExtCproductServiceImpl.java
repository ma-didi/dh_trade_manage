package com.giao.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.giao.ssm.mapper.ExtCproductCMapper;
import com.giao.ssm.pojo.ExtCproductC;
import com.giao.ssm.service.ExtCproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/24 - 21:12
 */
@Service
public class ExtCproductServiceImpl extends ServiceImpl<ExtCproductCMapper,ExtCproductC> implements ExtCproductService {

    @Autowired
    private ExtCproductCMapper extCproductCMapper;


    @Override
    public List<ExtCproductC> extCproductAndFind(String id) {
        QueryWrapper<ExtCproductC> query = Wrappers.query();
        query.eq("CONTRACT_PRODUCT_ID", id);
        List<ExtCproductC> extCproductCS = extCproductCMapper.selectList(query);
        return extCproductCS;
    }

    @Override
    public ExtCproductC extCproductAndFindAndFid(String id) {
        return extCproductCMapper.selectById(id);
    }

    @Override
    public String[] extCproductAndFindAndIdNumber(String[] id) {
        QueryWrapper<ExtCproductC> query = Wrappers.query();
        query.in("CONTRACT_PRODUCT_ID", id).select(ExtCproductC.class, info -> info.getColumn().equals("EXT_CPRODUCT_ID"));
        List<ExtCproductC> num = extCproductCMapper.selectList(query);
        String[] num01 = new String[num.size()];
        int i = 0;
        for (ExtCproductC e :
                num) {
            num01[i] = e.getExtCproductId();
            i++;
        }
        return num01;
    }

    @Override
    public int extCproductAndInsert(ExtCproductC extCproductC) {
        return extCproductCMapper.insert(extCproductC);
    }

    @Override
    public int extCproductAndDelete(String[] id) {
        QueryWrapper<ExtCproductC> query = Wrappers.query();
        query.in("EXT_CPRODUCT_ID",id);
        return extCproductCMapper.delete(query);
    }

    @Override
    public int extCproductAndUpdate(ExtCproductC extCproductC) {
        return extCproductCMapper.updateById(extCproductC);
    }

    @Override
    public Integer extCproductGetCount(String[] id) {
        QueryWrapper<ExtCproductC> query = Wrappers.query();
        query.in("CONTRACT_PRODUCT_ID",id);
        Integer num = extCproductCMapper.selectCount(query);
        return num;
    }

    @Override
    public Double extCproducttotalAmount(String[] id) {
        QueryWrapper<ExtCproductC> query = Wrappers.query();
        query.in("CONTRACT_PRODUCT_ID",id).select( ExtCproductC.class ,info -> info.getColumn().equals("AMOUNT"));
        List<ExtCproductC> extCproductCS = extCproductCMapper.selectList(query);
        Double num=0D;
        for (ExtCproductC c:
             extCproductCS) {
            num+=c.getAmount();
        }
        num = Math.round(num * 1000) * 0.001d;
        return num;
    }


}
