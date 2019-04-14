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
	 * ��������˼·��ͨ�����ֶ��������黮��Ϊ����Ŧ��povitΪ�м�㣬��������ֵС����Ŧ�㣬 �ұߵ�ֵ������Ŧ�㡣
	 * ֱ�����ֵ����鳤��Ϊ1�� ��������������ġ�
	 * ʵ�ִ������£�
	 */
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100); // ��ȡһ����СΪ30�����ֵΪ100����������
		
		System.out.println("����ǰ��" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = ShellSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data[0] + "�Σ� ���Ƚ�" + data[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime, endTime, ""));
		
	}

}
