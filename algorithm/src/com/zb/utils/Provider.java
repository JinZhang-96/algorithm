package com.zb.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Provider {

	/**
	 * 
	 * @Title: getArray 
	 * @Description: TODO(��ȡһ����СΪ${@param length}, ���ֵΪ${@param limite}���������� ) 
	 * @param length 
	 * @param limite  
	 * @return int[] ��������
	 * @author zb 
	 * @throws
	 */
	public static int[] getArray(int length, int limite) {
		int[] randomArray = new int[length];
		for (int i = 0; i < length; i++) {
			randomArray[i] = new Random().nextInt(limite);
		}
		return randomArray;
	}

	/**
	 * 
	 * @Title: printArray 
	 * @Description: TODO(������������) 
	 * @param randomArray
	 * @param @return �趨�ļ�
	 * @return String ��������
	 *  @author zb 
	 *  @throws
	 */
	public static String printArray(int[] randomArray) {

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < randomArray.length; i++) {
			buffer.append(randomArray[i]).append(", ");
		}
		String values = buffer.toString();

		return values.substring(0, values.length() - 2);
	}

	public static String getTime(long start, long end, String size) {
		long time = end - start;
		String value;
		switch (size) {
		case "ms":
			value = (new Double(new Long(time).toString())) / Math.pow(10, 6) + "����";
			break;
		case "us":
			value = (new Double(new Long(time).toString())) / Math.pow(10, 3) + "΢��";
			break;
		case "s":
			value = (new Double(new Long(time).toString())) / Math.pow(10, 9) + "��";
			break;
		default:
			value = time + "����";
			break;
		}
		return value;
	}
	
	public static String getTime(long time, String size) {
		String value;
		switch (size) {
		case "ms":
			value = (new Double(new Long(time).toString())) / Math.pow(10, 6) + "����";
			break;
		case "us":
			value = (new Double(new Long(time).toString())) / Math.pow(10, 3) + "΢��";
			break;
		case "s":
			value = (new Double(new Long(time).toString())) / Math.pow(10, 9) + "��";
			break;
		default:
			value = time + "����";
			break;
		}
		return value;
	}
	/**
	 * ���¡һ������
	* @Title: clone
	* @Description: TODO(������һ�仰�����������������)
	* @param @param o
	* @param @return    �趨�ļ�
	* @return Object    ��������
	* @author zb 
	* @throws
	 */
	public static Object clone(Object o) {
		// ������д������
		Object object = null;
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(o);
			// ������ȡ��
			ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			object = objectInputStream.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	public static void main(String[] args) {
		// int s = new Random().nextInt(10);
		// System.out.println(s);

		int a = 0;
		System.out.println(a++);
	}

}
