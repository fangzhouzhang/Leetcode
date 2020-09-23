public class _1590MakeSumDivisiblebyP {
	public int minSubarray(int[] nums, int p) {
		long sum = 0;
		int n = nums.length;
		int[] prefix = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			prefix[i + 1] = (int)sum;
		}
		if (sum % p == 0) return 0;
		int len = 1;
		while (len < n) {
			for (int start = 0; start + len < n + 1; start++) {
				if ((sum - (prefix[start + len] - prefix[start])) % p == 0) return len;
			}
			len++;
		}
		return -1;
	}
}
