public class LongestAscendingSubArray {
	/**
	 *
	 * @param array
	 * @return longest increasing subarray length
	 * time: o(n) space: o(n)
	 */
	public int longest(int[] array) {
		// Write your solution here
		if (array.length == 0) {
			return 0;
		}
		int global = 1;
		int[] m = new int[array.length];
		m[0] = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				m[i] = 1 + m[i - 1];
				global = Math.max(global, m[i]);
			} else {
				m[i] = 1;
			}
		}
		return global;
	}
}
