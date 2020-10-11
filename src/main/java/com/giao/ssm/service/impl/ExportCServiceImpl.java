package com.giao.ssm.service.impl;

import com.giao.ssm.entity.ExportC;
import com.giao.ssm.mapper.ContractProductVOMapperPO;
import com.giao.ssm.mapper.ExportCMapper;
import com.giao.ssm.pojo.ContractC;
import com.giao.ssm.pojo.vo.ContractCVO;
import com.giao.ssm.pojo.vo.ContractProductVO;
import com.giao.ssm.service.ContractCService;
import com.giao.ssm.service.IExportCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.giao.ssm.utill.UtilFuns;
import com.giao.ssm.utill.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
@Service
public class ExportCServiceImpl extends ServiceImpl<ExportCMapper, ExportC> implements IExportCService {

    //注入出口保运mapper
    @Autowired
    private ExportCMapper exportCMapper;

    //注入合同mapper
    @Autowired
    private ContractProductVOMapperPO contractProductVOMapperPO;

    //uuid公共工具类
    private UtilUUID uuid;

    @Override
    public int exportAndInsert(String[] contractids) {

        String contractNos = "";
        //循环遍历合同号
        for (int i = 0; i < contractids.length; i++) {
            //根据合同号查询出一个合同对象
            ContractCVO contractC = contractProductVOMapperPO.viewAndCon(contractids[i]);
            //以空格做分割符
            contractNos += contractC.getContractNo() + " ";

        }

        //工具类，删除最后一个字符
        contractNos = UtilFuns.delLastChar(contractNos);

        ExportC exportC = new ExportC();
        exportC.setExportId(uuid.uuid());

        //工具类，拼串
        exportC.setContractIds(UtilFuns.joinStr(contractids, ","));
        exportC.setCustomerContract(contractNos);
        //0草稿
        exportC.setState(new BigDecimal(0));

        //添加数据
        exportCMapper.insert(exportC);

        //处理货物信息
        for(int i=0;i<contractids.length;i++){
            ContractCVO contractCVO = contractProductVOMapperPO.viewAndCon(contractids[i]);
            for (ContractProductVO cp:
            contractCVO.getContractProductVOS()) {

            }
            List<ContractProductVO> contractProductVOS = contractCVO.getContractProductVOS();
        }


            return 0;
    }
}
