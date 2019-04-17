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
public class BubbleSort  extends AbstractSort{
	
	/**
	 * ð������˼·��һ���������飬ͨ�������һ��Ԫ�غ�������һ��Ԫ�رȽϣ�
	 * ���������һ��Ԫ��û������ֵ�󣬾ͽ���������ֵ�����򲻽�����
	 * �������������㿪ʼ����������ĩβ���Ϳ��Ա�֤����Ԫ�ؾ�����ЩԪ��������һ����
	 * ��Ϊ�ʼ��Ҫ������Ԫ��ֵ�ǽ�С�ģ������Ҫ������ֵԽ��Խ��ֱ����󣬿���������ˮ�и��������ݣ�
	 * ���Գ�Ϊð������ 
	 * ��Ϊ��ͼ��������㷨�� �Ƚ�ʱ�临�Ӷ�ΪO(n*n), ����ʱ�临�Ӷ�ΪO(n*n), Ч���� ������ʹ�á�
	 * 
	 * ����ʵ�����£�
	 */
	
	public BubbleSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("ð������");
	}
	
	 public  void sort(int[] randomArray) {
		 
		 for(int i  = 0; i< randomArray.length - 1; i++) {
			 
			 for(int j = 0; j < randomArray.length - (1 + i); j++ ) {
				 this.log.comparePlus();				 
				 // ���ǰ���Ԫ�ش��ں����Ԫ�أ��򽻻�
				 if(randomArray[j] > randomArray[j+1]) {
					randomArray[j] = randomArray[j+1] ^ randomArray[j];
					randomArray[j+1] = randomArray[j] ^ randomArray[j+1];
					randomArray[j] = randomArray[j] ^ randomArray[j+1];
					this.log.swapPlus();
				 }
			 }
			 
		 }
	 }
	 
	 	 
	 public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();		
		int[] randomArray = Provider.getArray(10000, 100);  // ��ȡһ����СΪ30�� ���ֵΪ100����������
		System.out.println(bubbleSort.showSort(randomArray, "s",false));
	}

}
