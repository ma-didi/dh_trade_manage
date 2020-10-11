package com.giao.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuchang
 * @date 2020/9/24 - 20:34
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("EXT_CPRODUCT_C")
public class ExtCproductC {

    @TableId(value = "EXT_CPRODUCT_ID",type = IdType.INPUT)
    private String  extCproductId;

    @TableField(value = "FACTORY_ID")
    private String factoryId;

    @TableField(value = "CONTRACT_PRODUCT_ID")
    private String contractProductId;

    @TableField(value = "CTYPE")
    private Double ctype;

    @TableField(value = "PRODUCT_NAME")
    private String productName;

    @TableField(value = "PRODUCT_NO")
    private String productNo;

    @TableField(value = "PRODUCT_IMAGE")
    private String productImage;

    @TableField(value = "PRODUCT_DESC")
    private String productDesc;

    @TableField(value = "LOADING_RATE")
    private String loadingRate;

    @TableField(value = "PACKING_UNIT")
    private String packingUnit;

    @TableField(value = "CNUMBER")
    private Double cnumber;

    @TableField(value = "OUT_NUMBER")
    private Double outNumber;

    @TableField(value = "FINISHED")
    private Double finished;

    @TableField(value = "GROSS_WEIGHT")
    private Double gressWeigh;

    @TableField(value = "NET_WEIGHT")
    private Double netWeight;

    @TableField(value = "SIZE_LENGHT")
    private Double sizeLenght;

    @TableField(value = "SIZE_WIDTH")
    private Double sizeWidth;

    @TableField(value = "SIZE_HEIGHT")
    private Double sizeHeight;

    @TableField(value = "PRODUCT_REQUEST")
    private String productRequst;

    @TableField(value = "FACTORY")
    private String factory;

    @TableField(value = "PRICE")
    private Double price;

    @TableField(value = "AMOUNT")
    private Double amount;

    @TableField(value = "CUNIT")
    private String cunit;

    @TableField(value = "BOX_NUM")
    private Double boxNum;

    @TableField(value = "EX_PRICE")
    private Double exPrice;

    @TableField(value = "EX_UNIT")
    private String exUnit;

    @TableField(value = "NO_TAX")
    private Double noTax;

    @TableField(value = "TAX")
    private Double tax;

    @TableField(value = "COST_PRICE")
    private Double costPricce;

    @TableField(value = "COST_TAX")
    private Double costTax;

    @TableField(value = "ACCESSORIES")
    private Double accessories;

    @TableField(value = "ORDER_NO")
    private Double orderNo;
}
