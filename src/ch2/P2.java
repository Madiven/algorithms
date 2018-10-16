package ch2;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
