package ch2;

import java.util.Random;

public class MergeSort {
    
	private static void merge(int[] a, int p, int q, int r) {
		int[] left = new int[q - p + 1];
		int[] right = new int[r - q];
		
		for (int i = 0; i < left.length; i++) {
			left[i] = a[p + i];
		}
		
		for (int j = 0; j < right.length; j++) {
			right[j] = a[q + j + 1];
		}
		int i = 0, j = 0;
		while (p <= r) {
			if (left[i] <= right[j]) {
				a[p++] = left[i++];
				if (i == left.length) {
					for (;j < right.length; j++) {
						a[p++] = right[j];
					}
					break;
				}
			} else {
				a[p++] = right[j++];
				if (j == right.length) {
					for (;i < left.length; i++) {
						a[p++] = left[i];
					}
					break;
				}
			}
		}
	}
	
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
		assert Sorts.isSorted(a, 0, a.length);
	}
	
	public static void sort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			sort(a, p, q);
			sort(a, q + 1, r);
	        if (a[q] <= a[q + 1]) {
	            return;
	        }
			merge(a, p, q, r);
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int n = 10000;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(n);
		}
		Sorts.show(a);
		System.out.println("---------------");
		sort(a);
		Sorts.show(a);
	}
}


