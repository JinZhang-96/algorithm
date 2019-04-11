package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: SelectSort
* @Description: TODO(ѡ������)
* @author zb
* @date 2019��4��11�� ����4:31:42
*
 */
public class SelectSort {
	
	/**
	 * ѡ������˼·�������������ʼ�㿪ʼ������һ��Ԫ�ص�ֵ�Ƚϣ�ֱ��ĩ����������Լ�¼������С�����������е�λ�ã� ֱ�������󣬼�¼��
	 * Ԫ�ؾ���������С��Ԫ�أ�Ȼ�������δ����������ʼ����н���������ʵ�֣� 
	 */
	
	public static int[] sort(int[] randomArray) {
		int[] data = {0,0};
		 
		 for(int i  = 0; i< randomArray.length - 1; i++) {
			 int min = i; // ��¼��СԪ�ص�λ�ã� ��ʼΪδ���������ʼ��
			 for(int j = i + 1; j < randomArray.length; j++ ) {
				 data[1] += 1;
				 // �����ǰԪ�ش��ڱ�ǵ���СԪ�ص�ֵ����ı���СԪ�ص�����Ϊ��Ԫ�ص�����
				 if(randomArray[min] > randomArray[j]) {
					 min = j;
				 }
			 }
			 // ���δ���������ʼ�������Сֵ��û��Ҫ������
			 if(min == i) {
				 continue;
			 }			 
			 randomArray[i] = randomArray[i] ^ randomArray[min];
			 randomArray[min] = randomArray[i] ^ randomArray[min];
			 randomArray[i] = randomArray[i] ^ randomArray[min];
			 data[0] += 1;
			 
		 }
		 return data;
	}
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10, 100);  // ��ȡһ����СΪ30�� ���ֵΪ100����������
		System.out.println("����ǰ��"+ Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = SelectSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("�����"+ Provider.printArray(randomArray));
		System.out.println("������" + data[0]+"�Σ� ������"+data[1]+"�Ρ�" );
		System.out.println("����ʱ��"+Provider.getTime(startTime, endTime, ""));
	}

}
