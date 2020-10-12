package com.giao.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.ExportProductC;
import com.giao.ssm.entity.VO.ExportcVO;
import com.giao.ssm.mapper.ExportCMapper;
import com.giao.ssm.mapper.ExportProductCMapper;
import com.giao.ssm.service.IExportCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ExportCServiceImpl extends ServiceImpl<ExportCMapper, ExportcVO> implements IExportCService {


    @Autowired
    private ExportCMapper exportCMapper;

    @Autowired
    private ExportProductCMapper exportProductCMapper;

    @Override
    public List<ExportcVO> findAndExport() {
        List<ExportcVO> andExport = exportCMapper.findAndExport(null);
        return andExport;
    }

    @Override
    public ExportcVO findAndExportId(String id) {
        QueryWrapper<ExportProductC> query = Wrappers.query();
        query.in("EXPORT_ID",id);
        List<ExportProductC> exportProductCS = exportProductCMapper.selectList(query);
        ExportcVO exportcVO = exportCMapper.selectById(id);
        exportcVO.setExportProductCS(exportProductCS);
        return exportcVO;
    }



}
