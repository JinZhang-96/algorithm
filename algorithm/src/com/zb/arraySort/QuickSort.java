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
	 * 快速排序思路：通过划分 对乱序数组划分为以枢纽点povit为中间点，左边数组的值小于枢纽点， 右边的值大于枢纽点的数组。
	 * 直到划分的数组长度为1， 则该数组默认就是有序的， 停止数组的划分。
	 * 实现代码如下：
	 */
	
	
	private static int[] randomArray;
	
	private static int[] data = {0,0};
	
	
	public  static void sort(int left, int right) {		
		// 当数组的元素只有一个时，排序完成
		if(left >= right){
			return ;
		}		
		// 划分完后 postition位置的元素已经是有序数组中的元素了
		int position = partition(left, right);
		
		QuickSort.sort(left, position -1);
		QuickSort.sort(position + 1, right);
		
	}
	
	/**
	 * 
	* @Title: partition
	* @Description: TODO(划分函数， 把一个乱序数组分割未以povit枢纽点为中间点， 其左边小于povit， 右边大于povit。也就是说povit所在的位置时归序数组中它所在的位置)
	* @param @param left
	* @param @param right
	* @param @return    设定文件
	* @return int    返回类型
	* @author zb 
	* @throws
	 */
	public static int partition(int left, int right) {
		// 默认取数组的第一个数为枢纽点
		int  povit = randomArray[left];	
		int start = left; // 记录枢纽点元素的位置
		// 当left未和right相遇时，就继续下一轮交换
		while(true) {
			// 默认在数组的右侧先开始查找
			while(randomArray[right] > povit){ // 查找数组中比povit小的数组元素
				data[1] += 1;
				right--; 
			}
			while(++left < right && randomArray[left] < povit) {
				data[1] += 1;
			};// 查找数组中比povit大的数组元素
			
			// 交换数组元素				
			if(left < right) {
				int temp = randomArray[left];
				randomArray[left] = randomArray[right];
				randomArray[right] = temp;
				data[0] += 1;
			}else{
				break;
			}
			
		}	
		randomArray[start] = randomArray[right];
		randomArray[right] = povit;
		data[0] += 1;
		return right;
	}
	
	
	public static void main(String[] args) {
		
		randomArray = Provider.getArray(10000, 100); // 获取一个大小为30，最大值为100的乱序数组
		
		System.out.println("排序前：" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		
		
		QuickSort.sort(0, randomArray.length-1);
		
		
		long endTime = System.nanoTime();
		System.out.println("排序后：" + Provider.printArray(randomArray));
		System.out.println("共交换" + data[0] + "次， 共比较" + data[1] + "次。");
		System.out.println("共用时：" + Provider.getTime(startTime, endTime, ""));
		
	}

}
