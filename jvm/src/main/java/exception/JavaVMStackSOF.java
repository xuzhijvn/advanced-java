package com.xzj.jvm.exception;

/**
 * JDK1.8/JDK1.6
 * 
 * 虚拟机机栈和本地方法栈OOM测试(减小栈内存，模拟StackOverflowError)
 * 
 * VM Args: -Xss128k
 * 
 * @author xuzhijun.online  
 * @date 2019年4月23日
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: "+oom.stackLength);
			throw e;
		}
	}

}
