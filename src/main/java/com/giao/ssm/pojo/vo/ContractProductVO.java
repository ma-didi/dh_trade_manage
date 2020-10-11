package com.giao.ssm.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.ContractProductC;
import com.giao.ssm.pojo.ExtCproductC;
import com.giao.ssm.pojo.FactoryC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/10/10 - 14:42
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractProductVO extends ContractProductC{

    @TableField(exist = false)
    private List<ExtCproductVo> extCproductVoList;

    @TableField(exist = false)
    private FactoryC factoryC;

    @TableField(exist = false)
    private ContractC contractc;

}
