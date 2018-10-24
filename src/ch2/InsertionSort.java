package ch2;

import java.util.Random;

public class InsertionSort {

	public InsertionSort() { }
	
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			for (; j >= 0 && key < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = key;
		}
		assert Sorts.isSorted(a, 0, a.length);
	}
	
	public static void sort1(int[] a, int tail) {
		if (tail > 0) {
			sort1(a, tail - 1);
			int key = a[tail];
			int j = tail - 1;
			for (; j >= 0 && key < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = key;
		}
	}
	
	public static void sort2(int[] a) {
		sort1(a, a.length - 1);
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int n = 100;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(n);
		}
		sort2(a);
		Sorts.show(a);
	}

}
