package com.giao.ssm.service.impl;

import com.giao.ssm.entity.ExportProductC;
import com.giao.ssm.mapper.ExportProductCMapper;
import com.giao.ssm.service.IExportProductCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
@Service
public class ExportProductCServiceImpl extends ServiceImpl<ExportProductCMapper, ExportProductC> implements IExportProductCService {

    @Autowired
    private ExportProductCMapper exportProductCMapper;


}
