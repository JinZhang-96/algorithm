package com.zb.utils;

import java.util.Random;

public class Provider {
	
	/**
	 * 
	* @Title: getArray
	* @Description: TODO(获取一个大小为${@param length}, 最大值为${@param limite}的乱序数组 )
	* @param @param length
	* @param @param limite
	* @param @return    设定文件
	* @return int[]    返回类型
	* @author zb 
	* @throws
	 */
	public static int[] getArray(int length, int limite){
		int [] randomArray = new int[length];
		for(int i = 0; i < length; i++ ) {
			randomArray[i] = new Random().nextInt(limite);
		}
		return randomArray;
	}
	
	/**
	 * 
	* @Title: printArray
	* @Description: TODO(输出数组的数据)
	* @param @param randomArray
	* @param @return    设定文件
	* @return String    返回类型
	* @author zb 
	* @throws
	 */
	public  static  String printArray(int[] randomArray){
		
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 0; i< randomArray.length; i++){
			buffer.append(randomArray[i])
			.append(", ");
		}		
		String values = buffer.toString();
		
		return values.substring(0, values.length() - 2 );
	}
	
	
	public static String getTime(long start, long end, String size){
		long time = end - start;
		String value;
		switch (size) {
		case "ms":
			value = (new  Double(new Long(time).toString()))/Math.pow(10, 6)+"毫秒";
			break;
		case "us":
			value = (new  Double(new Long(time).toString()))/Math.pow(10, 3)+"毫秒";
			break;
		case "s":
			value = (new  Double(new Long(time).toString()))/Math.pow(10, 9) +"秒";
			break;
		default:
			value = time+"纳秒";
			break;
		}		
		return value;
	}
	
	
	
	public static void main(String[] args) {
//		int s = new Random().nextInt(10);
//		System.out.println(s);
		
		int a = 0;
		System.out.println(a++);
	}
	
}
