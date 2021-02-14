public class _1760MinimumLimitofBallsinaBag {
	int n = 0;
	public int minimumSize(int[] nums, int maxOperations) {
		// find the 1st max to meet the requirement
		if (nums == null || nums.length == 0) return 0;
		n = nums.length;
		int l = 0, r = 1000000000;
		while (l < r) {
			int mid = l + r >> 1;
			if (isOk(mid, nums, maxOperations)) r = mid;
			else l = mid + 1;
		}
		return l;
	}

	private boolean isOk(int k, int[] nums, int maxOperations) {
		int cnt = 0;
		for (int x : nums) {
			if (x <= k) cnt++;
			else cnt += Math.ceil(x * 1.0 / k);
		}
		return cnt - n <= maxOperations;
	}
}
