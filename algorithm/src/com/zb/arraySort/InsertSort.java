package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
 * @ClassName: InsertSort
 * @Description: TODO(插入排序)
 * @author zb
 * @date 2019年4月11日 下午4:32:03
 *
 */
public class InsertSort {

	/**
	 * 插入排序思路：一个乱序数组， 我们使数组是部分有序的， 在排序的开始， 我们认为数组的第一个元素就是那个部分有序的数组。然后选择有序
	 * 数组最后元素的下一个元素，在有序数组中查找这个元素应该插入的位置。直到有序数组的长度等于整个数组的长度位置。
	 * 比较复杂度 n*n, 交换复杂度 n*n;比较次数和交换次数相等。虽然时间复杂度和冒泡排序一样，但是一般它比冒泡和选择排序更快一些
	 * 
	 * 
	 * 实现代码如下：
	 */

	// 未使用2分查找的数组
	public static int[] sort(int[] randomArray) {
		int[] data = { 0, 0 };
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // 要插入有序数组的值
			int end = i; // 记录要存放元素的位置
			 //找到适当的插入位置， 如果要插入的值小于当前的值， 就把当前值向后移动一个位置
			while(end > 0 && randomArray[end-1] > value) {
				data[0] +=1;
				data[1] +=1;
				randomArray[end] = randomArray[end - 1];
				end --;
			}
			data[0] +=1;
			randomArray[end] = value;
		}

		return data;
	}

	// 使用2分查找
	/**
	public static int[] sort1(int[] randomArray) {
		int[] data = { 0, 0 };
		// 由数组的第2个元素到最后一个元素插入到有序数组中
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // 要插入有序数组的值
			int end = i; // 记录要存放元素的位置
			int start = 0; // 有序数组的起点
			int after = i - 1; //有序数组的末点 
			 //找到适当的插入位置
			while(after > start){
				int mid = (after+start)/2;
				if(randomArray[mid] > value){
					after = mid -1;
				}else if(randomArray[mid] < value){
					start = mid+1;
				}else {
					// 找到元素要插入的位置退出
					after = mid;
					break;
				}				
			}
			if(after < 0)
				after = 0;
			if(randomArray[after] <= value) {
				while(end > after) {
					randomArray[end] = randomArray[end - 1];
					end --;
				}	
				randomArray[after] = value;
			}else {
				if(after != 0 ){
					while(end >= after) {
						randomArray[end] = randomArray[end - 1];
						end --;
					}	
					randomArray[after - 1] = value;
				}else{
					while(end > 0) {
						randomArray[end] = randomArray[end - 1];
						end --;
					}	
					randomArray[0] = value;
				}
			}	
		}

		return data;
	}
	**/
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100); // 获取一个大小为30，最大值为100的乱序数组
		System.out.println("排序前：" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = InsertSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("排序后：" + Provider.printArray(randomArray));
		System.out.println("共交换" + data[0] + "次， 共比较" + data[1] + "次。");
		System.out.println("共用时：" + Provider.getTime(startTime, endTime, ""));
		//System.out.println((3+4)/2);
	}
}
