package com.xzj.rmi.main;

/**
 * Create by xuzhijun.online on 2019/5/18.
 */
//program for client application
import com.xzj.rmi.service.Calculator;
import com.xzj.rmi.service.Search;

import java.rmi.*;
public class Client
{
    public static void main(String args[])
    {
        String answer,value="Reflection in Java";
        try
        {
            // lookup method to find reference of remote object
            Search access = (Search)Naming.lookup("rmi://localhost:1900/geeksforgeeks");
            answer = access.query(value);
            System.out.println("Article on " + value + " " + answer+" at GeeksforGeeks");
            // lookup method to find reference of remote object
            Calculator calculator = (Calculator)Naming.lookup("rmi://localhost:1900/calculator");
            int result = calculator.add(6, 9);
            System.out.println("The sum = " + result);


        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
