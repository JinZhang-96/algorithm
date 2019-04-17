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
public class QuickSort extends AbstractSort{
	/**
	 * ��������˼·��ͨ������ ���������黮��Ϊ����Ŧ��povitΪ�м�㣬��������ֵС����Ŧ�㣬 �ұߵ�ֵ������Ŧ������顣
	 * ֱ�����ֵ����鳤��Ϊ1�� �������Ĭ�Ͼ�������ģ� ֹͣ����Ļ��֡�
	 * ����ʱ�临�Ӷ�O(n*logn)���Ƚ�ʱ�临�Ӷ�O(n*logn)��
	 * �������Ϊ����ʱЧ��������ʱ�临�ӶȺͱȽ�ʱ�临�Ӷ�ΪO(n^2);��ʹ����������ȡ�з���������Ӱ�죬��ȡ�����м䡢ͷ����β���������������м��С��������Ϊ��Ŧ��
	 * ʵ�ִ������£�
	 */
	
	public QuickSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("��������");
	}
	
	public  void sort(int left, int right, int[] randomArray) {		
		// �������Ԫ��ֻ��һ��ʱ���������
		if(left >= right){
			return ;
		}		
		// ������� postitionλ�õ�Ԫ���Ѿ������������е�Ԫ����
		int position = partition(left, right, randomArray);
		
		sort(left, position -1, randomArray);
		sort(position + 1, right, randomArray);
		
	}
	
	/**
	 * 
	* @Title: midSort
	* @Description: TODO(������ȡ��)
	* @param @param left
	* @param @param right    �趨�ļ�
	* @return void    ��������
	* @author zb 
	* @throws
	 */
	public  void midSort(int left, int right, int[] randomArray) {		
		// �������Ԫ��С��4��ʱ���Ͳ���ʹ��3������ȡ����
		if(left + 2 >= right){
			manualSort(left, right, randomArray);
			return;
		}		
		// ������� postitionλ�õ�Ԫ���Ѿ������������е�Ԫ����
		int position = midPartition(left, right, randomArray);
		
		midSort(left, position -1, randomArray);
		midSort(position + 1, right, randomArray);
		
	}
	
	/**
	 * 
	* @Title: manualSort
	* @Description: TODO(left��right����)
	* @param @param left
	* @param @param right    �趨�ļ�
	* @return void    ��������
	* @author zb 
	* @throws
	 */
	public void manualSort(int left, int right, int[] randomArray){
		int size = right - left;
		if(size < 1) {
			return ;
		}else if(size == 2) {
			if(randomArray[left] > randomArray[right]){
				swap(left, right, randomArray);
			}
			this.log.comparePlus();
		}else{
			if(randomArray[left] > randomArray[right - 1]){
				swap(left, right - 1, randomArray);
			}
			if(randomArray[left] > randomArray[right]){
				swap(left, right, randomArray);
			}
			if(randomArray[right - 1] > randomArray[right]){
				swap(right - 1, right, randomArray);
			}
			this.log.comparePlus(3);
		}
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
	public  int partition(int left, int right, int[] randomArray) {
		// Ĭ��ȡ����ĵ�һ����Ϊ��Ŧ��
		int  povit = randomArray[left];	
		int start = left; // ��¼��Ŧ��Ԫ�ص�λ��
		// ��leftδ��right����ʱ���ͼ�����һ�ֽ���
		while(true) {
			// Ĭ����������Ҳ��ȿ�ʼ����, ��Ϊpovit��λ��Ϊ�����ʼ�㣬 ���Կ��Կ϶�right--�Ĺ����п϶����ҵ�randomArray[right] <= povit����������Կ���ȥ��right>left���ж�
			while(randomArray[right] > povit){ // ���������б�povitС������Ԫ��
				this.log.comparePlus();
				right--; 
			}
			// ��Ϊ��ʼleftָ��povit�� ����leftҪ������������povit���н���
			while(++left < right && randomArray[left] < povit) {
				this.log.comparePlus();
			};// ���������б�povit�������Ԫ��
			
			// ��������Ԫ��				
			if(left < right) {
				int temp = randomArray[left];
				randomArray[left] = randomArray[right];
				randomArray[right] = temp;
				this.log.swapPlus();
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
		this.log.swapPlus();
		return right;
	}
	
	public  int midPovit(int left, int right, int[] randomArray){
		int mid = (left + right)/2;
		if(randomArray[left] > randomArray[mid]){
			swap(left, mid, randomArray);
		}
		if(randomArray[left] > randomArray[right]){
			swap(left, right, randomArray);
		}
		if(randomArray[mid] > randomArray[right]){
			swap(mid, right, randomArray);
		}
		swap(mid, left, randomArray);
		this.log.comparePlus(3);
		this.log.swapPlus(3);
		return randomArray[left];
	}
	
	
	public  void swap(int l, int r, int[] randomArray){
		int temp = randomArray[l];
		randomArray[l] = randomArray[r];
		randomArray[r] = temp;
		this.log.swapPlus();
	}
	
	
	public int midPartition(int left, int right, int[] randomArray) {	
		// ��ȡ��Ŧ���ֵ
		int  povit = midPovit(left, right, randomArray);	
		int start = left; // ��¼��Ŧ��Ԫ�ص�λ��
		// ��leftδ��right����ʱ���ͼ�����һ�ֽ���
		while(true) {
			// Ĭ����������Ҳ��ȿ�ʼ����, ��Ϊpovit��λ��Ϊ�����ʼ�㣬 ���Կ��Կ϶�right--�Ĺ����п϶����ҵ�randomArray[right] <= povit����������Կ���ȥ��right>left���ж�
			while(randomArray[right] > povit){ // ���������б�povitС������Ԫ��
				this.log.comparePlus();
				right--;
			}
			// ��Ϊ��ʼleftָ��povit�� ����leftҪ������������povit���н���
			while(randomArray[++left] < povit) {
				this.log.comparePlus();
			};// ���������б�povit�������Ԫ��
			
			// ��������Ԫ��				
			if(left < right) {
				int temp = randomArray[left];
				randomArray[left] = randomArray[right];
				randomArray[right] = temp;
				this.log.swapPlus();
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
		this.log.swapPlus();
		return right;
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
			
		int size = 10000;		
		int[] randomArray = Provider.getArray(size, 1000);// ��ȡһ����СΪ30�����ֵΪ100����������		
		System.out.println(new QuickSort().showSort(randomArray, "s", true));
	}

}
