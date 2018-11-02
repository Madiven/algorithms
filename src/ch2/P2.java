package ch2;

import java.util.Random;

/**
 * 第二章习题
 * @author Administrator
 *
 */
public class P2 {

	/**
	 * 2.1-3
	 * @param a
	 * @param v
	 * @return
	 */
	public static int search(int[] a, int v) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == v) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 2.1-4
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] add(int[] a, int[] b) {
		int[] c = new int[a.length + 1];
		int carry = 0;
		for (int i = 0; i < a.length; i++) {
			int result = a[i] + b[i] + carry;
			c[i] = result % 2;
			if (result >= 2) {
				carry = 1;
			} else {
				carry = 0;
			}
		}
		c[a.length] = carry;
		return c;
	}
	
	/******************思考题2-1******************/
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
	
	private static void sort(int[] a, int p, int r) {
		if (p < r) {
	        if (r <= p + 7) { 
	            insertionSort(a, p, r);
	            return;
	        }
			int q = (p + r) / 2;
			sort(a, p, q);
			sort(a, q + 1, r);
	        if (a[q] <= a[q + 1]) {
	            return;
	        }
			merge(a, p, q, r);
		}
	}
	
	private static void insertionSort(int[] a, int p, int r) {
		for (int i = p + 1; i <= r; i++) {
			int key = a[i];
			int j = i - 1;
			for (; j >= p && key < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = key;
		}
	}
	/************************************/
	
	/******************思考题2-4******************/
	 	private static int getPairCountEachPart(int[] a, int p, int q, int r, int count) {
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
					count += left.length - i;
					if (j == right.length) {
						for (;i < left.length; i++) {
							a[p++] = left[i];
						}
						break;
					}
				}
			}
			return count;
		}
		
		public static int getSequencePairCount(int[] a) {
			return getSequencePairCount(a, 0, a.length - 1);
		}
		
		public static int getSequencePairCount(int[] a, int p, int r) {
			int left = 0, right = 0;
			if (p < r) {
				int q = (p + r) / 2;
				left = getSequencePairCount(a, p, q);
				right = getSequencePairCount(a, q + 1, r);
		        if (a[q] <= a[q + 1]) {
		            return left + right;
		        }
				return getPairCountEachPart(a, p, q, r, left + right);
			}
			return 0;
		}
	/************************************/
	
	public static void main(String[] args) {
		Random random = new Random();
		int n = 5;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(n);
		}
//		int[] a = {1, 1, 1, 3, 0};
		Sorts.show(a);
		System.out.println("---------------");
		System.out.println(getSequencePairCount(a));
	}
}
