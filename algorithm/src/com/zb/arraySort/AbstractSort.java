package com.zb.arraySort;

import com.zb.utils.Provider;

public class AbstractSort implements Sort{
	
	protected Log log = new Log();

	@Override
	public Log showSort(int[] value, String timeSize, boolean isPrintDataItem) {
		// TODO Auto-generated method stub
		if(isPrintDataItem)
			 this.log.setBeforeSort(Provider.printArray(value));
		 long startTime = System.nanoTime();		 
		 this.sort(value);
		 long endTime = System.nanoTime();
		 if(isPrintDataItem)
			 this.log.setAfterSort(Provider.printArray(value));
		 this.log.setUsedTime(Provider.getTime(startTime, endTime, timeSize));
		 this.log.setSize(value.length);
		 return this.log;
	}

	@Override
	public void sort(int[] randomArray) {
		// TODO Auto-generated method stub
		
	}

	
}
