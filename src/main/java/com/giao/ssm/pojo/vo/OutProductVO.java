package com.giao.ssm.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author liuchang
 * @date 2020/10/9 - 11:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutProductVO {

    @TableField(value = "PRODUCT_NO")
    private String productNo;

    @TableField(value = "CNUMBER")
    private Double cnumber;

    @TableField(value = "PACKING_UNIT")
    private String packingUnit;

    @TableField(value = "FACTORY_ID")
    private String factoryId;

    private String deliveryPeriod;

    private String customName;

    private String contractNo;

    private String shipTime;

}
