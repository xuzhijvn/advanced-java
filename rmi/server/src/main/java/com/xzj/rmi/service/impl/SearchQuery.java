package com.xzj.rmi.service.impl;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
// Java program to implement the Search interface
import com.xzj.rmi.service.Search;

import java.rmi.*;
import java.rmi.server.*;
public class SearchQuery extends UnicastRemoteObject implements Search {
    // Default constructor to throw RemoteException
    // from its parent constructor
    public SearchQuery() throws RemoteException
    {
        super();
    }

    // Implementation of the query interface
    public String query(String search)
            throws RemoteException
    {
        String result;
        if (search.equals("Reflection in Java")) {
            result = "Found";
        } else {
            result = "Not Found";
        }

        return result;
    }
}
