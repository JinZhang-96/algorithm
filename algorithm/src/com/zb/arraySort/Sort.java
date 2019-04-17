package com.zb.arraySort;

public interface Sort {
	
	/**
	 * 
	* @Title: showSort
	* @Description: TODO(打印排序数据信息)
	* @param @param value
	* @param @param timeSize
	* @param @param isPrintDataItem
	* @param @return    设定文件
	* @return Log    返回类型
	* @author zb 
	* @throws
	 */
	 public  Log  showSort(int[] value, String timeSize, boolean isPrintDataItem);
	 
	 
	 public void sort(int[] randomArray);
}
