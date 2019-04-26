package com.xzj.jvm.gc;

/**
 *
 * @author xuzhijun.online
 * @author 2019年4月24日
 *
 */

public class Gc {
	
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		testHandlePromotion();
	}
	
	/**
	 * 
	 *   新生代 Minor GC
	 * 
	 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 (-XX:+UseParNewGC)
	 * 
	 * JDK1.8: PSYoungGen + ParOldGen 大对象直接分配到年老代
	 * 
	 * JDK1.6: PSYoungGen + PSOldGen 大对象直接分配到年老代
	 * 
	 * JDK1.6 ParNew + Serial Old 大对象分配在eden区域
	 * 
	 */
	@SuppressWarnings("unused")
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];
	}
	
	/**
	 *    大对象直接进入老年代
	 * 
	 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
	 * -XX:PretenureSizeThreshold=3145728 
	 * -XX:+UseParNewGC
	 * 
	 * JDK1.8: pass
	 */
	@SuppressWarnings("unused")
	public static void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];//直接分配在老年代中
	}
	
	/**
	 *  长期存活的对象进入老年代
	 *  
	 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
	 * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 * -XX:+UseSerialGC
	 * 
	 * JDK1.6(Pass)
	 * JDK1.8("MaxTenuringThreshold=15" Failed)
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		//什么时候进入老年代取决于XX:MaxTenuringThreshold设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}
	
	/**
	 *   动态对象年龄判断
	 * 
	 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
	 * -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
	 * -XX:+UseSerialGC
	 * 
	 */
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		//allocation1 + allocation2大于survivor空间一半
		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}
	/**
	 * 
	 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 
	 * -XX:-HandlePromotionFailure
	 * -XX:+UseSerialGC
	 * 
	 */
	@SuppressWarnings("unused")
	public static void testHandlePromotion() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[3 * _1MB];
		allocation1 = null;
		allocation4 = new byte[2 * _1MB];
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * _1MB];
	}

}
