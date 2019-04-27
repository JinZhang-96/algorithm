package com.zb.arraySort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;

import com.zb.utils.Provider;

public class TestSortSpeed {
		
	public static void main(String[] args) {
		int size = 1000000;		
		int[] randomArray = Provider.getArray(size, 1000);
		
		int[] randomArray1 = (int[]) Provider.clone(randomArray); 
		int[] randomArray2 = (int[]) Provider.clone(randomArray); 
		int[] randomArray3 = (int[]) Provider.clone(randomArray); 
		int[] randomArray4 = (int[]) Provider.clone(randomArray); 
		int[] randomArray5 = (int[]) Provider.clone(randomArray); 
		int[] randomArray6 = (int[]) Provider.clone(randomArray); 
		
		
		Log log1 = new  BubbleSort().showSort(randomArray, "s", false);
		System.out.println(log1);
		Log log2 = new  SelectSort().showSort(randomArray1, "s", false);
		System.out.println(log2);
		Log log3 = new  InsertSort().showSort(randomArray2, "s", false);
		System.out.println(log3);
		Log log4 = new  ShellSort().showSort(randomArray3, "s", false);
		System.out.println(log4);
		Log log5 = new  QuickSort().showSort(randomArray4, "s", false);
		System.out.println(log5);
		Log log6 = new  MergeSort().showSort(randomArray5, "s", false);
		System.out.println(log6);
		Log log7 = new  BucketSort().showSort(randomArray6, "s", false);
		System.out.println(log7);
		StringBuffer buffer = new StringBuffer();
		buffer
		.append(log1).append("\r\n")
		.append(log2).append("\r\n")
		.append(log3).append("\r\n")
		.append(log4).append("\r\n")
		.append(log5).append("\r\n")
		.append(log6).append("\r\n")
		.append(log7).append("\r\n");
		
		
		File file = new File("F:\\test.txt");
		File pf = file.getParentFile();
		if(!pf.exists()) {
			pf.mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		char [] cbuf = new char[4048];
		try {
			Writer stringWriter = new FileWriter(file, true);
			StringReader reader = new StringReader(buffer.toString());
			while(reader.read(cbuf) > 0){
				stringWriter.write(cbuf);
			}
			reader.close();
			stringWriter.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
