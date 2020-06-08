public class _1470ShuffletheArray {
	public int[] shuffle(int[] nums, int n) {
		if (n == 0) return new int[0];
		int[] res = new int[2 * n];
		for (int i = 0; i < n; i++) res[i * 2] = nums[i];
		for (int i = n, j = 1; i < 2 * n; i++, j += 2) res[j] = nums[i];
		return res;
	}
}
