package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: MergeSort
* @Description: TODO(归并排序)
* @author zb
* @date 2019年4月18日 下午8:11:35
*
 */
public class MergeSort extends AbstractSort {
/**
 *  思路：  归并排序采用分治法作为其算法思想， 把一个难以处理的大问题分割为多个处理简单的小问题。
 *  其实现方式为多种，可统称为多路归并， 其典型的处理为2路归并。 
 *  这里实现的是2路归并，首先把大数组分割为含有2个元素的小数组，然后对小数组排序。
 *  然后返回上层，依次把2个排好序的小数组合为一个有序的大数组。
 *  稳定的排序算法，速度仅次于快速排序比较时间复杂度为O(n*log n), 交换复杂度为O(n*log n); 
 * 代码实现如下： 
 */
	
	
	
	public MergeSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("二路归并排序");
	}
	
	/**
	 * 
	* @Title: sort
	* @Description: TODO(merge sort method)
	* @param  start  start point of array
	* @param end   end point of array 
	* @param randomArray  array of  need sort
	* @return void    返回类型
	* @author zb 
	* @throws
	 */
	public  void sort(int start, int end, int[] randomArray) {		
		// 当数组的元素只有一个时，排序完成
		if( (end - start) > 1){			
			int mid = (end + start)/2;
			this.sort(start, mid, randomArray);  // 这里结束点选择mid， 因为除2的过程有出现mid等于start的时候			
			this.sort(mid + 1, end, randomArray);			
			this.hasSortMerge(start, mid, end, randomArray);					
		} else if((end - start) == 1 ){
			if(randomArray[end] < randomArray[start]){
				randomArray[end] = randomArray[end] ^ randomArray[start];
				randomArray[start] = randomArray[end] ^ randomArray[start];
				randomArray[end] = randomArray[end] ^ randomArray[start]; 
				this.log.swapPlus();
			}
			this.log.swapPlus();
		}
		return;		
	}
	
	/**
	 * 
	* @Title: hasSortMerge
	* @Description: TODO(merge double array of sort)
	* @param  start 数组起点
	* @param  mid  2个数组的分界点
	* @param  end 数组结点
	* @param  randomArray    
	* @return void    返回类型
	* @author zb 
	* @throws
	 */
	public void hasSortMerge(int start, int mid, int end, int[] randomArray){
		int i = start; 
		int j = mid + 1;
		int index = 0;
		int[] temp = new int[end + 1 - start]; // 先声明排序好的元素要放置的临时数组
		while(i <= mid && j <= end){
			if(randomArray[i] < randomArray[j]){
				temp[index] = randomArray[i];
				i++;
				index++;
				this.log.comparePlus();
				continue;
			}else if(randomArray[i] > randomArray[j]){
				temp[index] = randomArray[j];
				j++;
				index++;
				this.log.comparePlus();
				continue;
			}else{
				temp[index] = randomArray[i];
				temp[++index] = randomArray[j];
				j++;
				i++;
				index++;
				continue;
			}
		}
		while(i > mid && j <= end){
			temp[index] = randomArray[j];
			j++;
			index++;			
		}
		while(i <= mid && j > end){
			temp[index] = randomArray[i];
			i++;
			index++;
		}	
		
		for(int item : temp){
			randomArray[start] = item;
			start++;
			this.log.swapPlus();
		}				
	}
	
	
	@Override
	public Log showSort(int[] value, String timeSize, boolean isPrintDataItem) {
		// TODO Auto-generated method stub
 		if(isPrintDataItem)
			 this.log.setBeforeSort(Provider.printArray(value));
		 long startTime = System.nanoTime();		 
		 this.sort(0,value.length -1 ,value);
		 long endTime = System.nanoTime();
		 if(isPrintDataItem)
			 this.log.setAfterSort(Provider.printArray(value));
		 this.log.setUsedTime(Provider.getTime(startTime, endTime, timeSize));
		 this.log.setSize(value.length);
		 return this.log;
	}
	
   	
	
	
	public static void main(String[] args) {
		int size = 1000000;
		int[] randomArray = Provider.getArray(size, 100000);
		MergeSort mergeSort = new MergeSort();
		System.out.println(mergeSort.showSort(randomArray, "s", false));	
	}

}
