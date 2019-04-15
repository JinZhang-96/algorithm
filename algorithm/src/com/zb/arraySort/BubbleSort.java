package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: BubbleSort
* @Description: TODO(冒泡排序算法)
* @author zb
* @date 2019年4月11日 下午4:30:00
*
 */
public class BubbleSort {
	
	/**
	 * 冒泡排序思路：一个乱序数组，通过数组的一个元素和它的下一个元素比较，
	 * 如果它的下一个元素没有它的值大，就交换它俩的值，否则不交换。
	 * 这样从数组的起点开始交换到数组末尾，就可以保证最后的元素就是这些元素中最大的一个。
	 * 因为最开始的要交换的元素值是较小的，到最后要交换的值越来越大直到最大，看起来就想水中浮出的气泡，
	 * 所以称为冒泡排序。 
	 * 其为最低级的排序算法， 比较时间复杂度为n*n, 交换时间复杂度为n*n, 效率最差， 不建议使用。
	 * 
	 * 代码实现如下：
	 */
	
	
	 public static int[] sort(int[] randomArray) {
		 int[] data = {0,0};
		 
		 for(int i  = 0; i< randomArray.length - 1; i++) {
			 
			 for(int j = 0; j < randomArray.length - (1 + i); j++ ) {
				 data[1] +=1;
				 // 如果前面的元素大于后面的元素，则交换
				 if(randomArray[j] > randomArray[j+1]) {
					randomArray[j] = randomArray[j+1] ^ randomArray[j];
					randomArray[j+1] = randomArray[j] ^ randomArray[j+1];
					randomArray[j] = randomArray[j] ^ randomArray[j+1];
					data[0] += 1;
				 }
			 }
			 
		 }
		 return data;
	 }
	 
	 
	 public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100);  // 获取一个大小为30， 最大值为100的乱序数组
		System.out.println("排序前："+ Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = BubbleSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("排序后："+ Provider.printArray(randomArray));
		System.out.println("共交换" + data[0]+"次， 共比较"+data[1]+"次。" );
		System.out.println("共用时："+Provider.getTime(startTime, endTime, ""));
		
	}

}
