package com.xzj.rmi.service.impl;

import com.xzj.rmi.service.Calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    public CalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
