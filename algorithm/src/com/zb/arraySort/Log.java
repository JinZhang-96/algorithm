package com.zb.arraySort;

public class Log {

	private int compareCount;
	private int swapCount;
	private String usedTime;
	private String name;
	private long size;
	private String beforeSort;
	private String afterSort;

	public int getCompareCount() {
		return compareCount;
	}

	public void setCompareCount(int compareCount) {
		this.compareCount = compareCount;
	}

	public int getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(int swapCount) {
		this.swapCount = swapCount;
	}

	public String getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getBeforeSort() {
		return beforeSort;
	}

	public void setBeforeSort(String beforeSort) {
		this.beforeSort = beforeSort;
	}

	public String getAfterSort() {
		return afterSort;
	}

	public void setAfterSort(String afterSort) {
		this.afterSort = afterSort;
	}

	public void comparePlus() {
		this.compareCount += 1;
	}
	
	public void comparePlus(int x) {
		this.compareCount += x;
	}

	public void swapPlus() {
		this.swapCount += 1;
	}
	
	public void swapPlus(int x) {
		this.swapCount += x;
	}

	@Override
	public String toString() {
		return "数组大小：" + size + "," + name + ":用时" + usedTime + ",比较次数为" + compareCount + ",交换次数为" + swapCount + "。\n"
				+ ((beforeSort == null || beforeSort.equals("")) ? "" : "数组排序前：" + beforeSort + "\n")
				+ ((afterSort ==null || afterSort.equals("")) ? "" : "数组排序后：" + afterSort);
	}

}
