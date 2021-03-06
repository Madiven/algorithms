package ch2;

import java.util.Random;

public class BinarySearch {

	public static int search(int[] a, int k) {
		return search(a, 0, a.length - 1, k);
	}
	
	private static int search(int[] a, int lo, int hi, int k) {
		if (lo > hi) return -1;
		int mi = (lo + hi) / 2;
		if (k < a[mi]) {
			return search(a, lo, mi - 1, k);
		} else if (k > a[mi]) {
			return search(a, mi + 1, hi, k);
		} else {
			return mi;
		}
	}
	
	public static int search2(int[] a, int k) {
		int lo = 0, hi = a.length - 1;
		int mi = 0;
		while (lo <= hi) {
			mi = (lo + hi) / 2;
			if (k < a[mi]) {
				hi = mi - 1;
			} else if (k > a[mi]) {
				lo = mi + 1;
			} else {
				return mi;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int n = 10;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(n);
		}
		MergeSort.sort(a);
		Sorts.show(a);
		System.out.println("---------------");
		System.out.println(search2(a, 5));
	}

}
