public class _327CountofRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int res = 0;
		int n = nums.length;
		long[] prefix = new long[n + 1];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				if (prefix[j] - prefix[i] >= lower && prefix[j] - prefix[i] <= upper) {
					res++;
				}
			}
		}
		return res;
	}
}
