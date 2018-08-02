public class KthSmallestInTwoSortedArrays {
	/**
	 *
	 * @param A array A
	 * @param B array B
	 * @param k
	 * @return kth smallest number
	 * time: o(logk)	space: o(1)
	 */
	public int kth(int[] A, int[] B, int k) {
		// Write your solution here
		int a_start = 0;
		int b_start = 0;
		while (true) {
			if (a_start >= A.length) {
				return B[b_start + k - 1];
			}
			if (b_start >= B.length) {
				return A[a_start + k - 1];
			}
			if (k == 1) {
				return Math.min(A[a_start], B[b_start]);
			}
			int aval = a_start + k/2 - 1 >= A.length ? Integer.MAX_VALUE : A[a_start + k/2 - 1];
			int bval = b_start + k/2 - 1 >= B.length ? Integer.MAX_VALUE : B[b_start + k/2 - 1];
			if (aval > bval) {
				b_start = b_start + k/2;
			} else {
				a_start = a_start + k/2;
			}
			k = k - k/2;
		}

	}
}
