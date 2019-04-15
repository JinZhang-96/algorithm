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
	 * �Ƚϸ��Ӷ� n*n, �������Ӷ� n*n;�Ƚϴ����ͽ���������ȡ���Ȼʱ�临�ӶȺ�ð������һ��������һ������ð�ݺ�ѡ���������һЩ
	 * 
	 * 
	 * ʵ�ִ������£�
	 */

	// δʹ��2�ֲ��ҵ�����
	public static int[] sort(int[] randomArray) {
		int[] data = { 0, 0 };
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
	/**
	public static int[] sort1(int[] randomArray) {
		int[] data = { 0, 0 };
		// ������ĵ�2��Ԫ�ص����һ��Ԫ�ز��뵽����������
		for (int i = 1; i < randomArray.length; i++) {
			int value = randomArray[i]; // Ҫ�������������ֵ
			int end = i; // ��¼Ҫ���Ԫ�ص�λ��
			int start = 0; // ������������
			int after = i - 1; //���������ĩ�� 
			 //�ҵ��ʵ��Ĳ���λ��
			while(after > start){
				int mid = (after+start)/2;
				if(randomArray[mid] > value){
					after = mid -1;
				}else if(randomArray[mid] < value){
					start = mid+1;
				}else {
					// �ҵ�Ԫ��Ҫ�����λ���˳�
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
		int[] randomArray = Provider.getArray(10000, 100); // ��ȡһ����СΪ30�����ֵΪ100����������
		System.out.println("����ǰ��" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = InsertSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data[0] + "�Σ� ���Ƚ�" + data[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime, endTime, ""));
		//System.out.println((3+4)/2);
	}
}
