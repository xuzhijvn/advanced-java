package com.xzj.encode;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
	String path = "D:\\WorkSpace\\go-land\\primary-go\\protobuf\\encode\\dataitem.pbuf";
	try {
	    DataMsg.DataItem deserial =
		DataMsg.DataItem.newBuilder().mergeFrom(new FileInputStream(path)).build();

	    System.out.println(deserial.getOddA()); // 64-bit odd
	    System.out.println(deserial.getLong()); // 32-character string
	}
	catch(Exception e) { System.err.println(e); }
    }
}
