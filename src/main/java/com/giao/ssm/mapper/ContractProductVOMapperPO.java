package com.giao.ssm.mapper;

import com.giao.ssm.pojo.vo.ContractCVO;
import org.apache.ibatis.annotations.Param;


/**
 * 合同销售
 * @author liuchang
 * @date 2020/10/10 - 14:47
 */
public interface ContractProductVOMapperPO {

    ContractCVO viewAndCon(@Param("id") String id);

}
