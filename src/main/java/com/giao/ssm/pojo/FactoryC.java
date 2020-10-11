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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("FACTORY_C")
public class FactoryC {

    @TableId(value = "FACTORY_ID" , type = IdType.INPUT)
    private String factoryId;

    @TableField(value = "FULL_NAME")
    private String fullName;

    @TableField(value = "FACTORY_NAME")
    private String factoryName;

    @TableField(value = "CONTACTOR")
    private String contactor;

    @TableField(value = "PHONE")
    private String phone;

    @TableField(value = "MOBILE")
    private String mobile;

    @TableField(value = "FAX")
    private String fax;

    @TableField(value = "CNOTE")
    private String cnote;

    @TableField(value = "CTYPE")
    private Integer ctype;

    @TableField(value = "STATE")
    private String state;

    @TableField(value = "INSPECTOR")
    private String inspector;

    @TableField(value = "ORDER_NO")
    private Integer orderNo;

    @TableField(value = "CREATE_BY")
    private String createBy;

    @TableField(value = "CREATE_DEPT")
    private String createDept;

    @TableField(value = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
