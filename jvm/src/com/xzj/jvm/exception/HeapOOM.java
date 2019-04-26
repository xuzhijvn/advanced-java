package com.xzj.jvm.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK1.6/JDK1.8
 * 
 * Java堆内存溢出异常测试
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author xuzhijun.online  
 * @date 2019年4月22日
 */
public class HeapOOM {
	
	static class OOMObject{
		
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}

}
