package com.giao.ssm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("PACKING_LIST_C")
public class PackingListC implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PACKING_LIST_ID")
    private String packingListId;

    @TableField("EXPORT_ID")
    private String exportId;

    @TableField("SELLER")
    private String seller;

    @TableField("BUYER")
    private String buyer;

    /**
     * 选择
     */
    @TableField("INVOICE_NO")
    private String invoiceNo;

    @TableField("INVOICE_DATE")
    private LocalDateTime invoiceDate;

    @TableField("MARKS")
    private String marks;

    @TableField("DESCRIPTIONS")
    private String descriptions;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DEPT")
    private String createDept;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;


}
