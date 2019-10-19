public class MaximumSumof3NonOverlappingSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] prefix = new int[nums.length + 1];
		int[] leftMost = new int[nums.length];
		int[] rightMost = new int[nums.length];
		int[] res = {0, 0, 0};
		int n = nums.length;
		int s = 0;
		for (int i = 1; i < prefix.length; i++) {
			s += nums[i - 1];
			prefix[i] = s;
		}
		for (int i = k, max = -1; i <= n - 2 * k; i++) {
			if (prefix[i] - prefix[i - k] > max) {
				max = prefix[i] - prefix[i - k];
				leftMost[i] = i - k;
			} else leftMost[i] = leftMost[i - 1];
		}

		for (int i = n - 2 * k, max = -1; i >= k; i--) {
			if (prefix[i + 2 * k] - prefix[i + k] >= max) {
				max = prefix[i + 2 * k] - prefix[i + k];
				rightMost[i] = i + k;
			} else rightMost[i] = rightMost[i + 1];
		}

		int max = -1;
		for (int i = k; i <= n - 2 * k; i++) {
			if (prefix[leftMost[i] + k] - prefix[leftMost[i]] + prefix[i + k] - prefix[i] + prefix[rightMost[i] + k] - prefix[rightMost[i]] > max) {
				max = prefix[leftMost[i] + k] - prefix[leftMost[i]] + prefix[i + k] - prefix[i] + prefix[rightMost[i] + k] - prefix[rightMost[i]];
				res[0] = leftMost[i];
				res[1] = i;
				res[2] = rightMost[i];
			}
		}
		return res;
	}
}
