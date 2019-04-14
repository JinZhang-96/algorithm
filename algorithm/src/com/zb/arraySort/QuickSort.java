package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: QuickSort
* @Description: TODO(快速排序)
* @author zb
* @date 2019年4月11日 下午4:32:42
*
 */
public class QuickSort {
	/**
	 * 快速排序思路：通过划分对乱序数组划分为以枢纽点povit为中间点，左边数组的值小于枢纽点， 右边的值大于枢纽点。
	 * 直到划分的数组长度为1， 则该数组就是有序的。
	 * 实现代码如下：
	 */
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100); // 获取一个大小为30，最大值为100的乱序数组
		
		System.out.println("排序前：" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = ShellSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("排序后：" + Provider.printArray(randomArray));
		System.out.println("共交换" + data[0] + "次， 共比较" + data[1] + "次。");
		System.out.println("共用时：" + Provider.getTime(startTime, endTime, ""));
		
	}

}
