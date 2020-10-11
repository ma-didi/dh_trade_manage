package com.giao.ssm.utill;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author liuchang
 * @date 2020/9/23 - 14:05
 * uuid工具类
 */
@Component
public class UtilUUID {

    public String uuid(){
        String s = UUID.randomUUID().toString();
        s=s.replace("-","");
        return s;
    }

}
