package com.giao.ssm.entity.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.ExportProductC;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author liuchang
 * @date 2020/10/11 - 16:02
 */
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("EXPORT_C")
public class ExportcVO implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId("EXPORT_ID")
    private String exportId;

    @TableField("INPUT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;

    @TableField("CONTRACT_IDS")
    private String contractIds;

    /**
     * 客户的合同号,可选择多个合同
     */
    @TableField("CUSTOMER_CONTRACT")
    private String customerContract;

    /**
     * L/C T/T
     */
    @TableField("LCNO")
    private String lcno;

    @TableField("CONSIGNEE")
    private String consignee;

    @TableField("MARKS")
    private String marks;

    @TableField("SHIPMENT_PORT")
    private String shipmentPort;

    @TableField("DESTINATION_PORT")
    private String destinationPort;

    /**
     * SEA/AIR
     */
    @TableField("TRANSPORT_MODE")
    private String transportMode;

    /**
     * FBO/CIF
     */
    @TableField("PRICE_CONDITION")
    private String priceCondition;

    @TableField("REMARK")
    private String remark;

    @TableField("BOX_NUM")
    private BigDecimal boxNum;

    @TableField("CNUMBER")
    private BigDecimal cnumber;

    /**
     * PCS/SETS
     */
    @TableField("PACKING_UNIT")
    private String packingUnit;

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

    @TableField("CSIZE")
    private BigDecimal csize;

    /**
     * 自动计算: 数量x单价
     */
    @TableField("AMOUNT")
    private BigDecimal amount;

    /**
     * 收购单价
     */
    @TableField("NO_TAX")
    private BigDecimal noTax;

    /**
     * 收购单价
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
     * 0草稿 1上报
     */
    @TableField("STATE")
    private BigDecimal state;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DEPT")
    private String createDept;

    @TableField("CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    @TableField(exist = false)
    private String epnum;

    @TableField(exist = false)
    private String extnum;


    @TableField(exist = false)
    private List<ExportProductC> exportProductCS;

    @TableField(exist = false)
    private String id;

}
