package com.giao.ssm.entity.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.ExportProductC;
import lombok.*;

import java.util.List;


/**
 * @author liuchang
 * @date 2020/10/11 - 16:02
 */
@TableName("EXPORT_C")
@EqualsAndHashCode(callSuper = false)
public class ExportcVO extends ExportC{


    @TableField(exist = false)
    @Getter
    @Setter
    private String epnum;

    @TableField(exist = false)
    @Setter
    @Getter
    private String extnum;


    @TableField(exist = false)
    @Setter
    @Getter
    private List<ExportProductC> exportProductCS;



}
