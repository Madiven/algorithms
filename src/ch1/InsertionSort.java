package ch1;

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
	
	public static void main(String[] args) {
		int[] a = {5, 2, 4, 6, 1, 3};
		sort(a);
		Sorts.show(a);
	}

}
