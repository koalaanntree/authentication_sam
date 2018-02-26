package com.sam.service.impl;

import com.sam.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: huangxin
 * @Date: Created in 下午2:31 2018/2/26
 * @Description:
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello" + name;
    }
}
