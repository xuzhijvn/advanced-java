package com.xzj.rmi.main;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
//program for server application
import com.xzj.rmi.service.Calculator;
import com.xzj.rmi.service.Search;
import com.xzj.rmi.service.impl.CalculatorImpl;
import com.xzj.rmi.service.impl.SearchQuery;

import java.rmi.*;
import java.rmi.registry.*;
public class Server
{
    public static void main(String args[])
    {
        try
        {
            // Create an object of the interface
            // implementation class
            Search obj = new SearchQuery();
            Calculator calculator = new CalculatorImpl();

            // rmiregistry within the server JVM with
            // port number 1900
            LocateRegistry.createRegistry(1900);

            // Binds the remote object by the name
            // geeksforgeeks
            Naming.rebind("rmi://localhost:1900/geeksforgeeks",obj);
            // calculator
            Naming.rebind("rmi://localhost:1900/calculator",calculator);
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
