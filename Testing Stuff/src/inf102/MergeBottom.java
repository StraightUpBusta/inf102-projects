package inf102;

import java.util.Random;

public class MergeBottom {	
	private static int[] arr;
	
	public static void main(String[] args) {
		// generate unsorted array
		Random rand = new Random();
		int n = 44;
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(10);
		}

		mergeSort();

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
	}

	public static void mergeSort() {
		int N = arr.length;
		for (int sz = 1; sz < N; sz = sz+sz) {
			for (int lo = 0; lo < N-sz; lo += sz+sz) {
				merge(arr, lo, lo+sz, Math.min(lo+sz+sz, N));
			}
		}
	}
	public static void merge(int[] arr, int lo, int mid, int hi) {
		int[] arr1 = new int[mid-lo];
		int[] arr2 = new int[hi-mid];
		System.arraycopy(arr, lo, arr1, 0, mid-lo);
		System.arraycopy(arr, mid, arr2, 0, hi-mid);
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
	}
}

