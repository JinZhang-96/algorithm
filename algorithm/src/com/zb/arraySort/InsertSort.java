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
public class InsertSort extends AbstractSort{

	/**
	 * 插入排序思路：一个乱序数组， 我们使数组是部分有序的， 在排序的开始， 我们认为数组的第一个元素就是那个部分有序的数组。然后选择有序
	 * 数组最后元素的下一个元素，在有序数组中查找这个元素应该插入的位置。直到有序数组的长度等于整个数组的长度位置。
	 * 比较复杂度 O(n*n), 交换复杂度O(n*n);比较次数和交换次数相等。虽然时间复杂度和冒泡排序一样，但是一般它比冒泡和选择排序更快一些
	 * 
	 * 延伸： 因为插入排序的部分数组是有序的， 我们在待归序元素查找插入位置的时候可以引入2分查找， 这样可以降低比较次数，此时比较的复杂度为O(n*logn),在n比较大时， 效率有所提高
	 * 
	 * 
	 * 实现代码如下：
	 */
	public InsertSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("插入排序");
	}
	

	// 未使用2分查找的数组
	public  void sort(int[] randomArray) {
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // 要插入有序数组的值
			int end = i; // 记录要存放元素的位置
			 //找到适当的插入位置， 如果要插入的值小于当前的值， 就把当前值向后移动一个位置
			while(end > 0 && randomArray[end-1] > value) {
				this.log.comparePlus();
				this.log.swapPlus();
				randomArray[end] = randomArray[end - 1];
				end --;
			}
			this.log.swapPlus();
			randomArray[end] = value;
		}
	}
	


	// 使用2分查找
	public  void binarySort(int[] randomArray) {
		// 由数组的第2个元素到最后一个元素插入到有序数组中
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // 要插入有序数组的值
			int end = i; // 记录要存放元素的位置
			int start = 0; // 有序数组的起点
			int after = i - 1; //有序数组的末点 
			 //找到适当的插入位置
			int position = this.binarySearch(start, after,value, randomArray);
			while(end > position) {
				randomArray[end] = randomArray[end - 1];	
				end--;
				this.log.swapPlus();
			}
			randomArray[position] = value;		
			this.log.swapPlus();
		}		
	}
	
	/**
	* @Title: binarySearch
	* @Description: TODO(2分查找待归序元素该插入的位置)
	* @param @param start
	* @param @param end
	* @param @param value
	* @param @return    设定文件
	* @return int    返回类型
	* @author zb 
	* @throws
	 */
	public  int binarySearch(int start, int end, int value, int[] randomArray){
		this.log.comparePlus();
		int mid = (start+end)/2 ; // 获取中间元素
		// 如果中间元素等于待归序的元素， 就可以把待归序的元素插入到这个位置
		if(randomArray[mid] == value)
			return mid;	
		// 如果划分的数组只有一个元素
		if(start == end) {
			//如果中间元素大于待归序元素, 取该元素位置为插入位置； 如果中间元素小于待归序元素，取该元素的前一个元素为插入位置
			return randomArray[mid] > value? mid: mid + 1;
		}		
		// 如果中间元素大于待归序元素,在中间元素的左侧数组中查找该插入的位置,否则在中间元素的右侧数组中查找该插入的位置.
		return randomArray[mid] > value? this.binarySearch(start, mid == start ? mid: mid - 1, value, randomArray) // 因为有时候mid会等于start, 防止mid过小
				: this.binarySearch(mid + 1, end, value, randomArray);	
	}
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(1000, 1000); // 获取一个大小为30，最大值为100的乱序数组
		InsertSort insertSort = new InsertSort();
		System.out.println(insertSort.showSort(randomArray, "s", true));	
	
	}
}
