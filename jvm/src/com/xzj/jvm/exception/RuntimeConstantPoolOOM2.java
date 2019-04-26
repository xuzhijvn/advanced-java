package com.xzj.jvm.exception;

/**
 * 
 * JDK1.8(true,false)/JDK1.6(false,false)
 * 
 * JDK1.8移除方法区，常量池加入到堆内存，所以new对象的地址和intern()返回的常量池中的地址是相同的(详情见《JVM虚拟机P57》)
 *
 * String.intern()返回引用测试
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */

public class RuntimeConstantPoolOOM2 {

	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}

}
