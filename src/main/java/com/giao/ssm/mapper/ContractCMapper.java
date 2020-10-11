package com.giao.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.vo.ContractCVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/23 - 0:12
 */
@Repository
public interface ContractCMapper extends BaseMapper<ContractC> {


    List<ContractCVO> contractAndFind();

}
