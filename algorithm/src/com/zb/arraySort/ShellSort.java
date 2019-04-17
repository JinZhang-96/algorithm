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
public class ShellSort extends AbstractSort{

	/**
	 * ϣ������˼·��ͨ���������������һ����������h��ÿ�ζ������������h��Ԫ�ز������� ֪��hΪ1����. һ���������ӵĲ�������Ϊh = 3*h
	 * +1.
	 * ������Ч�ʺ��Ѹ������۷����ó��� �������������ӵ�����Ƿ���� �����˸��㷨��Ч�ʣ� һ��������Ϊ�� ���в�����ֵ����1���⣬������������Լ�������
	 * �����������㷨��һ����Ҫ׼�򡣸���ʵ�ʲ���Ч������ִ��Ч����Ҫ���ڲ������� �ʺ��е����ݵ����� �����ݵ������ǿ�������ȸ߼������㷨���á�
	 * ʵ�ִ������£�
	 */
	
	public ShellSort() {
		// TODO Auto-generated constructor stub
		this.log.setName("ϣ������");
	}

	public void sort(int[] randomArray) {		
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
					this.log.comparePlus();
					this.log.swapPlus();
					randomArray[j] = randomArray[j - h];
					j -= h;
				}
				this.log.swapPlus();
				// �ҵ�Ҫ�����λ��
				randomArray[j] = value;

			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int[] randomArray = Provider.getArray(10000, 100); // ��ȡһ����СΪ30�����ֵΪ100����������
		System.out.println(new ShellSort().showSort(randomArray, "s", false));
	}

}
