package inf102;

import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		// generate unsorted array
		Random rand = new Random();
		int n = 44;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = rand.nextInt(10);
		}
		
		numbers = mergeSort(numbers);
		
		for (int i = 0; i < n; i++) {
			System.out.print(numbers[i]);
		}
	}
	
	public static int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int[] arr1 = new int[arr.length / 2];
		System.arraycopy(arr, 0, arr1, 0, arr.length / 2);
		int[] arr2 = new int[arr.length - arr.length / 2];
		System.arraycopy(arr, arr.length / 2, arr2, 0, arr.length - arr.length / 2);
		
		arr1 = mergeSort(arr1);
		arr2 = mergeSort(arr2);
		
		return merge(arr1, arr2);
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length + arr2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				res[k++] = arr1[i++];
			} else {
				res[k++] = arr2[j++];
			}
		}
		while (i < arr1.length) {
			res[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			res[k++] = arr2[j++];
		}
		return res;
	}
}
