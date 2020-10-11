package com.giao.ssm.mapper;

import com.giao.ssm.pojo.vo.OutProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/10/9 - 11:28
 */
public interface OutProductMapper {

    List<OutProductVO>  excileAndProduct(@Param("inputDate") String inputDateTime);

}
