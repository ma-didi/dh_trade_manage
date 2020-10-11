package com.giao.ssm.service.impl;

import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.mapper.ExportCMapper;
import com.giao.ssm.service.IExportCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
@Service
public class ExportCServiceImpl extends ServiceImpl<ExportCMapper, ExportC> implements IExportCService {


    @Autowired
    private ExportCMapper exportCMapper;

    @Override
    public List<ExportcVO> findAndExport() {
        List<ExportcVO> andExport = exportCMapper.findAndExport(null);
        return andExport;
    }
}
