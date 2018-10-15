package ch1;

public class Sorts {

    public static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }
	
    public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
