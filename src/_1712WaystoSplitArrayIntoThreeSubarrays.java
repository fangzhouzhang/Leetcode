public class _1712WaystoSplitArrayIntoThreeSubarrays {
	int M = 1000000007;
	public int waysToSplit(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}
		int limit = sum % 3 == 0 ? sum / 3 : sum / 3 + 1;
		int l = 1, r = n;
		// find the last position to meet s3 >= limit
		while (l < r) {
			int mid = l + r + 1 >> 1;
			if (prefix[n] - prefix[mid] >= limit) l = mid;
			else r = mid - 1;
		}
		int rightPos = l;
		/**
		 from [l, n - 1], s3 >= limit
		 **/
		long res = 0;
		// one flag can be inserted on [2, l]
		// the other flag can be inserted on [1, l - 1]
		// we need to find the first position to let s2 <= s3
		// the last position to let s1 <= s2
		// if they do not overlap, no available solution
		for (int i = 2; i <= rightPos; i++) {
			int s3 = prefix[n] - prefix[i];
			// original idx
			// we need to find the first position to let s2 <= s3
			l = 1;
			r = i - 1;
			if (l == r) {
				if (nums[0] <= nums[1]) {
					res = (res + 1) % M;
				}
			} else {
				while (l < r) {
					int mid = l + r >> 1;
					if (prefix[i] - prefix[mid] <= s3) r = mid;
					else l = mid + 1;
				}
				int left = l;
				// we need to find the last position to let s1 <= s2
				l = 1;
				r = i - 1;
				while (l < r) {
					int mid = l + r + 1 >> 1;
					if (prefix[i] - prefix[mid] >= prefix[mid]) l = mid;
					else r = mid - 1;
				}
				int right = l;
				if (right >= left) {
					res = (res + right - left + 1) % M;
				}
			}
		}
		return (int)res;
	}
}
