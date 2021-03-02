public class _1775EqualSumArraysWithMinimumNumberofOperations {
	public int minOperations(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) return 0;
		if (nums1.length > nums2.length) return minOperations(nums2, nums1);
		int n = nums1.length, m = nums2.length;
		if (m > 6 * n) return -1;
		int[] c1 = new int[7];
		int[] c2 = new int[7];
		for (int x : nums1) c1[x]++;
		for (int x : nums2) c2[x]++;
		int res = Integer.MAX_VALUE;
		for (int i = m; i <= 6 * n; i++) {
			res = Math.min(res, work(i, c1) + work(i, c2));
		}
		return res;
	}

	private int work(int target, int[] a) {
		int sum = 0, res = 0;
		for (int i = 1; i <= 6; i++) {
			sum += i * a[i];
		}
		if (sum > target) {
			int diff = sum - target;
			for (int i = 6; i > 1; i--) {
				int max_diff = i - 1;
				if (a[i] * max_diff >= diff) return res + (diff + max_diff - 1) / max_diff;
				else {
					diff -= a[i] * max_diff;
					res += a[i];

				}
			}
			return res;
		} else {
			int diff = target - sum;
			for (int i = 1; i < 6; i++) {
				int max_diff = 6 - i;
				if (a[i] * max_diff >= diff) return res + (diff + max_diff - 1) / max_diff;
				else {
					diff -= a[i] * max_diff;
					res += a[i];

				}
			}
			return res;
		}
	}
}
