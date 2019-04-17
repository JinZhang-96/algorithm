package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
 * @ClassName: InsertSort
 * @Description: TODO(��������)
 * @author zb
 * @date 2019��4��11�� ����4:32:03
 *
 */
public class InsertSort extends AbstractSort{

	/**
	 * ��������˼·��һ���������飬 ����ʹ�����ǲ�������ģ� ������Ŀ�ʼ�� ������Ϊ����ĵ�һ��Ԫ�ؾ����Ǹ�������������顣Ȼ��ѡ������
	 * �������Ԫ�ص���һ��Ԫ�أ������������в������Ԫ��Ӧ�ò����λ�á�ֱ����������ĳ��ȵ�����������ĳ���λ�á�
	 * �Ƚϸ��Ӷ� O(n*n), �������Ӷ�O(n*n);�Ƚϴ����ͽ���������ȡ���Ȼʱ�临�ӶȺ�ð������һ��������һ������ð�ݺ�ѡ���������һЩ
	 * 
	 * ���죺 ��Ϊ��������Ĳ�������������ģ� �����ڴ�����Ԫ�ز��Ҳ���λ�õ�ʱ���������2�ֲ��ң� �������Խ��ͱȽϴ�������ʱ�Ƚϵĸ��Ӷ�ΪO(n*logn),��n�Ƚϴ�ʱ�� Ч���������
	 * 
	 * 
	 * ʵ�ִ������£�
	 */
	public InsertSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("��������");
	}
	

	// δʹ��2�ֲ��ҵ�����
	public  void sort(int[] randomArray) {
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // Ҫ�������������ֵ
			int end = i; // ��¼Ҫ���Ԫ�ص�λ��
			 //�ҵ��ʵ��Ĳ���λ�ã� ���Ҫ�����ֵС�ڵ�ǰ��ֵ�� �Ͱѵ�ǰֵ����ƶ�һ��λ��
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
	


	// ʹ��2�ֲ���
	public  void binarySort(int[] randomArray) {
		// ������ĵ�2��Ԫ�ص����һ��Ԫ�ز��뵽����������
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // Ҫ�������������ֵ
			int end = i; // ��¼Ҫ���Ԫ�ص�λ��
			int start = 0; // ������������
			int after = i - 1; //���������ĩ�� 
			 //�ҵ��ʵ��Ĳ���λ��
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
	* @Description: TODO(2�ֲ��Ҵ�����Ԫ�ظò����λ��)
	* @param @param start
	* @param @param end
	* @param @param value
	* @param @return    �趨�ļ�
	* @return int    ��������
	* @author zb 
	* @throws
	 */
	public  int binarySearch(int start, int end, int value, int[] randomArray){
		this.log.comparePlus();
		int mid = (start+end)/2 ; // ��ȡ�м�Ԫ��
		// ����м�Ԫ�ص��ڴ������Ԫ�أ� �Ϳ��԰Ѵ������Ԫ�ز��뵽���λ��
		if(randomArray[mid] == value)
			return mid;	
		// ������ֵ�����ֻ��һ��Ԫ��
		if(start == end) {
			//����м�Ԫ�ش��ڴ�����Ԫ��, ȡ��Ԫ��λ��Ϊ����λ�ã� ����м�Ԫ��С�ڴ�����Ԫ�أ�ȡ��Ԫ�ص�ǰһ��Ԫ��Ϊ����λ��
			return randomArray[mid] > value? mid: mid + 1;
		}		
		// ����м�Ԫ�ش��ڴ�����Ԫ��,���м�Ԫ�ص���������в��Ҹò����λ��,�������м�Ԫ�ص��Ҳ������в��Ҹò����λ��.
		return randomArray[mid] > value? this.binarySearch(start, mid == start ? mid: mid - 1, value, randomArray) // ��Ϊ��ʱ��mid�����start, ��ֹmid��С
				: this.binarySearch(mid + 1, end, value, randomArray);	
	}
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(1000, 1000); // ��ȡһ����СΪ30�����ֵΪ100����������
		InsertSort insertSort = new InsertSort();
		System.out.println(insertSort.showSort(randomArray, "s", true));	
	
	}
}
