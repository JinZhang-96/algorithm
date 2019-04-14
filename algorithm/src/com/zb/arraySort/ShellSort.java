package com.zb.arraySort;

import com.zb.utils.Provider;

/**
 * 
 * @ClassName: ShellSort
 * @Description: TODO(ϣ������)
 * @author zb
 * @date 2019��4��13�� ����7:27:38
 *
 */
public class ShellSort {

	/**
	 * ϣ������˼·��ͨ���������������һ����������h��ÿ�ζ������������h��Ԫ�ز������� ֪��hΪ1����. һ���������ӵĲ�������Ϊh = 3*h
	 * +1.
	 * ������Ч�ʺ��Ѹ������۷����ó��� �������������ӵ�����Ƿ���� �����˸��㷨��Ч�ʣ� һ��������Ϊ�� ���в�����ֵ����1���⣬������������Լ�������
	 * �����������㷨��һ����Ҫ׼�򡣸���ʵ�ʲ���Ч������ִ��Ч����Ҫ���ڲ������� �ʺ��е����ݵ����� �����ݵ������ǿ�������ȸ߼������㷨���á�
	 * ʵ�ִ������£�
	 */

	public static int[] sort(int[] randomArray) {
		int[] data = { 0, 0 };
		int h = 1;
		// ��ȡ�������ӿ�ȡ�õ����ֵ
		while (h <= randomArray.length / 3) {
			h = 3 * h + 1;
		}
		// �������ӵݼ��� ÿ�ζ�ִ����hΪ����Ĳ�������
		while (h >= 1) {
			for (int i = h; i < randomArray.length; i += h) {
				int value = randomArray[i];
				int j = i;
				// �жϵ�ǰԪ���Ƿ����Ҫ�����Ԫ�أ� ����ǵĻ���ǰ�ƶ�h��Ԫ��
				while (j > 0 && randomArray[j - h] > value) {
					data[0] += 1;
					data[1] += 1;
					randomArray[j] = randomArray[j - h];
					j -= h;
				}
				data[0] +=1;
				// �ҵ�Ҫ�����λ��
				randomArray[j] = value;

			}
			h = (h - 1) / 3;
		}
		return data;
	}

	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100); // ��ȡһ����СΪ30�����ֵΪ100����������
		int[] randomArray2 = (int[]) Provider.clone(randomArray);
		
		System.out.println("����ǰ��" + Provider.printArray(randomArray));
		long startTime = System.nanoTime();
		int[] data = ShellSort.sort(randomArray);
		long endTime = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data[0] + "�Σ� ���Ƚ�" + data[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime, endTime, ""));
		
		
		System.out.println("����ǰ��" + Provider.printArray(randomArray2));
		long startTime2 = System.nanoTime();
		int [] data2 = InsertSort.sort(randomArray2);
		long endTime2 = System.nanoTime();
		System.out.println("�����" + Provider.printArray(randomArray));
		System.out.println("������" + data2[0] + "�Σ� ���Ƚ�" + data2[1] + "�Ρ�");
		System.out.println("����ʱ��" + Provider.getTime(startTime2, endTime2, ""));
		
		
		
	}

}
