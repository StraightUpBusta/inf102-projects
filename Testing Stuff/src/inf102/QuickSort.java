package inf102;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		// generate unsorted array
		Random rand = new Random();
		int n = 44;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = rand.nextInt(10);
		}
		
		numbers = quickSort(numbers); 
		
		for (int i = 0; i < n; i++) {
			System.out.print(numbers[i]);
		}
	}
	
	public static int[] quickSort(int[] arr) {
		int pivot = arr[arr.length - 1];
		int i = 0;
		int j = 0;
		int temp;
		
		if (arr[i] > pivot) {
			i++;
		} else {
			// swap
			temp = arr[i];
			arr[i] = arr[j];
			arr[j++] = temp;
			
		}
	}
}
