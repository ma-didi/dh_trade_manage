package com.giao.ssm.service.impl;

import com.giao.ssm.entity.ExportC;
import com.giao.ssm.entity.ExportProductC;
import com.giao.ssm.entity.ExtEproductC;
import com.giao.ssm.mapper.ContractProductVOMapperPO;
import com.giao.ssm.mapper.ExportCMapper;
import com.giao.ssm.mapper.ExportProductCMapper;
import com.giao.ssm.mapper.ExtEproductCMapper;
import com.giao.ssm.pojo.vo.ContractCVO;
import com.giao.ssm.pojo.vo.ContractProductVO;
import com.giao.ssm.pojo.vo.ExtCproductVo;
import com.giao.ssm.service.IExtEproductCService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.giao.ssm.utill.UtilFuns;
import com.giao.ssm.utill.UtilUUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuchang
 * @since 2020-10-11
 */
@Service
public class ExtEproductCServiceImpl extends ServiceImpl<ExtEproductCMapper, ExtEproductC> implements IExtEproductCService {

    //注入出口保运mapper
    @Autowired
    private ExportCMapper exportCMapper;

    //注入出口商品包运
    @Autowired
    private ExportProductCMapper productCMapper;

    //注入出口包运附件信息
    @Autowired
    private ExtEproductCMapper extEproductCMapper;

    //注入合同mapper
    @Autowired
    private ContractProductVOMapperPO contractProductVOMapperPO;

    //uuid公共工具类
    @Autowired
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
        for (int i = 0; i < contractids.length; i++) {
            ContractCVO contractCVO = contractProductVOMapperPO.viewAndCon(contractids[i]);
            for (ContractProductVO cp :
                    contractCVO.getContractProductVOS()) {
                ExportProductC eq = new ExportProductC();
                eq.setExportProductId(uuid.uuid());
                eq.setExportId(exportC.getExportId());                    //绑定外键

                //数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
                eq.setFactoryId(cp.getFactoryC().getFactoryId());
                eq.setProductName(cp.getFactoryC().getFactoryName());
                eq.setProductNo(cp.getProductNo());
                eq.setPackingUnit(cp.getPackingUnit());
                eq.setCnumber(new BigDecimal(cp.getCnumber()));
                eq.setBoxNum(new BigDecimal(cp.getBoxNum()));
                eq.setPrice(new BigDecimal(cp.getPrice()));

                productCMapper.insert(eq);
                List<ExtCproductVo> extCproducts = cp.getExtCproductVoList();
                //处理附件信息
                for (ExtCproductVo extcp : extCproducts) {
                    ExtEproductC extep = new ExtEproductC();

                    //copyProperties spring
                    BeanUtils.copyProperties(extcp, extep);        //spring工具类，数据的拷贝

                    extcp.setExtCproductId(uuid.uuid());
                    extep.setExportProductId(eq.getExportProductId());        //绑定外键

                    extep.setFactoryId(extcp.getFactoryC().getFactoryId());
                    extep.setProductName(extcp.getFactoryC().getFactoryName());

                    extEproductCMapper.insert(extep);
                }
            }
        }
        return 0;
    }
}
