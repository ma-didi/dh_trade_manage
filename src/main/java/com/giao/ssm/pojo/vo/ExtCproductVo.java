package com.giao.ssm.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.giao.ssm.pojo.ExtCproductC;
import com.giao.ssm.pojo.FactoryC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuchang
 * @date 2020/10/10 - 16:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExtCproductVo extends ExtCproductC {

    @TableField(exist = false)
    private FactoryC factoryC;

}
