package com.giao.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.giao.ssm.pojo.ExtCproductC;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/24 - 21:06
 */
public interface ExtCproductService extends IService<ExtCproductC> {

    List<ExtCproductC> extCproductAndFind(String id);

    ExtCproductC extCproductAndFindAndFid(String id);

    String[] extCproductAndFindAndIdNumber(String[] id);

    int extCproductAndInsert(ExtCproductC extCproductC);

    int extCproductAndDelete(String[] id);

    int extCproductAndUpdate(ExtCproductC extCproductC);

    Integer extCproductGetCount(String[] id);

    Double extCproducttotalAmount(String[] id);

}
