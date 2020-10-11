package com.giao.ssm.entity.VO;

import com.alibaba.druid.support.monitor.annotation.MTable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.giao.ssm.entity.ExportC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liuchang
 * @date 2020/10/11 - 16:02
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportcVO extends ExportC implements Serializable {

    //序列化
    private static final long serialVersionUID = 1L;


    @TableField(exist = false)
    private String epnum;

    @TableField(exist = false)
    private String extnum;

}
