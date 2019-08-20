package com.test.datastruct.sort;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2019/8/20
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};

		new QuickSort().quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	private void quickSort(int[] arr, int low, int high) {
		if (low > high) {
			return;
		}

		int i = low;
		int j = high;
		int temp = arr[low];

		while (i < j) {

			while (arr[j] >= temp && i < j) {
				j--;
			}

			while (arr[i] <= temp && i < j) {
				i++;
			}

			if (i < j) {
				int v = arr[j];
				arr[j] = arr[i];
				arr[i] = v;
			}
		}

		arr[low] = arr[i];
		arr[i] = temp;

		quickSort(arr, i + 1, high);
		quickSort(arr, low, i - 1);


	}


}
