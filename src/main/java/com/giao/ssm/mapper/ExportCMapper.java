package com.giao.ssm.mapper;

import com.giao.ssm.entity.ExportC;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.giao.ssm.entity.VO.ExportcVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
public interface ExportCMapper extends BaseMapper<ExportC> {

    List<ExportcVO> findAndExport(Map map);
}
