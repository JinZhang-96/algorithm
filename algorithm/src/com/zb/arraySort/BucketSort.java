package com.zb.arraySort;

import java.util.ArrayList;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: BucketSort
* @Description: TODO(基数排序)
* @author zb
* @date 2019年4月18日 下午8:10:49
*
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class BucketSort extends AbstractSort {
	
	/**
	 * 基数排序思路：假设基数为n,一般排序中基数为10。 一个乱序数组，先获取该数组内最大数m，假设m有k位。 
	 * 获取乱序数组中每个数的个位值， 并把他们放到对应的桶中。然后在桶中取出来放到数组中， 直到n-1位结束。
	 * 时间复杂度为 O(K * n),  k为常数。要比快速排序快。因为要存临时数组元素,会占用2倍内存。
	 * 
	 * 代码实现如下
	 */
	
	public BucketSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("基数排序");
	}
	
	
	/**
	 * 
	* @Title: sort
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param     设定文件
	* @return void    返回类型
	* @author zb 
	* @throws
	 */
	public void sort(int[] randomArray){
		int k = String.valueOf(this.getMax(randomArray)).length(); // 获取最大数的位数
		ArrayList<Object> temps[] = new ArrayList[10];
		for(int i = 0; i< 10; i++){
			temps[i] = new ArrayList<Object>();
		}
		
		int i = 0;// 排序开始的位数
		while(i <= k){  // 对0-k位都要执行一遍
			// 把数组的值分发到各个数组桶里
			for(int x = 0; x < randomArray.length; x++){
				int value = ((int) (randomArray[x] / Math.pow(10, i)) % 10);				
				temps[value].add(randomArray[x]);
			}
			
			// 从桶里取出来放到原来数组里
			int p = 0;
			for(int x = 0; x< temps.length; x++){
				ArrayList al = temps[x];// 第x个桶
				int j = 0;
				while(j < al.size()){
					randomArray[p] = (int) al.get(j);
					this.log.swapPlus();
					p++;
					j++;
				}
				
				al.clear(); // 桶中的元素已经放回数组，要清除
			}
			i++;
		}
	}
	
	/**
	 * 
	* @Title: getMax
	* @Description: TODO(获取一个数组中最大的数)
	* @param @param value
	* @param @return    设定文件
	* @return int    返回类型
	* @author zb 
	* @throws
	 */
	public int getMax(int[] value){
		int max = value[0] ;
		for(int i = 1; i< value.length; i++){
			if(value[i] > max){
				max = value[i];
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int size = 10000000;
		int[] randomArray = Provider.getArray(size, 10000);
		BucketSort bucketSort = new BucketSort();
		System.out.println(bucketSort.showSort(randomArray, "s", false));		
	}
}
