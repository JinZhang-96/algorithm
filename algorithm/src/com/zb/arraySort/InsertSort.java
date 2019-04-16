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
public class InsertSort {

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
	
	private static int[] randomArray;
	
	private static int[] data = {0,0};
	

	// δʹ��2�ֲ��ҵ�����
	public static void sort() {
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // Ҫ�������������ֵ
			int end = i; // ��¼Ҫ���Ԫ�ص�λ��
			 //�ҵ��ʵ��Ĳ���λ�ã� ���Ҫ�����ֵС�ڵ�ǰ��ֵ�� �Ͱѵ�ǰֵ����ƶ�һ��λ��
			while(end > 0 && randomArray[end-1] > value) {
				data[0] +=1;
				data[1] +=1;
				randomArray[end] = randomArray[end - 1];
				end --;
			}
			data[0] +=1;
			randomArray[end] = value;
		}
	}
	
	
	
	// δʹ��2�ֲ��ҵ�����
		public static int[] sort(int[] randomArray) {
			int data[] = {0,0};
			for (int i = 1; i < randomArray.length; i++) {
				int value = randomArray[i]; // Ҫ�������������ֵ
				int end = i; // ��¼Ҫ���Ԫ�ص�λ��
				 //�ҵ��ʵ��Ĳ���λ�ã� ���Ҫ�����ֵС�ڵ�ǰ��ֵ�� �Ͱѵ�ǰֵ����ƶ�һ��λ��
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

	// ʹ��2�ֲ���
	public static void binarySort() {
		// ������ĵ�2��Ԫ�ص����һ��Ԫ�ز��뵽����������
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // Ҫ�������������ֵ
			int end = i; // ��¼Ҫ���Ԫ�ص�λ��
			int start = 0; // ������������
			int after = i - 1; //���������ĩ�� 
			 //�ҵ��ʵ��Ĳ���λ��
			int position = InsertSort.binarySearch(start, after,value);
			while(end > position) {
				randomArray[end] = randomArray[end - 1];	
				end--;
				data[0] +=1;
			}
			randomArray[position] = value;		
			data[0] +=1;
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
	public static int binarySearch(int start, int end, int value){
		data[1] += 1;
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
		return randomArray[mid] > value? InsertSort.binarySearch(start, mid == start ? mid: mid - 1, value) // ��Ϊ��ʱ��mid�����start, ��ֹmid��С
				: InsertSort.binarySearch(mid + 1, end, value);	
	}
	
	
	public static void main(String[] args) {
		randomArray = Provider.getArray(1000, 1000); // ��ȡһ����СΪ30�����ֵΪ100����������
		int[] s = (int[]) Provider.clone(randomArray);
		System.out.println("����ǰ��" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		InsertSort.sort();
		long endTime = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data[0] + "�Σ� ���Ƚ�" + data[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime, endTime, ""));
		
		randomArray = s;
		data[0] = 0; data[1] = 0;
		System.out.println("����ǰ��" + Provider.printArray(randomArray));
		startTime = System.nanoTime();
		InsertSort.binarySort();
		endTime = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data[0] + "�Σ� ���Ƚ�" + data[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime, endTime, ""));
		
	
	}
}
