package com.jy;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		DataWrap[] dataWraps = new DataWrap[] { new DataWrap(9, ""), new DataWrap(-16, ""), new DataWrap(21, ""),
				new DataWrap(23, ""), new DataWrap(-30, ""), new DataWrap(-49, ""), new DataWrap(21, ""),
				new DataWrap(30, ""), new DataWrap(13, "") };

		System.out.println("排序前：" + Arrays.toString(dataWraps));
		// 开始时间
		long startTime = System.currentTimeMillis();
		shellSort(dataWraps);
		// 结束时间
		long stopTime = System.currentTimeMillis();
		System.out.println("*********************排序结束*********************");
		System.out.println("排序耗时t：" + (stopTime - startTime) + "ms");
		System.out.println("排序后（从小到大）：" + Arrays.toString(dataWraps));
	}

	/**
	 * shell排序
	 * 
	 * @param dataWraps
	 *            待排序数组
	 */
	public static void shellSort(DataWrap[] dataWraps) {
		System.out.println("*********************开始排序*********************");
		int arrayLength = dataWraps.length;
		// 步长h从1开始
		int h = 1;
		// 根据h=h*3+1来求得最大的步长
		while (h <= arrayLength / 3)
			h = h * 3 + 1;
		// 逐步缩短步长进行直接选择排序
		while (h >= 1) {
			System.out.println("*********************步长h：" + h);
			for (int i = h; i < arrayLength; i++) {
				// 保存当前比较的值，当整体后移是保证改值不会丢失
				DataWrap temp = dataWraps[i];
				// 只有当前元素temp比前一个元素小才需要进行下面的操作，否则temp和前面的元素自然就组成排序数组
				if (dataWraps[i].compareTo(dataWraps[i - h]) < 0) {
					int j = i - h;
					// 整体往后移动，直至找到比当前值temp小的值为止
					for (; j >= 0 && dataWraps[j].compareTo(temp) > 0; j -= h)
						dataWraps[j + h] = dataWraps[j];
					// 然后将当前值temp插入到适当的位置
					dataWraps[j + h] = temp;
					// 每一趟后都打印出当前的排序结果
					System.out.println(Arrays.toString(dataWraps));
				}
			}
			// 步长逐渐变短
			h = (h - 1) / 3;
		}
	}

}
