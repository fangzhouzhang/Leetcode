public class _410SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		if (nums == null || nums.length == 0) return 0;
		int n = nums.length;
		int[] prefix = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}

		int[][] dp = new int[m + 1][n];
		for (int i = 0; i < n; i++) dp[1][i] = prefix[i + 1];

		for (int i = 2; i < dp.length; i++) {
			for (int j = i - 1; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = i - 1; k <= j; k++) {
					int curMax = Math.max(dp[i - 1][k - 1], prefix[j + 1] - prefix[k]);
					min = Math.min(min, curMax);
				}
				dp[i][j] = min;
			}
		}
		return dp[m][n - 1];
	}

	public int splitArray1(int[] nums, int m) {
		long[] prefix = new long[nums.length + 1];
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefix[i + 1] = sum;
		}

		Long[][] dp = new Long[m + 1][nums.length];



		return (int)dfs(dp, m, nums.length - 1, prefix);
	}

	private long dfs(Long[][] dp, int m, int end, long[] prefix) {
		if (end < 0) return 0;
		if (m > end + 1) return 0;
		if (m == 1) return prefix[end + 1];
		if (dp[m][end] != null) return dp[m][end];

		long min = Integer.MAX_VALUE;
		for (int i = 0; i <= end; i++) {
			min = Math.min(min, Math.max(dfs(dp, m - 1, i, prefix), prefix[end + 1] - prefix[i + 1]));
		}

		dp[m][end] = min;
		return dp[m][end];
	}

	public int splitArrayBinarySearch(int[] nums, int m) {
		if (nums == null || nums.length == 0) return 0;
		int sum = 0, max = Integer.MIN_VALUE;
		for (int x : nums) {
			sum += x;
			max = Math.max(max, x);
		}
		int l = max, r = sum;
		while (l < r) {
			int mid = l + r >> 1;
			if (check(nums, mid, m)) {
				r = mid;
			} else l = mid + 1;
		}
		return r;
	}

	private boolean check(int[] nums, int sum, int intervals) {
		int cur = 0, cnt = 0;
		for (int x : nums) {
			cur += x;
			if (cur > sum) {
				cur = x;
				cnt++;
			}
		}
		return cnt + 1 <= intervals;
	}
}
