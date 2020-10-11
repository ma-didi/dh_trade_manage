package com.giao.ssm.entity.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.giao.ssm.entity.ExportC;
import lombok.*;


/**
 * @author liuchang
 * @date 2020/10/11 - 16:02
 */
public class ExportcVO extends ExportC{


    @TableField(exist = false)
    @Getter
    @Setter
    private String epnum;

    @TableField(exist = false)
    @Setter
    @Getter
    private String extnum;

}
