package com.xzj.rpc.servicecenter;

import java.io.IOException;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
public interface ServiceCenter {
    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
