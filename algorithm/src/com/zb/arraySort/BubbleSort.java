package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: BubbleSort
* @Description: TODO(ð�������㷨)
* @author zb
* @date 2019��4��11�� ����4:30:00
*
 */
public class BubbleSort {
	
	/**
	 * ð������˼·��һ���������飬ͨ�������һ��Ԫ�غ�������һ��Ԫ�رȽϣ�
	 * ���������һ��Ԫ��û������ֵ�󣬾ͽ���������ֵ�����򲻽�����
	 * �������������㿪ʼ����������ĩβ���Ϳ��Ա�֤����Ԫ�ؾ�����ЩԪ��������һ����
	 * ��Ϊ�ʼ��Ҫ������Ԫ��ֵ�ǽ�С�ģ������Ҫ������ֵԽ��Խ��ֱ����󣬿���������ˮ�и��������ݣ�
	 * ���Գ�Ϊð������ 
	 * ��Ϊ��ͼ��������㷨�� �Ƚ�ʱ�临�Ӷ�Ϊn*n, ����ʱ�临�Ӷ�Ϊn*n, Ч���� ������ʹ�á�
	 * 
	 * ����ʵ�����£�
	 */
	
	
	 public static int[] sort(int[] randomArray) {
		 int[] data = {0,0};
		 
		 for(int i  = 0; i< randomArray.length - 1; i++) {
			 
			 for(int j = 0; j < randomArray.length - (1 + i); j++ ) {
				 data[1] +=1;
				 // ���ǰ���Ԫ�ش��ں����Ԫ�أ��򽻻�
				 if(randomArray[j] > randomArray[j+1]) {
					randomArray[j] = randomArray[j+1] ^ randomArray[j];
					randomArray[j+1] = randomArray[j] ^ randomArray[j+1];
					randomArray[j] = randomArray[j] ^ randomArray[j+1];
					data[0] += 1;
				 }
			 }
			 
		 }
		 return data;
	 }
	 
	 
	 public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100);  // ��ȡһ����СΪ30�� ���ֵΪ100����������
		System.out.println("����ǰ��"+ Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = BubbleSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("�����"+ Provider.printArray(randomArray));
		System.out.println("������" + data[0]+"�Σ� ���Ƚ�"+data[1]+"�Ρ�" );
		System.out.println("����ʱ��"+Provider.getTime(startTime, endTime, ""));
		
	}

}
