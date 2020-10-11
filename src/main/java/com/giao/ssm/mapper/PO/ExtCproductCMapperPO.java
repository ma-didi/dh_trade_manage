package com.giao.ssm.mapper.PO;

import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @author liuchang
 * @date 2020/9/27 - 23:22
 */
public class ExtCproductCMapperPO {

    public String exttotalAmount(List<String> ids){
        System.out.println("11");
        ids.forEach(System.out::println);
        SQL sql = new SQL();
        sql.SELECT("SUM(AMOUNT)");
        sql.FROM("EXT_CPRODUCT_C");
        System.out.println(sql.toString());
//        if(id!=null && id.length>0){
//            sql.WHERE("CONTRACT_PRODUCT_ID");
//            for (int i=0;i<id.length;i++){
//                sql.WHERE(id[i]);
//                if (i<i-1){
//                    sql.WHERE(",");
//                }
//            }
//            sql.WHERE(")");
//        }
//        System.out.println(sql.toString());
        return sql.toString();
    }


}
