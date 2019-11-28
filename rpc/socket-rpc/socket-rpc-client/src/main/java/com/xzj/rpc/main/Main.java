package com.xzj.rpc.main;

import com.xzj.rpc.service.Calculator;
import com.xzj.rpc.service.HelloService;
import com.xzj.rpc.service.proxy.RpcClientUtil;

import java.net.InetSocketAddress;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
public class Main {
    public static void main(String[] args) {

        HelloService service = RpcClientUtil.getRemoteProxyObj(HelloService.class, new InetSocketAddress("127.0.0.1", 5555));
        System.out.println(service.sayHi("test"));
        Calculator service2 = RpcClientUtil.getRemoteProxyObj(Calculator.class, new InetSocketAddress("127.0.0.1", 5555));
        System.out.println(service2.add(2, 5));
    }

}
