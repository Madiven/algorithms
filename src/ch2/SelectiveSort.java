package ch2;

public class SelectiveSort {

//  Selective-Sort(A)     			          
//	for j = 1 to A.length - 1	n
//		least = j				n-1
//		i = j + 1				n-1
//		while i <= A.length		
//			if A[least] > A[i]
//				least = i
//			i = i + 1
//		temp = A[j]
//		A[j] = A[least]
//		A[least] = temp
	
	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int least = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[least] > a[j]) {
					least = j;
				}
			}
			int temp = a[i];
			a[i] = a[least];
			a[least] = temp;
		}
		assert Sorts.isSorted(a, 0, a.length);
	}
	
	public static void main(String[] args) {
		int[] a = {5, 2, 4, 6, 1, 3, 7, 10, 8, 9};
		sort(a);
		Sorts.show(a);
	}

}
