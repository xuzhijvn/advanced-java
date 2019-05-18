package com.xzj.rmi.service;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
// Creating a Search interface

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Search extends Remote
{
    // Declaring the method prototype
    public String query(String search) throws RemoteException;
}