package com.zb.arraySort;

public interface Sort {
	
	/**
	 * 
	* @Title: showSort
	* @Description: TODO(��ӡ����������Ϣ)
	* @param @param value
	* @param @param timeSize
	* @param @param isPrintDataItem
	* @param @return    �趨�ļ�
	* @return Log    ��������
	* @author zb 
	* @throws
	 */
	 public  Log  showSort(int[] value, String timeSize, boolean isPrintDataItem);
	 
	 
	 public void sort(int[] randomArray);
}
