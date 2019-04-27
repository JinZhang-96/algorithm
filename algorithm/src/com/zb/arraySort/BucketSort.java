package com.zb.arraySort;

import java.util.ArrayList;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: BucketSort
* @Description: TODO(��������)
* @author zb
* @date 2019��4��18�� ����8:10:49
*
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class BucketSort extends AbstractSort {
	
	/**
	 * ��������˼·���������Ϊn,һ�������л���Ϊ10�� һ���������飬�Ȼ�ȡ�������������m������m��kλ�� 
	 * ��ȡ����������ÿ�����ĸ�λֵ�� �������Ƿŵ���Ӧ��Ͱ�С�Ȼ����Ͱ��ȡ�����ŵ������У� ֱ��n-1λ������
	 * ʱ�临�Ӷ�Ϊ O(K * n),  kΪ������Ҫ�ȿ�������졣��ΪҪ����ʱ����Ԫ��,��ռ��2���ڴ档
	 * 
	 * ����ʵ������
	 */
	
	public BucketSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("��������");
	}
	
	
	/**
	 * 
	* @Title: sort
	* @Description: TODO(������һ�仰�����������������)
	* @param     �趨�ļ�
	* @return void    ��������
	* @author zb 
	* @throws
	 */
	public void sort(int[] randomArray){
		int k = String.valueOf(this.getMax(randomArray)).length(); // ��ȡ�������λ��
		ArrayList<Object> temps[] = new ArrayList[10];
		for(int i = 0; i< 10; i++){
			temps[i] = new ArrayList<Object>();
		}
		
		int i = 0;// ����ʼ��λ��
		while(i <= k){  // ��0-kλ��Ҫִ��һ��
			// �������ֵ�ַ�����������Ͱ��
			for(int x = 0; x < randomArray.length; x++){
				int value = ((int) (randomArray[x] / Math.pow(10, i)) % 10);				
				temps[value].add(randomArray[x]);
			}
			
			// ��Ͱ��ȡ�����ŵ�ԭ��������
			int p = 0;
			for(int x = 0; x< temps.length; x++){
				ArrayList al = temps[x];// ��x��Ͱ
				int j = 0;
				while(j < al.size()){
					randomArray[p] = (int) al.get(j);
					this.log.swapPlus();
					p++;
					j++;
				}
				
				al.clear(); // Ͱ�е�Ԫ���Ѿ��Ż����飬Ҫ���
			}
			i++;
		}
	}
	
	/**
	 * 
	* @Title: getMax
	* @Description: TODO(��ȡһ��������������)
	* @param @param value
	* @param @return    �趨�ļ�
	* @return int    ��������
	* @author zb 
	* @throws
	 */
	public int getMax(int[] value){
		int max = value[0] ;
		for(int i = 1; i< value.length; i++){
			if(value[i] > max){
				max = value[i];
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int size = 10000000;
		int[] randomArray = Provider.getArray(size, 10000);
		BucketSort bucketSort = new BucketSort();
		System.out.println(bucketSort.showSort(randomArray, "s", false));		
	}
}
