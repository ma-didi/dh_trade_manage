package com.giao.ssm.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.giao.ssm.pojo.ContractC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/22 - 23:01
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContractCVO extends ContractC {


    //货物的集合
    @TableField(exist = false)
    private List<ContractProductVO> contractProductVOS;

}
