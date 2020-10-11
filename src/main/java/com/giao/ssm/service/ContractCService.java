package com.giao.ssm.service;

import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.vo.ContractCVO;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/23 - 1:31
 */
public interface ContractCService {

    List<ContractC> contractAndFind();

    ContractC contractAndDFindCid(String id);

    int contractInserrt(ContractC contractc);

    int contractDelete(String[] id);

    int contractUpdate(ContractC contractc);

    int contractUpdateAmount(Double amount , String id);
}
