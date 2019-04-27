package com.xzj.jvm.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK1.6
 * 
 * 运行时常量池导致的内存溢出异常(JDK1.8之后去除了方法区, 常量池移入堆内存，因此本实验只能在JDK1.6上测试)
 * 
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author xuzhijun.online  
 * @date 2019年4月23日
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		//使用List保持着常量池的引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		//10M的PermSize在integer范围内足够产生OOM了
		int i = 0;
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
