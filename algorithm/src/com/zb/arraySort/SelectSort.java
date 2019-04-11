package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: SelectSort
* @Description: TODO(选择排序)
* @author zb
* @date 2019年4月11日 下午4:31:42
*
 */
public class SelectSort {
	
	/**
	 * 选择排序思路：在乱序数组的始点开始与它下一个元素的值比较，直到末点结束。可以记录大数或小数的在数组中的位置， 直到结束后，记录的
	 * 元素就是最大或最小的元素，然后把它与未排序的数组的始点进行交换。代码实现： 
	 */
	
	public static int[] sort(int[] randomArray) {
		int[] data = {0,0};
		 
		 for(int i  = 0; i< randomArray.length - 1; i++) {
			 int min = i; // 记录最小元素的位置， 初始为未排序数组的始点
			 for(int j = i + 1; j < randomArray.length; j++ ) {
				 data[1] += 1;
				 // 如果当前元素大于标记的最小元素的值，则改变最小元素的索引为该元素的索引
				 if(randomArray[min] > randomArray[j]) {
					 min = j;
				 }
			 }
			 // 如果未排序数组的始点就是最小值就没必要交换了
			 if(min == i) {
				 continue;
			 }			 
			 randomArray[i] = randomArray[i] ^ randomArray[min];
			 randomArray[min] = randomArray[i] ^ randomArray[min];
			 randomArray[i] = randomArray[i] ^ randomArray[min];
			 data[0] += 1;
			 
		 }
		 return data;
	}
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10, 100);  // 获取一个大小为30， 最大值为100的乱序数组
		System.out.println("排序前："+ Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = SelectSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("排序后："+ Provider.printArray(randomArray));
		System.out.println("共交换" + data[0]+"次， 共排序"+data[1]+"次。" );
		System.out.println("共用时："+Provider.getTime(startTime, endTime, ""));
	}

}
