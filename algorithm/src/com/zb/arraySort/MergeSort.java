package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: MergeSort
* @Description: TODO(�鲢����)
* @author zb
* @date 2019��4��18�� ����8:11:35
*
 */
public class MergeSort extends AbstractSort {
/**
 *  ˼·��  �鲢������÷��η���Ϊ���㷨˼�룬 ��һ�����Դ���Ĵ�����ָ�Ϊ�������򵥵�С���⡣
 *  ��ʵ�ַ�ʽΪ���֣���ͳ��Ϊ��·�鲢�� ����͵Ĵ���Ϊ2·�鲢�� 
 *  ����ʵ�ֵ���2·�鲢�����ȰѴ�����ָ�Ϊ����2��Ԫ�ص�С���飬Ȼ���С��������
 *  Ȼ�󷵻��ϲ㣬���ΰ�2���ź����С�����Ϊһ������Ĵ����顣
 *  �ȶ��������㷨���ٶȽ����ڿ�������Ƚ�ʱ�临�Ӷ�ΪO(n*log n), �������Ӷ�ΪO(n*log n); 
 * ����ʵ�����£� 
 */
	
	
	
	public MergeSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("��·�鲢����");
	}
	
	/**
	 * 
	* @Title: sort
	* @Description: TODO(merge sort method)
	* @param  start  start point of array
	* @param end   end point of array 
	* @param randomArray  array of  need sort
	* @return void    ��������
	* @author zb 
	* @throws
	 */
	public  void sort(int start, int end, int[] randomArray) {		
		// �������Ԫ��ֻ��һ��ʱ���������
		if( (end - start) > 1){			
			int mid = (end + start)/2;
			this.sort(start, mid, randomArray);  // ���������ѡ��mid�� ��Ϊ��2�Ĺ����г���mid����start��ʱ��			
			this.sort(mid + 1, end, randomArray);			
			this.hasSortMerge(start, mid, end, randomArray);					
		} else if((end - start) == 1 ){
			if(randomArray[end] < randomArray[start]){
				randomArray[end] = randomArray[end] ^ randomArray[start];
				randomArray[start] = randomArray[end] ^ randomArray[start];
				randomArray[end] = randomArray[end] ^ randomArray[start]; 
				this.log.swapPlus();
			}
			this.log.swapPlus();
		}
		return;		
	}
	
	/**
	 * 
	* @Title: hasSortMerge
	* @Description: TODO(merge double array of sort)
	* @param  start �������
	* @param  mid  2������ķֽ��
	* @param  end ������
	* @param  randomArray    
	* @return void    ��������
	* @author zb 
	* @throws
	 */
	public void hasSortMerge(int start, int mid, int end, int[] randomArray){
		int i = start; 
		int j = mid + 1;
		int index = 0;
		int[] temp = new int[end + 1 - start]; // ����������õ�Ԫ��Ҫ���õ���ʱ����
		while(i <= mid && j <= end){
			if(randomArray[i] < randomArray[j]){
				temp[index] = randomArray[i];
				i++;
				index++;
				this.log.comparePlus();
				continue;
			}else if(randomArray[i] > randomArray[j]){
				temp[index] = randomArray[j];
				j++;
				index++;
				this.log.comparePlus();
				continue;
			}else{
				temp[index] = randomArray[i];
				temp[++index] = randomArray[j];
				j++;
				i++;
				index++;
				continue;
			}
		}
		while(i > mid && j <= end){
			temp[index] = randomArray[j];
			j++;
			index++;			
		}
		while(i <= mid && j > end){
			temp[index] = randomArray[i];
			i++;
			index++;
		}	
		
		for(int item : temp){
			randomArray[start] = item;
			start++;
			this.log.swapPlus();
		}				
	}
	
	
	@Override
	public Log showSort(int[] value, String timeSize, boolean isPrintDataItem) {
		// TODO Auto-generated method stub
 		if(isPrintDataItem)
			 this.log.setBeforeSort(Provider.printArray(value));
		 long startTime = System.nanoTime();		 
		 this.sort(0,value.length -1 ,value);
		 long endTime = System.nanoTime();
		 if(isPrintDataItem)
			 this.log.setAfterSort(Provider.printArray(value));
		 this.log.setUsedTime(Provider.getTime(startTime, endTime, timeSize));
		 this.log.setSize(value.length);
		 return this.log;
	}
	
   	
	
	
	public static void main(String[] args) {
		int size = 1000000;
		int[] randomArray = Provider.getArray(size, 100000);
		MergeSort mergeSort = new MergeSort();
		System.out.println(mergeSort.showSort(randomArray, "s", false));	
	}

}
