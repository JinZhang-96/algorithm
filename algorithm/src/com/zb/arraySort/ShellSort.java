package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
 * @ClassName: ShellSort
 * @Description: TODO(希尔排序)
 * @author zb
 * @date 2019年4月13日 下午7:27:38
 *
 */
public class ShellSort extends AbstractSort{

	/**
	 * 希尔排序思路：通过给插入排序添加一个增量因子h，每次对乱序数组相隔h的元素插入排序， 知道h为1结束. 一般增长因子的产生序列为h = 3*h
	 * +1.
	 * 其运行效率很难根据理论分析得出， 但是其增量因子的设计是否合理， 决定了该算法的效率， 一般我们认为， 序列产生的值除了1以外，不能有其他公约数是设计
	 * 该序列生成算法的一项重要准则。根据实际测试效果它的执行效率是要高于插入排序， 适合中等数据的排序， 大数据的排序还是快速排序等高级排序算法更好。
	 * 实现代码如下：
	 */
	
	public ShellSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("希尔排序");
	}

	public void sort(int[] randomArray) {		
		int h = 1;
		// 获取增长因子可取得的最大值
		while (h <= randomArray.length / 3) {
			h = 3 * h + 1;
		}
		// 增长因子递减， 每次都执行以h为间隔的插入排序
		while (h >= 1) {
			for (int i = h; i < randomArray.length; i += h) {
				int value = randomArray[i];
				int j = i;
				// 判断当前元素是否大于要归序的元素， 如果是的话向前移动h个元素
				while (j > 0 && randomArray[j - h] > value) {
					this.log.comparePlus();
					this.log.swapPlus();
					randomArray[j] = randomArray[j - h];
					j -= h;
				}
				this.log.swapPlus();
				// 找到要插入的位置
				randomArray[j] = value;

			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100); // 获取一个大小为30，最大值为100的乱序数组
		System.out.println(new ShellSort().showSort(randomArray, "s", false));
	}

}
