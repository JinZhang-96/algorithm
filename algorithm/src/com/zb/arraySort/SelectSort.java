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
public class SelectSort extends AbstractSort{
	
	/**
	 * ѡ������˼·�������������ʼ�㿪ʼ������һ��Ԫ�ص�ֵ�Ƚϣ�ֱ��ĩ����������Լ�¼������С�����������е�λ�ã� ֱ�������󣬼�¼��
	 * λ�þ���������С��Ԫ�����ڵ�λ�ã�Ȼ�������δ����������ʼ����н������ɡ�
	 * 
	 * �����ð���㷨�� ���һЩ�� �Ƚ�ʱ�临�Ӷ�ΪO(n*n), �������Ӷ�ΪO(n);
	 * 
	 * ������ʵ�����£� 
	 */
	
	public SelectSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("ѡ������");
	}
	
	public void sort(int[] randomArray) {
		 for(int i  = 0; i< randomArray.length - 1; i++) {
			 int min = i; // ��¼��СԪ�ص�λ�ã� ��ʼΪδ���������ʼ��
			 for(int j = i + 1; j < randomArray.length; j++ ) {
				 this.log.comparePlus();
				 // �����ǰԪ��С�ڱ�ǵ���СԪ�ص�ֵ����ı���СԪ�ص�����Ϊ��Ԫ�ص�����
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
			 this.log.swapPlus();
			 
		 }
	}
	
	
	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100);  // ��ȡһ����СΪ30�� ���ֵΪ100����������
		System.out.println(new SelectSort().showSort(randomArray, "s", false));
		
	}

}
