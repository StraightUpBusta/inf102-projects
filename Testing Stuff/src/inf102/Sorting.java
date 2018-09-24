package inf102;

import java.util.Random;

public class Sorting {
	public static void main(String[] args) {
		hsort(1);
	}

	public static void hsort(int h) {
		// generate unsorted array
		Random rand = new Random();
		int n = 999;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = rand.nextInt(10);
		}
		
		int temp;
		int j; 
		int k;
		
		for (int i = 0; i < n - h; i++) {
			j = i;
			k = i + h;
			if (numbers[k] < numbers[j]) {
				//swap
				temp = numbers[k];
				numbers[k] = numbers[j];
				numbers[j] = temp;
				// check down
				while (j - h >= 0 && numbers[k - h] < numbers[j - h]) {
					temp = numbers[k - h];
					numbers[k - h] = numbers[j - h];
					numbers[j - h] = temp;
					j = j - h;
					k = k - h;
				}
			}
		}
		for (int i : numbers) {
			System.out.print(i);
		}
	}
	
	public static void insertionSort() {
		// generate unsorted array
		Random rand = new Random();
		int n = 999;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = rand.nextInt(10);
		}
		
		int j;
		int k;
		int temp;
		
		for (int i = 0; i < n - 1; i++) {
			j = i;
			k = i + 1;
			if (numbers[k] < numbers[j]) {
				// swap
				temp = numbers[j];
				numbers[j] = numbers[k];
				numbers[k] = temp;
				
				while (--j >= 0 &&  numbers[--k] < numbers[j]) {
					temp = numbers[j];
					numbers[j] = numbers[k];
					numbers[k] = temp;
				}
			}
		}
		for (int i : numbers) {
			System.out.print(i);
		}
	}
	
	public static void selectionSort() {
		Random rand = new Random();
		int n = 999;
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = rand.nextInt(10);
		}
		
		int lo; // lowest number
		int k = 0; // swap index
		for (int i = 0; i < n; i++) { // sort
			lo = numbers[i];
			for (int j = i + 1; j < n; j++) { // find lowest
				if (numbers[j] < lo) {
					lo = numbers[j];
					k = j;
				}
			}
			numbers[k] = numbers[i]; // swap
			numbers[i] = lo;
		}
		for (int i : numbers) {
			System.out.print(i);
		}
	}
	
	public static void mergeSort() {
		int[] sub1 = {1, 2, 3, 3, 3, 4, 5, 6, 7, 8};
		int[] sub2 = {4, 4, 4, 5, 5, 6, 7, 7, 8, 9};
		// merge subarrays
		int[] result = new int[sub1.length + sub2.length];
		int[] aux = new int[sub1.length + sub2.length];
		int lo = 0;
		int loEnd = sub1.length;
		int hi = sub1.length;
		// copy to aux
		System.arraycopy(sub1, 0, aux, 0, sub1.length);
		System.arraycopy(sub2, 0, aux, sub1.length, sub2.length);
		for (int i = 0; i < aux.length; i++) {
			if (aux[lo] <= aux[hi]) {
				result[i] = aux[lo++];
				if (lo == loEnd) {
					i++;
					for (; i < aux.length; i++) {
						result[i] = aux[hi++];
					}
				}
			} else {
				result[i] = aux[hi++];
				if (hi == aux.length) {
					i++;
					for (; i < aux.length; i++) {
						result[i] = aux[lo++];
					}
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
}
