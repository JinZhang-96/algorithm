package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: QuickSort
* @Description: TODO(��������)
* @author zb
* @date 2019��4��11�� ����4:32:42
*
 */
public class QuickSort {
	/**
	 * ��������˼·��ͨ������ ���������黮��Ϊ����Ŧ��povitΪ�м�㣬��������ֵС����Ŧ�㣬 �ұߵ�ֵ������Ŧ������顣
	 * ֱ�����ֵ����鳤��Ϊ1�� �������Ĭ�Ͼ�������ģ� ֹͣ����Ļ��֡�
	 * ����ʱ�临�Ӷ�n*logn���Ƚ�ʱ�临�Ӷ�n*logn
	 * ʵ�ִ������£�
	 */
	
	
	private static int[] randomArray;
	
	private static int[] data = {0,0};
	
	
	public  static void sort(int left, int right) {		
		// �������Ԫ��ֻ��һ��ʱ���������
		if(left >= right){
			return ;
		}		
		// ������� postitionλ�õ�Ԫ���Ѿ������������е�Ԫ����
		int position = partition(left, right);
		
		QuickSort.sort(left, position -1);
		QuickSort.sort(position + 1, right);
		
	}
	
	/**
	 * 
	* @Title: partition
	* @Description: TODO(���ֺ����� ��һ����������ָ�δ��povit��Ŧ��Ϊ�м�㣬 �����С��povit�� �ұߴ���povit��Ҳ����˵povit���ڵ�λ��ʱ���������������ڵ�λ��)
	* @param @param left
	* @param @param right
	* @param @return    �趨�ļ�
	* @return int    ��������
	* @author zb 
	* @throws
	 */
	public static int partition(int left, int right) {
		// Ĭ��ȡ����ĵ�һ����Ϊ��Ŧ��
		int  povit = randomArray[left];	
		int start = left; // ��¼��Ŧ��Ԫ�ص�λ��
		// ��leftδ��right����ʱ���ͼ�����һ�ֽ���
		while(true) {
			// Ĭ����������Ҳ��ȿ�ʼ����, ��Ϊpovit��λ��Ϊ�����ʼ�㣬 ���Կ��Կ϶�right--�Ĺ����п϶����ҵ�randomArray[right] <= povit����������Կ���ȥ��right>left���ж�
			while(randomArray[right] > povit){ // ���������б�povitС������Ԫ��
				data[1] += 1;
				right--; 
			}
			// ��Ϊ��ʼleftָ��povit�� ����leftҪ������������povit���н���
			while(++left < right && randomArray[left] < povit) {
				data[1] += 1;
			};// ���������б�povit�������Ԫ��
			
			// ��������Ԫ��				
			if(left < right) {
				int temp = randomArray[left];
				randomArray[left] = randomArray[right];
				randomArray[right] = temp;
				data[0] += 1;
			}else{
				break;
			}
			
		}	
		/* left��right�Ѿ������� ������ɡ�����left��right����������right��left������
		 * ������ȷ��randomArray[right]��С�ڵ���povit�ġ�
		 * ��right��ߵĶ�С��povit,�ұߵĶ�����povit
		 * 
		*/
		randomArray[start] = randomArray[right];
		randomArray[right] = povit;
		data[0] += 1;
		return right;
	}
	
	
	public static void main(String[] args) {
		
		randomArray = Provider.getArray(10000, 100); // ��ȡһ����СΪ30�����ֵΪ100����������
		
		System.out.println("����ǰ��" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		
		
		QuickSort.sort(0, randomArray.length-1);
		
		
		long endTime = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data[0] + "�Σ� ���Ƚ�" + data[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime, endTime, ""));
		
	}

}
