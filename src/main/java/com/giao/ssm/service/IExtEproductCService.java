package com.giao.ssm.service;

import com.giao.ssm.entity.ExtEproductC;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
public interface IExtEproductCService extends IService<ExtEproductC> {

    int exportAndInsert(String[] contractids);


}
