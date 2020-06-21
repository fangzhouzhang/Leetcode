public class _1486XOROperationinanArray {
	public int xorOperation(int n, int start) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = start + 2 * i;
		}
		if (n == 0) return 0;
		if (n == 1) return start;
		int op = nums[0];
		for (int i = 1; i < n; i++) {
			op ^= nums[i];
		}
		return op;
	}
}
