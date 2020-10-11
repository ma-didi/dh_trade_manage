package com.giao.ssm.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("EXPORT_PRODUCT_C")
public class ExportProductC implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("EXPORT_PRODUCT_ID")
    private String exportProductId;

    /**
     * 标识从哪个合同货物而来
     */
    @TableField("CONTRACT_PRODUCT_ID")
    private String contractProductId;

    @TableField("CONTRACT_ID")
    private String contractId;

    @TableField("CONTRACT_NO")
    private String contractNo;

    @TableField("PRODUCT_NAME")
    private String productName;

    @TableField("PRODUCT_NO")
    private String productNo;

    @TableField("PRODUCT_IMAGE")
    private String productImage;

    @TableField("PRODUCT_DESC")
    private String productDesc;

    /**
     * x/y
     */
    @TableField("LOADING_RATE")
    private String loadingRate;

    /**
     * PCS/SETS
     */
    @TableField("PACKING_UNIT")
    private String packingUnit;

    @TableField("CNUMBER")
    private BigDecimal cnumber;

    @TableField("OUT_NUMBER")
    private BigDecimal outNumber;

    /**
     * 0是1否
     */
    @TableField("FINISHED")
    private BigDecimal finished;

    @TableField("GROSS_WEIGHT")
    private BigDecimal grossWeight;

    @TableField("NET_WEIGHT")
    private BigDecimal netWeight;

    @TableField("SIZE_LENGHT")
    private BigDecimal sizeLenght;

    @TableField("SIZE_WIDTH")
    private BigDecimal sizeWidth;

    @TableField("SIZE_HEIGHT")
    private BigDecimal sizeHeight;

    @TableField("PRODUCT_REQUEST")
    private String productRequest;

    @TableField("FACTORY")
    private String factory;

    @TableField("PRICE")
    private BigDecimal price;

    /**
     * 自动计算: 数量x单价
     */
    @TableField("AMOUNT")
    private BigDecimal amount;

    @TableField("CUNIT")
    private String cunit;

    @TableField("BOX_NUM")
    private BigDecimal boxNum;

    /**
     * sales confirmation 中的价格（手填）
     */
    @TableField("EX_PRICE")
    private BigDecimal exPrice;

    /**
     * $/￥
     */
    @TableField("EX_UNIT")
    private String exUnit;

    /**
     * 空着,EXCEL手工填
     */
    @TableField("NO_TAX")
    private BigDecimal noTax;

    /**
     * 收购单价=合同单价
     */
    @TableField("TAX")
    private BigDecimal tax;

    /**
     * 自动计算=数量x含税/1.17标准值
     */
    @TableField("COST_PRICE")
    private BigDecimal costPrice;

    /**
     * 自动计算=数量x含税-收购成本金额
     */
    @TableField("COST_TAX")
    private BigDecimal costTax;

    /**
     * 0是1否
     */
    @TableField("ACCESSORIES")
    private BigDecimal accessories;

    @TableField("ORDER_NO")
    private BigDecimal orderNo;


}
