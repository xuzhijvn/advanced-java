package com.xzj.jvm.exception;

/**
 * JDK1.8/JDK1.6(window操作系统假死，未能观测到异常)
 * 
 * 创建线程导致内存溢出异常
 * 
 * VM Args: -Xss2M
 * 
 * @author xuzhijun.online  
 * @date 2019年4月23日
 */
public class JavaVMStackOOM {
	
	private void dontStop() {
		while(true) {
		}
	}

	public void stackLeakByThread() {
		while(true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
