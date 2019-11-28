package com.xzj.rpc.main;

import com.xzj.rpc.service.Calculator;
import com.xzj.rpc.service.HelloService;
import com.xzj.rpc.service.impl.CalculatorImpl;
import com.xzj.rpc.service.impl.HelloServiceImpl;
import com.xzj.rpc.servicecenter.ServiceCenter;
import com.xzj.rpc.servicecenter.ServiceCenterImpl;

import java.io.IOException;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServiceCenter serviceServer = new ServiceCenterImpl(5555);
        serviceServer.register(HelloService.class, HelloServiceImpl.class);
        serviceServer.register(Calculator.class, CalculatorImpl.class);
        serviceServer.start();
    }
}
