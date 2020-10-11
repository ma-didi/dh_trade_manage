package com.giao.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("CONTRACT_C")
public class ContractC {

    @TableId(value = "CONTRACT_ID" , type = IdType.INPUT)
    private String contractId;

    @TableField("OFFEROR")
    private String offeror;


    @TableField("CONTRACT_NO")
    private String contractNo;

    @TableField("SIGNING_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signingDate;

    @TableField("INPUT_BY")
    private String inputBy;

    @TableField("CHECK_BY")
    private String checkBy;

    @TableField("INSPECTOR")
    private String inspector;

    //总价格
    @TableField("TOTAL_AMOUNT")
    private Double totalAmount;

    @TableField("REQUEST")
    private String request;

    @TableField("CUSTOM_NAME")
    private String customName;

    @TableField("SHIP_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shipTime;

    @TableField("IMPORT_NUM")
    private Integer importNum;

    @TableField("DELIVERY_PERIOD")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;

    @TableField("REMARK")
    private String remark;

    @TableField("PRINT_STYLE")
    private Integer printStyle;

    @TableField("OLD_STATE")
    private Integer oldState;

    @TableField("STATE")
    private Integer cstate;

    @TableField("OUT_STATE")
    private Integer outState;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DEPT")
    private String createDept;

    @TableField("CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    //货物数
    @TableField(exist = false)
    private Integer contractProductCount;

    //附件数
    @TableField(exist = false)
    private Integer extCproductCount;

    //货物
    @TableField(exist = false)
    private List<ContractProductC> contractProductList;


}