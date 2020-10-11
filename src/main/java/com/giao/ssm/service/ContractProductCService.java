package com.giao.ssm.service;

import com.giao.ssm.pojo.ContractProductC;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/23 - 22:22
 */
public interface ContractProductCService {

    List<ContractProductC> ContractProductCAndFind(String id);

    int ContractProductCAndInsert(ContractProductC productC);

    int ContractProductCAnddelete(String[] id);

    int ContractProductCAndupdate(ContractProductC productC);

    ContractProductC ContractProductCAndFindAndPid(String id);

    String[] contractProductCAdnFindAndPidNumber(String[] id);

    Integer contractGetCount(String id);

    Integer extcproductGetCount(String id);

    Double contractGettotalAmount(String id);

    Double exttractGettotalAmout(String id);

    List<ContractProductC> proAndExtFind(String id);
}
