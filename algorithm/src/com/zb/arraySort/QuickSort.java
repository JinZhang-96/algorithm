package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
* @ClassName: QuickSort
* @Description: TODO(快速排序)
* @author zb
* @date 2019年4月11日 下午4:32:42
*
 */
public class QuickSort extends AbstractSort{
	/**
	 * 快速排序思路：通过划分 对乱序数组划分为以枢纽点povit为中间点，左边数组的值小于枢纽点， 右边的值大于枢纽点的数组。
	 * 直到划分的数组长度为1， 则该数组默认就是有序的， 停止数组的划分。
	 * 交换时间复杂度O(n*logn)，比较时间复杂度O(n*logn)；
	 * 如果数组为逆序时效率最差，交换时间复杂度和比较时间复杂度为O(n^2);可使用三数据项取中发消除这种影响，即取数组中间、头部、尾部三个数据项中中间大小的数据项为枢纽点
	 * 实现代码如下：
	 */
	
	public QuickSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("快速排序");
	}
	
	public  void sort(int left, int right, int[] randomArray) {		
		// 当数组的元素只有一个时，排序完成
		if(left >= right){
			return ;
		}		
		// 划分完后 postition位置的元素已经是有序数组中的元素了
		int position = partition(left, right, randomArray);
		
		sort(left, position -1, randomArray);
		sort(position + 1, right, randomArray);
		
	}
	
	/**
	 * 
	* @Title: midSort
	* @Description: TODO(三数项取中)
	* @param @param left
	* @param @param right    设定文件
	* @return void    返回类型
	* @author zb 
	* @throws
	 */
	public  void midSort(int left, int right, int[] randomArray) {		
		// 当数组的元素小于4个时，就不能使用3数据项取中了
		if(left + 2 >= right){
			manualSort(left, right, randomArray);
			return;
		}		
		// 划分完后 postition位置的元素已经是有序数组中的元素了
		int position = midPartition(left, right, randomArray);
		
		midSort(left, position -1, randomArray);
		midSort(position + 1, right, randomArray);
		
	}
	
	/**
	 * 
	* @Title: manualSort
	* @Description: TODO(left到right排序)
	* @param @param left
	* @param @param right    设定文件
	* @return void    返回类型
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
	* @Description: TODO(划分函数， 把一个乱序数组分割未以povit枢纽点为中间点， 其左边小于povit， 右边大于povit。也就是说povit所在的位置时归序数组中它所在的位置)
	* @param @param left
	* @param @param right
	* @param @return    设定文件
	* @return int    返回类型
	* @author zb 
	* @throws
	 */
	public  int partition(int left, int right, int[] randomArray) {
		// 默认取数组的第一个数为枢纽点
		int  povit = randomArray[left];	
		int start = left; // 记录枢纽点元素的位置
		// 当left未和right相遇时，就继续下一轮交换
		while(true) {
			// 默认在数组的右侧先开始查找, 因为povit的位置为数组的始点， 所以可以肯定right--的过程中肯定或找到randomArray[right] <= povit的情况，所以可以去掉right>left的判断
			while(randomArray[right] > povit){ // 查找数组中比povit小的数组元素
				this.log.comparePlus();
				right--; 
			}
			// 因为开始left指向povit， 所以left要先自增，不对povit进行交换
			while(++left < right && randomArray[left] < povit) {
				this.log.comparePlus();
			};// 查找数组中比povit大的数组元素
			
			// 交换数组元素				
			if(left < right) {
				int temp = randomArray[left];
				randomArray[left] = randomArray[right];
				randomArray[right] = temp;
				this.log.swapPlus();
			}else{
				break;
			}
			
		}	
		/* left与right已经相遇， 划分完成。无论left与right相遇，还是right与left相遇。
		 * 都可以确定randomArray[right]是小于等于povit的。
		 * 而right左边的都小于povit,右边的都大于povit
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
		// 获取枢纽点的值
		int  povit = midPovit(left, right, randomArray);	
		int start = left; // 记录枢纽点元素的位置
		// 当left未和right相遇时，就继续下一轮交换
		while(true) {
			// 默认在数组的右侧先开始查找, 因为povit的位置为数组的始点， 所以可以肯定right--的过程中肯定或找到randomArray[right] <= povit的情况，所以可以去掉right>left的判断
			while(randomArray[right] > povit){ // 查找数组中比povit小的数组元素
				this.log.comparePlus();
				right--;
			}
			// 因为开始left指向povit， 所以left要先自增，不对povit进行交换
			while(randomArray[++left] < povit) {
				this.log.comparePlus();
			};// 查找数组中比povit大的数组元素
			
			// 交换数组元素				
			if(left < right) {
				int temp = randomArray[left];
				randomArray[left] = randomArray[right];
				randomArray[right] = temp;
				this.log.swapPlus();
			}else{
				break;
			}
			
		}	
		/* left与right已经相遇， 划分完成。无论left与right相遇，还是right与left相遇。
		 * 都可以确定randomArray[right]是小于等于povit的。
		 * 而right左边的都小于povit,右边的都大于povit
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
		int[] randomArray = Provider.getArray(size, 1000);// 获取一个大小为30，最大值为100的乱序数组		
		System.out.println(new QuickSort().showSort(randomArray, "s", true));
	}

}
