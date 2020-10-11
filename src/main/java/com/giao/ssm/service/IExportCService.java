package com.giao.ssm.service;

import com.giao.ssm.entity.ExportC;
import com.baomidou.mybatisplus.extension.service.IService;
import com.giao.ssm.entity.VO.ExportcVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
public interface IExportCService extends IService<ExportC> {

    List<ExportcVO> findAndExport();

}
