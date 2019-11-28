package com.xzj.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
public interface Calculator extends Remote {
    int add(int a, int b) throws RemoteException;
}
