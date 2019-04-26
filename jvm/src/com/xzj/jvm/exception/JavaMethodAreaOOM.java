package com.xzj.jvm.exception;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * JDK1.6
 * 
 * 借助CGLib使方法区出现内存溢出异常 
 * 
 *
 * VM  Args: -XX:PermSize=10M -XX:MaxPermSize=10M (JDK1.8之后去除了方法区, 类数据放入MetaSpace直接内存区域，该参数无效)
 *
 * @author xuzhijun.online
 * @author 2019年4月23日
 *
 */

public class JavaMethodAreaOOM {
	
	static class OOMObject {
		
	}

	public static void main(String[] args) {
		while(true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}

}
