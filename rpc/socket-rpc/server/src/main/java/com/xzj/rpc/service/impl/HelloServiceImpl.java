package com.xzj.rpc.service.impl;

import com.xzj.rpc.service.HelloService;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }

}
